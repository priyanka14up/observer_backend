package Observer20.Services;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public boolean sendEmail(String subject,String message,String to)
	{
		boolean f=false;
		String from="eci921693@gmail.com";
		//variabale for gmail
		String host="smtp.gmail.com";
		
		Properties  properties=System.getProperties();
		System.out.println("Properties"+properties);
		//setting important information to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step 1: to get the session object
		Session session	=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("eci921693@gmail.com", "dnybgjowedvtbzvo");
			}
			//dnybgjowedvtbzvo
		
			
		});
		session.setDebug(true);
		
		//setp:2 compose the emssage
		MimeMessage m=new MimeMessage(session);
		try
		{
			// from email
			m.setFrom(from);
			// adding reciepent to message
			m.addRecipient(Message.RecipientType.TO,new  InternetAddress(to));
			//adding subject to message
			m.setSubject(subject);
			//adding text to message
			m.setText(message);
			//m.setContent(message,"text/html");
			//send
			
			//setp3: send the message using transport class
			Transport.send(m);
			System.out.println("Sent successfuly.......");
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	

}
