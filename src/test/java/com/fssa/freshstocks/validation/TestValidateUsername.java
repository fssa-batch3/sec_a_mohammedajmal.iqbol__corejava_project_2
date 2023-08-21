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
			assertEquals("user name is not valid",e.getMessage());
		}
	}
}
