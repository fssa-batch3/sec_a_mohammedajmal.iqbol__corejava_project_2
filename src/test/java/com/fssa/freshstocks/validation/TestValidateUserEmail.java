package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateUserEmail {

	@Test
	void testValidEmail() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validateEmail("ajmal@gmail.com"));
	}

	@Test
	void testInvalidEmail() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmalgmail.com"));
	}

	@Test
	void testEmailWithoutdot() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmal@gmailcom"));
	}
}
