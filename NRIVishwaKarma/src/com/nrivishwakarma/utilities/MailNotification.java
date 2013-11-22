package com.nrivishwakarma.utilities;

	import java.util.Properties;

	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

	public class MailNotification {
		String mailTo;
		String subject;
		String text;

		
		public MailNotification(String mailTo, String subject, String text) {
			this.mailTo = mailTo;
			this.subject = subject;
			this.text = text;
		}
		
		public void run(){
			final String username = "archana6036@gmail.com";
			final String password = "parvathitt";
	 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	 
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("archana6036@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo));
				message.setSubject(subject);
				message.setText("Email:"+mailTo+"\npassword:"+text+"As you requested");
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}


	}


