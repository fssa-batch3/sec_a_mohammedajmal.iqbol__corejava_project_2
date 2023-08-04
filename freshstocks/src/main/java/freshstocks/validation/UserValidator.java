package freshstocks.validation;

import java.util.regex.Pattern;
import freshstocks.model.User;
import freshstocks.validation.exception.InvalidUserException;

import java.util.regex.PatternSyntaxException;

public class UserValidator {
	
	// if three conditions valid then user valid
	public static boolean validateUser(User user) throws InvalidUserException {
		if(user != null && validateName(user.getUsername()) && validateEmail(user.getEmail()) 
				&& validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}


	public static boolean validateName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9_]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				System.out.println("user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}
	
			
	public static boolean validateMobileNumber(String mobileNumber) {
		boolean match = false;
		try {
			String regex = "^\\+?[0-9]{1,4}-?[0-9]{5,14}$";
			match = Pattern.matches(regex, mobileNumber);
			if (match) {
				System.out.println("Given mobileNumber is valid.");
			} else {
				System.out.println("Given mobileNumber is not valid");
			}
		} catch (Exception e) {
			System.out.println("mobileNumber is not valid");
		}
		return match;
	}
	
	public static boolean validateDateOfBirth(String DateOfBirth) {
		boolean match = false;
		try {
			String regex = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1])$";
			match = Pattern.matches(regex, DateOfBirth);
			if (match) {
				System.out.println("Given DateOfBirth is valid.");
			} else {
				System.out.println("Given DateOfBirth is not valid");
			}
		} catch (Exception e) {
			System.out.println("DateOfBirth is not valid");
		}
		return match;
	}

	public static boolean validateGender(String Gender) {
		boolean match = false;
		try {
			String regex = "/^(male|female|others)$/i";
			match = Pattern.matches(regex, Gender);
			if (match) {
				System.out.println("Given Gender is valid.");
			} else {
				System.out.println("Given Gender is not valid");
			}
		} catch (Exception e) {
			System.out.println("Gender is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;
		try {
			String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(patternString, password);
			if (match) {
				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password.");
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				System.out.println("The email address is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;

    }
}
