package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

class TestValidateUserPassword {

	@Test
	void testValidPassword() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validatePassword("Ajmal@123"));
	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacters() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal123"));
	}

	@Test
	void testInvalidPasswordWithoutNumbers() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@@@@"));
	}

	@Test
	void testInvalidPasswordWithoutSpecialAlphabets() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("@1234567"));
	}

	@Test
	void testInvalidPasswordLengthlessThan8() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@1"));
	}

	@Test
	void testInvalidPasswordWithoutUppercase() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("ajmal@1234"));
	}
}
