package ResetPassword;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtility {

	  public static void sendMail(String host, String port,
	            final String userName, final String password, String email, String passwordfromdb) throws AddressException,
	            MessagingException {
	 
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	    	properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("kaluckfitness@gmail.com", "rppufvlvfrlarjlv");
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress("kaluckfitness@gmail.com"));
	        InternetAddress[] toAddresses = { new InternetAddress(email) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject("SOES admin password");
	        
	        msg.setSentDate(new Date());
	        msg.setContent("<body style=\"background-color: lightgray;\"><div style=\"background-color: lightyellow;text-align: center;\"><h2 style=\"font-weight: normal;color: maroon;\">Message from</h2> <h1 style=\"color: darkblue;\">SOES</h1><i style=\"text-align: center;\"><h3 style=\"font-weight: normal;color: darkblue;\">You have requested to show password password. Your password shown below ; </h3><h2 style=\"background-color: lightyellow;color: red;text-align: center\">"+passwordfromdb+"</h2><h2 style=\"font-weight: normal;color: green;\">Follow us on facebook <a href=\"resetpassword.jsp\" >click here</a></h2><h3 style=\"font-weight: normal;\"> Thank you !!!.</h3></i></div><footer style=\"text-align: center;\"><h4>&copy; Copyright 2022 SOES.</h4></footer ></body>", "text/html" );
	        // sends the e-mail
	        Transport.send(msg);
	 
	    }
}
