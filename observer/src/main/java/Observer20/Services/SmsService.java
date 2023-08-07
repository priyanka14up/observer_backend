package Observer20.Services;

import java.text.ParseException;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Observer20.Model.SmsPojo;
import Observer20.Model.StoreOtp;
@Service
public class SmsService {

	private String Account_Sid="AC024fe836e918f084c98f26a0d435f50c";
	private String Auth_Token="f658e3a58667d7e788481afdd6b24c0f";
    private String From_Number="+12512446173";
    
    public void send(SmsPojo sms) throws ParseException
    {
    	Twilio.init(Account_Sid,Auth_Token);
    	int min=100000;
    	int max=999999;
    	int number=(int)(Math.random()*(max-min+1)+min);
    	System.out.println(number);
    	String msg="your Otp-"+number+"Please Verify this Otp in your application";
    	Message message=Message.creator(new PhoneNumber(sms.getPhoneNo()),new PhoneNumber(From_Number),msg).create();
    	StoreOtp.setOtp(number);
    }
	/*
	 * public void receive(MultiValueMap<String ,String> smscallback) {
	 * 
	 * }
	 */
}
