package com.Ats.qa.Email;

import javax.mail.MessagingException;


public class InvokeMail {
	
	public static void main(String[] args) throws MessagingException {
	//String to[] = {"test02@gmail.com","test03@gmail.com"};
    String to[] = {"Supriyo@trajectus.com"};
    
    
    SendMailWithAttachment.send("sen.s4u@gmail.com", to, "ATS Execution Report", "Check the ATS Report as attachment.");		

  }
}

