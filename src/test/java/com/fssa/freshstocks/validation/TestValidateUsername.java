package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUsername {

	@Test
	void testValidUsername() {
		try {
			assertTrue(UserValidator.validateName("Username_123"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidUsernameLengthlessThan3() {
		try {
			UserValidator.validateName("Us");
		} catch (InvalidUserException e) {
			assertEquals("Invalid user name. User names must be 3 to 30 characters long and may include letters, numbers, and underscores.",e.getMessage());
		}
	}
}
