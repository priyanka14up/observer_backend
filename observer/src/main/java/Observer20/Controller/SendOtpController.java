package Observer20.Controller;

import Observer20.Model.ObserverUser;
import Observer20.Services.EmailService;
import Observer20.payloads.OtpInfo;
import Observer20.repository.ObserverUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/observers")
public class SendOtpController {

    @Autowired
    private ObserverUserRepo observerUserRepo;
    private Map<String, OtpInfo> otpInfoMap = new HashMap<>();

    @Autowired
    private EmailService emailService;

    @Value("${gupshup.api.userid}")
    private String gupshupUserId;

    @Value("${gupshup.api.password}")
    private String gupshupPassword;

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/send-otp1")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String obscode = requestBody.get("obscode");
        String email = requestBody.get("email");
        ObserverUser observerUser = observerUserRepo.findByObscode(obscode);

        if (observerUser == null) {
            return new ResponseEntity<>("Invalid obscode.", HttpStatus.BAD_REQUEST);
        }

        // Check if the user has exceeded the maximum OTP request limit (3 times)
        OtpInfo otpInfo = otpInfoMap.get(obscode);
        int maxAttempts = 3; // Maximum OTP request attempts
        if (otpInfo != null && otpInfo.getRequestCount() >= maxAttempts) {
            long timeRemaining = (otpInfo.getTimestamp() + (30 * 60 * 1000) - System.currentTimeMillis()) / 1000;
            return new ResponseEntity<>("Exceeded maximum OTP request limit. Please try again after " + timeRemaining + " seconds.", HttpStatus.TOO_MANY_REQUESTS);
        }

        int min = 1000;
        int max = 9999;
        int otp = (int) (Math.random() * (max - min + 1) + min);

        // Send OTP via email or mobile (implement your sending logic here)
        boolean emailServiceSuccess = sendOtpViaEmail(observerUser.getEmail(), "Your OTP Code", String.valueOf(otp));

        if (emailServiceSuccess) {
            // Update OTP info
            if (otpInfo == null) {
                otpInfoMap.put(obscode, new OtpInfo(System.currentTimeMillis(), 1));
            } else {
                otpInfo.setRequestCount(otpInfo.getRequestCount() + 1);
            }

            // Return success message
            return new ResponseEntity<>("Sent OTP to your email successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error sending OTP. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    

    private boolean sendOtpViaEmail(String email, String subject, String message) {
        return emailService.sendEmail(subject, message, email);
    }
}
