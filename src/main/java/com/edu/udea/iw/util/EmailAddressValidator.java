package com.edu.udea.iw.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailAddressValidator {

	public static boolean isValidEmailAddress(String email) {
	   boolean result = true;
	   try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	   } catch (AddressException ex) {
	      result = false;
	   }
	   return result;
	}
	
}
