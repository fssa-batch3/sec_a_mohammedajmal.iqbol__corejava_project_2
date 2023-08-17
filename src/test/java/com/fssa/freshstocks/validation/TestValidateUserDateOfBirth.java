package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserDateOfBirth {

	@Test
	void testValidEmail() {
		try {
			assertTrue(UserValidator.validateDateOfBirth("2004-12-26"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmail() {
		try {
			UserValidator.validateDateOfBirth("2004-26-12");
		} catch (InvalidUserException e) {
			assertEquals("Given DateOfBirth is not valid",e.getMessage());
		}
	}

	@Test
	void testEmailWithoutdot() {
		try {
			UserValidator.validateDateOfBirth("26-12-2004");
		} catch (InvalidUserException e) {
			assertEquals("Given DateOfBirth is not valid",e.getMessage());
		}
	}
}