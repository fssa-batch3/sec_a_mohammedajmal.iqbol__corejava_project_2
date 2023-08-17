package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class UserValidator {
	
	private UserValidator() {
		//private constructor
	}

	// if three conditions valid then user valid
	public static boolean validateUser(User user) throws InvalidUserException {
	    if (user == null || !validateName(user.getUsername()) || !validateEmail(user.getEmail()) || !validatePassword(user.getPassword())) {
	        throw new InvalidUserException("User details not valid");
	    }
	    return true;
	}

	public static boolean validateName(String name) throws InvalidUserException {
	    String regex = "^[\\w]{3,30}$";
	    boolean match = Pattern.matches(regex, name);
	    if (!match) {
	    	throw new InvalidUserException("user name is not valid");
	    }
	    return match;
	}

	public static boolean validateMobileNumber(String mobileNumber) throws InvalidUserException {
	    String regex = "^\\+?\\d{1,4}-?\\d{5,14}$";
	    boolean match = Pattern.matches(regex, mobileNumber);
	    if (!match) {
	    	throw new InvalidUserException("Given mobileNumber is not valid");
	    }
	    return match;
	}


	public static boolean validateDateOfBirth(String dateOfBirth) throws InvalidUserException {
	    String regex = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1])$";
	    boolean match = Pattern.matches(regex, dateOfBirth);
	    if (!match) {
	    	throw new InvalidUserException("Given DateOfBirth is not valid");
	    }
	    return match;
	}

	public static boolean validateGender(String gender) throws InvalidUserException {
	    String regex = "^(male|female|others)$";
	    boolean match = Pattern.matches(regex, gender.toLowerCase());
	    if (!match) {
	        throw new InvalidUserException("Given Gender is not valid. Expected Input: male|female|others");
	    }
	    return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
	    String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}";
	    if (!Pattern.matches(patternString, password)) {
	        throw new InvalidUserException("Invalid password");
	    }
	    return true;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
	    if (email.trim().isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
	    	throw new InvalidUserException("Invalid User Email");
	    }
	    return true;
	}
	
}
