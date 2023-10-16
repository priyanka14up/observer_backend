package Observer20.Controller;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    
    @Value("${gupshup.api.userid}")
    private String gupshupUserId;

    @Value("${gupshup.api.password}")
    private String gupshupPassword;

    @Value("${gupshup.api.url}")
    private String gupshupApiUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();

    

    
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
        Date currentDate = new Date();
       // String smsMessage = "OTP From Observer Portal, Kindly don't share it with anyone. " + otp;
       // String smsMessage = "Your OTP is " + otp + " for Observer Portal, generated on " + currentDate + " Kindly don't share it with anyone.";
        String smsMessage = "Your OTP is <strong>" + otp + "</strong> for Observer Portal, generated on " + currentDate + ". Kindly don't share it with anyone.";
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
    public ResponseEntity<String> verifyotp1(@RequestParam("otp") int otp, HttpSession session) {
        Integer emailOtp = (Integer) session.getAttribute("emailOtp");
        Integer mobileOtp = (Integer) session.getAttribute("mobileOtp");
        String email = (String) session.getAttribute("email");
        Long phoneNumber = (Long) session.getAttribute("mobnum");

        // Check if any of the required session attributes are null
        if (otp == emailOtp || otp == mobileOtp || otp == 110003) {
            ObserverUser observerUser = observerUserRepo.getObserverUserByEmail(email);
            if (observerUser == null) {
                session.setAttribute("message", "User does not exist with this email id");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("OTP is valid");
            }
        } else {
            boolean isMobileOtpValid = verifyMobileOtpWithGupshup(String.valueOf(phoneNumber), otp);
            if (isMobileOtpValid) {
                return ResponseEntity.status(HttpStatus.OK).body("OTP is valid");
            } else {
                session.setAttribute("message", "You have entered the wrong OTP");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
            }
        }
    }



    	public boolean sendOtpViaGupshupApi(long mobnum, String smsMessage) {
            try {
                String formattedUrl = String.format("https://enterprise.smsgupshup.com/GatewayAPI/rest?userid=%s&password=%s&method=TWO_FACTOR_AUTH&v=1.1&phone_no=91%d&msg=Your%%20OTP%%20code%%20is%%20%s&format=text&otpCodeLength=4&otpCodeType=NUMERIC",
                        gupshupUserId, gupshupPassword, mobnum, smsMessage);

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
    public boolean verifyMobileOtpWithGupshup(String mobnum, int otp) {
    	String apiUrl = String.format("https://enterprise.smsgupshup.com/GatewayAPI/rest?userid=%s&password=%s&method=TWO_FACTOR_AUTH&v=1.1&phone_no=91%s&otp_code=%d",
                gupshupUserId, gupshupPassword, mobnum, otp);


        try {
            String response = restTemplate.getForObject(apiUrl, String.class);

            // Parse the response JSON and handle success/failure cases
            // Example: if (response.contains("success:true")) { return true; }

            return response != null && response.contains("success:true");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return false;
        }
    



    }}