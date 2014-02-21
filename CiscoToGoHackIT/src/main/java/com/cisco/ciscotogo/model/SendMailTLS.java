package com.cisco.ciscotogo.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTLS {
 
	public void sendEmail(String name, String email, int messageType) {
		String messageText;
		if(messageType == 1) {
			messageText = "\n\n Your order is hella ready, bro! \n\n Please come down to the cafe to retrieve your order. \n\n Thanks for using Cisco TOGO!";
		}
		else if(messageType == 2) {
			messageText = "\n\n We've received your order and are currently processing your request. \n\n We will send an email when it is ready for pickup. \n\n Thanks for using Cisco TOGO!";
		}
		else messageText = "Error";
		
		final String username = "cisco.togo.noreply@gmail.com";
		final String password = "ciscotogo";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply-ciscoTOGO@cisco.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Cisco TOGO!");
			message.setText("Dear " + name +","
				+ messageText);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}