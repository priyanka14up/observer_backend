package Observer20.Controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import Observer20.Model.SmsPojo;
import Observer20.Model.StoreOtp;
import Observer20.Model.TempOtp;
import Observer20.Services.SmsService;

@RestController
@RequestMapping("/api/observers")
public class SMSController {
	@Autowired
	SmsService smsService;
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	private final String TOPIC_DESTINATION="/lesson/sms";
	
	@PostMapping("/mobileNo")
	public ResponseEntity<String> smsSubmit(@RequestBody SmsPojo sms)
	{
		try
		{
			//System.out.println(sms.getPhoneNo());
			System.out.println("hello");
			smsService.send(sms);
			System.out.println("hello");
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("something problem",HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
		 webSocket.convertAndSend(TOPIC_DESTINATION,getTimeStamp() +":sms has been sent:"+sms.getPhoneNo());
		 return new ResponseEntity<String>("OTP sent successfully",HttpStatus.OK);
		
		
		
	}
	@PostMapping("/otp")
	public String varifyOtp(@RequestBody TempOtp sms)
	{
		if(sms.getOtp()==StoreOtp.getOtp())
			//StoreOtp.getOtp()
		return "Otp is correct";
		else
			return "Otp is not correct";
		
	}

	
	  private String getTimeStamp() { 
		
	  return DateTimeFormatter.ofPattern("yyyy-mm-dd HH-mm-ss").format(LocalDateTime.now());
	  }
	 

}
