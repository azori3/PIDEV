package com.esprit.pidev.util;

import java.util.Date;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.esprit.pidev.interfaces.SendEmailService;


@Stateless
@LocalBean
public class EmailSender implements SendEmailService {
	

	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	public void SenEmailWithAttachmet(String EmailDenv,String password,String Subject,String Email,String classe)
	{		
		
		

		boolean flag = false;

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.auth", "true");

		props.put("mail.debug", "true");

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.socketFactory.port", "587");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props, new javax.mail.Authenticator()

		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EmailDenv, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EmailDenv));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
			message.setSubject(classe);
			message.setContent(Subject, "text/html; charset=utf-8");
			message.setSentDate(new Date());
			Transport.send(message);
			flag = true;
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Done");
	}
		


	
	@Override
	 public void SendMail()
	 {
 
		final String username = "hichem.alouis123@gmail.com";

		final String password = "tunis123456";

		boolean flag = false;

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.auth", "true");

		props.put("mail.debug", "true");

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.socketFactory.port", "587");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props, new javax.mail.Authenticator()

		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hichem.alouis123@gmail.com"));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ali.methnani@esprit.tn"));
			message.setSubject("aaaaaaa");
			message.setContent("aaaaaaa", "text/html; charset=utf-8");

			Transport.send(message);
			flag = true;
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Done");
	}
	
	
}


