package com.Ats.qa.Email;

import java.util.Properties;


//import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*;

public class SendMailWithAttachment {
	
	
	
	
	
	

	public static void send(String from, String tos[], String subject,
		      String text) throws MessagingException {
		    // Get the session object
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "26");
		    props.put("mail.smtp.socketFactory.class",
		        "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "26");

		    Session session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		          protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(
		            "sen.s4u@gmail.com",
		            "lovejita@143");// change accordingly
		          }
		        });

		    // compose message
		    try {
		      MimeMessage message = new MimeMessage(session);
		      message.setFrom(new InternetAddress(from));// change accordingly
		      for (String to : tos) {
		        message.addRecipient(Message.RecipientType.TO,
		            new InternetAddress(to));
		      }
		      /*
		       * for (String cc : ccs)
		       * message.addRecipient(Message.RecipientType.CC,new
		       * InternetAddress(cc));
		       */
		      message.setSubject(subject);
		      // Option 1: To send normal text message
		      // message.setText(text);
		      // Option 2: Send the actual HTML message, as big as you like
		      // message.setContent("<h1>This is actual message</h1></br></hr>" +
		      // text, "text/html");

		      // Set the attachment path
		      String filename = "C:\\Users\\Supriyo Sen\\eclipse-workspace\\ATS\\Report\\TestReport\\Test-Automaton-Report.html";

		      BodyPart objMessageBodyPart = new MimeBodyPart();
		      // Option 3: Send text along with attachment
		      objMessageBodyPart.setContent(
		          "<h1>Mail from ATS Project!</h1></br>" + text, "text/html");
		      Multipart multipart = new MimeMultipart();
		      multipart.addBodyPart(objMessageBodyPart);

		      objMessageBodyPart = new MimeBodyPart();
		      DataSource source = new FileDataSource(filename);
		      objMessageBodyPart.setDataHandler(new DataHandler(source));
		      objMessageBodyPart.setFileName(filename);
		      multipart.addBodyPart(objMessageBodyPart);
		      message.setContent(multipart);

		      // send message
		      Transport.send(message);

		      System.out.println("message sent successfully");

		    } catch (MessagingException e) {
		      throw new RuntimeException(e);
		    }
		  }// End of SEND method
		
	} 