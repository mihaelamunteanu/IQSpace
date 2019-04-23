package com.codeprehend.iqspace.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
	
	public static void validateTextField(String text) throws Exception {
		if (text != null && text.compareTo("") != 0) {
			Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]*)[-| ]?[A-Z]?[a-z]*");
			Matcher matcher = pattern.matcher(text);
			if (!matcher.matches()) {
				throw new Exception("Textul '" + text + "' nu este corect. "
						+ "Se asteapta doar litere latine separate prin spatiu sau -, cu prima litera majuscula.");
			}
		}	
			else{
				throw new Exception("Completati numele si prenumele!");
			}
					
	}
	
	public static void validateNumber(String number, boolean emptyAllowed) throws Exception {
		if (number != null && number.length() > 0) {
			Pattern pattern = Pattern.compile("[0]|([1-9]{1}[0-9]?)");
			Matcher matcher = pattern.matcher(number);
			if (!matcher.matches()) {
				throw new Exception("Numarul '" + number + "' nu este corect.");
			}
		} else if (!emptyAllowed) {
			throw new Exception("Completati campurile numerice. ");
		}
	}
	
	//TODO check correct phone number
	public static void validatePhoneNumber(String phoneNumber) throws Exception {
		if (phoneNumber != null && phoneNumber.length() > 0) {
			Pattern pattern = Pattern.compile("[-]|([+][0-9]?)|([00][0-9]?)|([0][0-9]{9})");
			Matcher matcher = pattern.matcher(phoneNumber);
			if (!matcher.matches()) {
				throw new Exception("Numarul de telefon '" + phoneNumber + "' nu este corect.");
			}
		} else {
			throw new Exception("Completati Numarul de telefon!");
		}
	}
	
}
