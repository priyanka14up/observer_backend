package Observer20.Controller;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
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

@RestController
@RequestMapping("/api/observers")
public class sendVerifyOtpController {

   
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
   // private Map<String, OtpAttempt> otpAttempts = new HashMap<>();
    private Map<String, OtpInfo> otpInfoMap = new HashMap<>();

    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtpWithObscode(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String obscode = requestBody.get("obscode");
        String email = requestBody.get("email");
        String mobnum = requestBody.get("mobnum");
        

        // Check if any of the fields are missing
        if (obscode == null || email == null || mobnum == null) {
            return ResponseEntity.badRequest().body("Invalid request. Please provide obscode, email, and mobnum.");
        }

        ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(obscode);

        // Check if obscode, email, and mobnum match
        if (observerUser == null || !observerUser.getEmail().equals(email) || !String.valueOf(observerUser.getMobnum()).equals(mobnum)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid obscode, email, or mobnum.");
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
        String smsMessage = "Your OTP is = " + otp + " for Observer Portal. Kindly don't share it with anyone.";
        
        boolean gupshupApiSuccess = sendOtpViaGupshupApi(Long.parseLong(mobnum), smsMessage);
        //boolean emailServiceSuccess = sendOtpViaEmail(email, "Your OTP Code", smsMessage);
        // Send OTP via email or mobile (implement your sending logic here)
        boolean emailServiceSuccess = sendOtpViaEmail(observerUser.getEmail(), "Your OTP Code", String.valueOf(otp));


        if (gupshupApiSuccess && emailServiceSuccess) {
        	 if (otpInfo == null) {
                 otpInfoMap.put(obscode, new OtpInfo(System.currentTimeMillis(), 1));
             } else {
                 otpInfo.setRequestCount(otpInfo.getRequestCount() + 1);
             }

            session.setAttribute("emailOtp", otp);
            session.setAttribute("mobileOtp", otp);
            session.setAttribute("email", email);
            session.setAttribute("mobnum", Long.parseLong(mobnum));
            session.setAttribute("obscode", obscode);
            return ResponseEntity.ok("Sent OTP to your email and mobile successfully.");
        } else {
            session.setAttribute("message", "Error sending OTP. Please try again.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending OTP.");
        }
    }

	/*
	 * @PostMapping("/verify-otp1") public ResponseEntity<String>
	 * verifyotp1(@RequestParam("otp") int otp, HttpSession session) { String
	 * obscode = (String) session.getAttribute("obscode"); OtpInfo attempt =
	 * OtpInfo.get(obscode);
	 * 
	 * if (attempt == null || (attempt.getAttempts() >= MAX_OTP_ATTEMPTS &&
	 * System.currentTimeMillis() - attempt.getLastAttemptTime() <
	 * OTP_ATTEMPT_TIMEOUT)) { return
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).
	 * body("Invalid OTP or exceeded maximum attempts."); }
	 * 
	 * Integer emailOtp = (Integer) session.getAttribute("emailOtp"); Integer
	 * mobileOtp = (Integer) session.getAttribute("mobileOtp"); String email =
	 * (String) session.getAttribute("email"); Long phoneNumber = (Long)
	 * session.getAttribute("mobnum");
	 * 
	 * if (otp == emailOtp || otp == mobileOtp) { ObserverUser observerUser =
	 * observerUserRepo.getObserverUserByEmail(email); if (observerUser == null) {
	 * session.setAttribute("message", "User does not exist with this email id");
	 * return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist"); }
	 * else { return ResponseEntity.ok("OTP is valid"); } } else { boolean
	 * isMobileOtpValid = verifyMobileOtpWithGupshup(String.valueOf(phoneNumber),
	 * otp); if (isMobileOtpValid) { return ResponseEntity.ok("OTP is valid"); }
	 * else { session.setAttribute("message", "You have entered the wrong OTP");
	 * return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP"); }
	 * } }
	 */

    private boolean sendOtpViaGupshupApi(long mobnum, String smsMessage) {
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

    private boolean verifyMobileOtpWithGupshup(String mobnum, int otp) {
    	String apiUrl = String.format("https://enterprise.smsgupshup.com/GatewayAPI/rest?userid=%s&password=%s&method=TWO_FACTOR_AUTH&v=1.1&phone_no=91%s&otp_code=%d",
                gupshupUserId, gupshupPassword, mobnum, otp);


        try {
            String response = restTemplate.getForObject(apiUrl, String.class);

            

            return response != null && response.contains("success:true");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return false;
        }
    }

   
    
}
