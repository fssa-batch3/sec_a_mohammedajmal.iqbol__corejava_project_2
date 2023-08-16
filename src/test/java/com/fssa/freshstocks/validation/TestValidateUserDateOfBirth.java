package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

class TestValidateUserDateOfBirth {

	@Test
	void testValidEmail() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validateDateOfBirth("2004-12-26"));
	}

	@Test
	void testInvalidEmail() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("2004-26-12"));
	}

	@Test
	void testEmailWithoutdot() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("26-12-2004"));
	}
}