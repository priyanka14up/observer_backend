package Observer20.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	Random random=new Random(1000);
	
	@PostMapping("/send-otp")
	public String sendOtp(@RequestParam("email") String email,HttpSession session)
	{
		System.out.println("Email:"+ email);
		
		//Generate Otp 4 digit
		
		int otp=random.nextInt(999999);
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
			 return "varifiy-otp";
			
		}
	}
	
	  //varify otp 
	@PostMapping("/varify-otp")
	public String varifyotp(@RequestParam("otp") int otp,HttpSession session) { 
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
			return "varify-otp";
	  
	  }
	
	}

	
	  //change password
	  
	  @PostMapping("/change-password") 
	  public String changePassword(@RequestParam("newpassword") String newpassword , @RequestParam("email") String email,HttpSession session) { 
		  
		  //String email1=(String)session.getAttribute("email"); 
		  ObserverUser observerUser=observerUserRepo.getObserverUserByEmail(email);
		 // observerUser.setPassword(passwordEncoder.encode(newpassword));
		  observerUser.setPassword(DigestUtils.md5DigestAsHex(newpassword.getBytes()));
		  observerUserRepo.save(observerUser);
		   return "password changed successfully";
	  
	  }
	  //@RequestParam("email") String email

}

