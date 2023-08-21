package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserMobileNumber {

	@Test
	void testValidMobileNumber() {
		try {
			assertTrue(UserValidator.validateMobileNumber("+919500320194"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidMobileNumber() {
		try {
			UserValidator.validateMobileNumber("abc1234567");
		} catch (InvalidUserException e) {
			assertEquals("Invalid mobile number. Please provide a valid phone number, including the country code and area code if applicable.",e.getMessage());
		}
	}

	@Test
	void testValidOutsideIndiaMobileNumber() {
		try {
			assertTrue(UserValidator.validateMobileNumber("+44-7890123456"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}
