package com.nrivishwakarma.utilities;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailNotification {
	String mailTo;
	String subject;
	String text;
	String token;

	public MailNotification(String mailTo, String subject, String text,
			String token) {
		this.mailTo = mailTo;
		this.subject = subject;
		this.text = text;
		this.token = token;
	}

	public boolean run() throws UnsupportedEncodingException {
		String[] to = { mailTo };
		String[] cc = { mailTo };
		String[] bcc = { mailTo };

		// This is for google

		String userName = "archana6036@gmail.com";
		String passWord = "parvathitt";
		String host = "smtp.gmail.com";
        String port = "465";
		text= "http://localhost:8888/NRIVishwaKarma.html#/Login?reset_token="+token;
		String starttls = "true";

		String auth = "true";

		boolean debug = true;

		String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
		String fallback = "false";


		Properties props = new Properties();

		// Properties props=System.getProperties();

		props.put("mail.smtp.user", userName);

		props.put("mail.smtp.host", host);

		if (!"".equals(port))

			props.put("mail.smtp.port", port);

		if (!"".equals(starttls))

			props.put("mail.smtp.starttls.enable", starttls);

		props.put("mail.smtp.auth", auth);

		if (debug)

		{

			props.put("mail.smtp.debug", "true");

		}

		else

		{

			props.put("mail.smtp.debug", "false");

		}

		if (!"".equals(port))

			props.put("mail.smtp.socketFactory.port", port);

		if (!"".equals(socketFactoryClass))

			props.put("mail.smtp.socketFactory.class", socketFactoryClass);

		if (!"".equals(fallback))

			props.put("mail.smtp.socketFactory.fallback", fallback);

		try

		{

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setText(text);

			msg.setSubject(subject);

			msg.setFrom(new InternetAddress("archana6036@gmail.com"));

			for (int i = 0; i < to.length; i++)

			{

				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));

			}

			for (int i = 0; i < cc.length; i++)

			{

				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));

			}

			for (int i = 0; i < bcc.length; i++)

			{

				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));

			}

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();
			return true;
		}

		catch (Exception mex)

		{
			mex.printStackTrace();
			return false;
		}
	}

}
