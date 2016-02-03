package com.poochiku.suraksha.component.helper;

import java.util.Properties;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email
{

	public void SendHTMLEmail(String to,String subject,String text,String html)
	{

		String username = "poochiku.suraksha@gmail.com";
		String usernameDisplay = "roReply@poochiku.com";
		String password = "Valdamir@1988";
		Properties props = System.getProperties();

		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(props, null);
		MimeMessage message = new MimeMessage(session);

		System.out.println("Port: " + session.getProperty("mail.smtp.port"));

		// Create the email addresses involved
		try
		{
			InternetAddress from = new InternetAddress("usernameDisplay");
			message.setSubject(subject);
			message.setFrom(from);
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Create a multi-part to combine the parts
			Multipart multipart = new MimeMultipart("alternative");

			// Create your text message part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(text);

			// Add the text part to the multipart
			multipart.addBodyPart(messageBodyPart);

			// Create the html part
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(html, "text/html");

			// Add html part to multi part
			multipart.addBodyPart(messageBodyPart);

			// Associate multi-part with message
			message.setContent(multipart);

			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", username, password);
			System.out.println("Transport: " + transport.toString());
			transport.sendMessage(message, message.getAllRecipients());

		}
		catch (AddressException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
