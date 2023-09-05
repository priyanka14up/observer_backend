package Observer20.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Observer20.Model.ChangePasswordRequest;
import Observer20.Model.ChangePasswordRequest1;
import Observer20.Model.ObserverUser;
import Observer20.Services.EmailService;
import Observer20.repository.ObserverUserRepo;

@RestController
@RequestMapping("/api/observers")
public class ForgotController {
	@Autowired
	EmailService emailService;
	@Autowired
	ObserverUserRepo observerUserRepo;
	//@Autowired
	//private BCryptPasswordEncoder bcrypt;
	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */
	Random random=new Random(10000);
	
	@PostMapping("/send-otp")
	public String sendOtp(@RequestParam("email") String email,HttpSession session)
	{
		System.out.println("Email:"+ email);
		
		//Generate Otp 4 digit
		
		//int otp=random.nextInt(999999);
		
		int min=100000;
    	int max=999999;
    	int otp=(int)(Math.random()*(max-min+1)+min);
    	System.out.println("OTP:"+otp);
		//Write a code for send to email
		
		  String subject="OTP From ECI"; 
		  String message="Otp:"+otp; 
		  String to=email;
		  boolean flag=emailService.sendEmail(subject,message,to);
		 if(flag)
		{ 
			 session.setAttribute("myotp", otp);
			 session.setAttribute("email", email);
			return ("Sent OTP to your email Successfuly.....");
			
		}
		else
		{
			session.setAttribute("message", "Check your Email id!!");
			 return "verifiy-otp";
			
		}
	}
	
	  //varify otp 
	@PostMapping("/verify-otp")
	public String verifyotp(@RequestParam("otp") int otp,HttpSession session) { 
		int myotp =(int)session.getAttribute("myotp");
		String email=(String)session.getAttribute("email"); 
		if(myotp==otp) 
		{ 
			ObserverUser observerUser=observerUserRepo.getObserverUserByEmail(email);
	  if(observerUser==null) 
	  { 
		  // send error message
	  session.setAttribute("message", "User does not exist with this email id"); 
	  return "user does not exist";
	  }
	  else { //send changed password form
	  
	  return "password change form"; 
	  } }
		else {
			session.setAttribute("message","you have entered wrong otp");
			return "Otp is not valid ";
	  
	  }
	
	}

	
	 
	@PostMapping("/change-password")
	public String changePassword(@RequestBody ChangePasswordRequest request, HttpSession session) {
	    // Fetch the user based on the provided obscode
	    ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(request.getObscode());

	    if (observerUser == null) {
	        return "User does not exist.";
	    }

	    // Check if the old password matches the stored MD5 password
	    String storedMd5Password = observerUser.getPassword();
	    String oldPasswordMd5 = DigestUtils.md5DigestAsHex(request.getOldpassword().getBytes());

	    if (!storedMd5Password.equals(oldPasswordMd5)) {
	        return "Old password is incorrect.";
	    }

	    observerUser.setPassword(DigestUtils.md5DigestAsHex(request.getNewpassword().getBytes()));
	    observerUserRepo.save(observerUser);

	    return "Password changed successfully.";
	}
	

	
	@PostMapping("/change-password1")
	public String changePassword1(@RequestBody ChangePasswordRequest1 request1, HttpSession session) {
	    // Update the password for the provided obscode
	    ObserverUser observerUser = observerUserRepo.getObserverUserByobscode(request1.getObscode());

	    if (observerUser == null) {
	        return "User does not exist.";
	    }

	    // Update the password to the new password without checking the old password
	    observerUser.setPassword(DigestUtils.md5DigestAsHex(request1.getNewpassword().getBytes()));
	    observerUserRepo.save(observerUser);

	    return "Password changed successfully.";
	}



	}

	  



