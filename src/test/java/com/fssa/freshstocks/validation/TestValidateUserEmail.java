package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserEmail {

	@Test
	void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("ajmal@gmail.com"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmail() {
		try {
			UserValidator.validateEmail("ajmalgmail.com");
		} catch (InvalidUserException e) {
			assertEquals("Invalid email address. Please provide a valid email address.",e.getMessage());
		}
	}

	@Test
	void testEmailWithoutdot() {
		try {
			UserValidator.validateEmail("ajmal@gmailcom");
		} catch (InvalidUserException e) {
			assertEquals("Invalid email address. Please provide a valid email address.",e.getMessage());
		}
	}
}
