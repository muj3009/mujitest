package sboot.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	
	public void send(String to, String subject, String body) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true indicates
													   // multipart message
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true indicates html
		// continue using helper object for more functionalities like adding attachments, etc.  
		
		javaMailSender.send(message);
		
		
	}

}