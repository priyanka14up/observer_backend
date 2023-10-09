package Observer20.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import Observer20.Model.ObserverUser;
import Observer20.Services.EmailService;
import Observer20.payloads.EmailRequest;
import Observer20.repository.ObserverUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/observers")
public class SendOtpController {

    @Autowired
    private ObserverUserRepo observerUserRepo;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-otp/{obscode}")
    public String sendOtpWithObscode(@PathVariable String obscode, HttpSession session) {
        ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(obscode);

        if (observerUser == null) {
            session.setAttribute("message", "Invalid obscode.");
            return "Invalid obscode.";
        }

        int min = 1000;
        int max = 9999;
        int otp = (int) (Math.random() * (max - min + 1) + min);

        String smsMessage = "Your OTP code is " + otp;

        boolean gupshupApiSuccess = sendOtpViaGupshupApi(observerUser.getMobnum(), smsMessage);
        boolean emailServiceSuccess = sendOtpViaEmail(observerUser.getEmail(), "Your OTP Code", smsMessage);

        if (gupshupApiSuccess && emailServiceSuccess) {
            session.setAttribute("emailOtp", otp);
            session.setAttribute("mobileOtp", otp);
            session.setAttribute("email", observerUser.getEmail());
            session.setAttribute("phoneNumber", observerUser.getMobnum());
            return "Sent OTP to your email and mobile Successfully.....";
        } else {
            session.setAttribute("message", "Error sending OTP. Please try again.");
            return "verify-otp";
        }
    }

    @PostMapping("/verify-otp1")
    public String verifyotp1(@RequestParam("otp") int otp, HttpSession session) {
        Integer emailOtp = (Integer) session.getAttribute("emailOtp");
        Integer mobileOtp = (Integer) session.getAttribute("mobileOtp");
        String email = (String) session.getAttribute("email");
        long phoneNumber = (long) session.getAttribute("phoneNumber");

        if (otp == emailOtp || otp == mobileOtp) {
            ObserverUser observerUser = observerUserRepo.getObserverUserByEmail(email);
            if (observerUser == null) {
                session.setAttribute("message", "User does not exist with this email id");
                return "user does not exist";
            } else {
                return "password change form";
            }
        } else {
            boolean isMobileOtpValid = verifyMobileOtpWithGupshup(String.valueOf(phoneNumber), otp);
            if (isMobileOtpValid) {
                return "OTP is correct";
            } else {
                session.setAttribute("message", "You have entered the wrong OTP");
                return "Otp is not valid";
            }
        }
    }

    private boolean sendOtpViaGupshupApi(long phoneNumber, String smsMessage) {
        // Prepare the Gupshup API URL
        try {
            String formattedUrl = String.format(
                    "https://enterprise.smsgupshup.com/GatewayAPI/rest?userid=%s&password=%s&method=TWO_FACTOR_AUTH&v=1.1&phone_no=%s&msg=%s&format=text&otpCodeLength=4&otpCodeType=NUMERIC",
                    "2000189478", "GmUJ58", phoneNumber, smsMessage);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(formattedUrl, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Gupshup API Response: " + response.getBody());
                return true;
            } else {
                System.out.println("Gupshup API Error: " + response.getBody());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean sendOtpViaEmail(String email, String subject, String message) {
        return emailService.sendEmail(subject, message, email);
    }

    private boolean verifyMobileOtpWithGupshup(String phoneNumber, int otp) {
        String apiEndpoint = "https://enterprise.smsgupshup.com/GatewayAPI/rest";
        String userId = ""; // Your Gupshup API User ID
        String password = ""; // Your Gupshup API Password
        String method = "TWO_FACTOR_AUTH";
        String phoneNo = "91" + phoneNumber; // Prefix '91' for India country code
        String otpCode = String.valueOf(otp);

        String apiUrl = apiEndpoint + "?userid=" + userId + "&password=" + password +
                        "&method=" + method + "&v=1.1&phone_no=" + phoneNo + "&otp_code=" + otpCode;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);

       
        return response != null && response.contains("success:true");
    }



}
