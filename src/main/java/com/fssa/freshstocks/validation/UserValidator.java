package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.model.User;

import java.time.LocalDate;
import java.util.regex.Pattern;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class UserValidator {

	/**
	 * Validates a User object for its username, email, and password.
	 *
	 * @param user The User object to be validated.
	 * @return true if the user is valid, false otherwise.
	 * @throws InvalidUserException If the user is found to be invalid.
	 */
	public static void validateUser(User user) throws InvalidUserException {
		try {
			if (user == null) {
		        throw new InvalidUserException("User is null.");
		    }
				validateName(user.getUsername());
				validateEmail(user.getEmail());
				validateDateOfBirth(user.getDateOfBirth());
				validatePassword(user.getPassword());
				validateMobileNumber(user.getMobileNumber());
				validateGender(user.getGender());
			// Validation succeeded, continue with other operations
		} catch (InvalidUserException e) {
			throw new InvalidUserException(e.getMessage());
		}
	}

	public static void validateUpdateUser(User user) throws InvalidUserException {
		try {
			if (user == null) {
		        throw new InvalidUserException("User is null.");
		    }
				validateGender(user.getGender());
				validateMobileNumber(user.getMobileNumber());
				validateDateOfBirth(user.getDateOfBirth());
			// Validation succeeded, continue with other operations
		} catch (InvalidUserException e) {
			throw new InvalidUserException(e.getMessage());
		}
	}

	/**
	 * Validates a username based on specific pattern criteria.
	 *
	 * @param name The username to be validated.
	 * @return true if the username is valid, false otherwise.
	 * @throws InvalidUserException If the username is found to be invalid.
	 */
	public static void validateName(String name) throws InvalidUserException {
		String regex = "^[\\w]{3,30}$";
		boolean match = Pattern.matches(regex, name);
		if (!match) {
			throw new InvalidUserException(
					"Invalid user name. User names must be 3 to 30 characters long and may include letters, numbers, and underscores.");
		}
	}

	/**
	 * Validates a mobile number using a specific pattern.
	 *
	 * @param mobileNumber The mobile number to be validated.
	 * @return true if the mobile number is valid, false otherwise.
	 * @throws InvalidUserException If the mobile number is found to be invalid.
	 */
	public static void validateMobileNumber(String mobileNumber) throws InvalidUserException {
		String regex = "^\\+?\\d{1,4}-?\\d{5,14}$";
		boolean match = Pattern.matches(regex, mobileNumber);
		if (!match) {
			throw new InvalidUserException(
					"Invalid mobile number. Please provide a valid phone number, including the country code and area code if applicable.");
		}
	}

	/**
	 * Validates a date of birth using a specific pattern.
	 *
	 * @param dateOfBirth The date of birth to be validated.
	 * @return true if the date of birth is valid, false otherwise.
	 * @throws InvalidUserException If the date of birth is found to be invalid.
	 */
	public static void validateDateOfBirth(String dateOfBirth) throws InvalidUserException {
	    String regex = "^(?:19|20)\\d{2}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1])$";
	    boolean match = Pattern.matches(regex, dateOfBirth);
	    if (!match) {
	        throw new InvalidUserException(
	                "Invalid date of birth. Please provide a valid date in the format YYYY-MM-DD.");
	    }

	    LocalDate dob = LocalDate.parse(dateOfBirth);
	    LocalDate currentDate = LocalDate.now();

	    if (dob.isAfter(currentDate)) {
	        throw new InvalidUserException(
	                "Invalid date of birth. Future dates are not allowed.");
	    }
	}

	/**
	 * Validates a gender using a specific pattern.
	 *
	 * @param gender The gender to be validated.
	 * @return true if the gender is valid, false otherwise.
	 * @throws InvalidUserException If the gender is found to be invalid.
	 */
	public static void validateGender(String gender) throws InvalidUserException {
		String regex = "^(male|female|others)$";
		boolean match = Pattern.matches(regex, gender.toLowerCase());
		if (!match) {
			throw new InvalidUserException("Given Gender is not valid. Expected Input: male|female|others");
		}
	}

	/**
	 * Validates a password using a specific pattern.
	 *
	 * @param password The password to be validated.
	 * @return true if the password is valid, false otherwise.
	 * @throws InvalidUserException If the password is found to be invalid.
	 */
	public static void validatePassword(String password) throws InvalidUserException {
		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}";
		if (!Pattern.matches(patternString, password)) {
			throw new InvalidUserException("Invalid password. Passwords must meet specific complexity requirements.");
		}
	}

	/**
	 * Validates an email address using a specific pattern.
	 *
	 * @param email The email address to be validated.
	 * @return true if the email address is valid, false otherwise.
	 * @throws InvalidUserException If the email address is found to be invalid.
	 */
	public static void validateEmail(String email) throws InvalidUserException {
		if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			throw new InvalidUserException("Invalid email address. Please provide a valid email address.");
		}
	}

}
