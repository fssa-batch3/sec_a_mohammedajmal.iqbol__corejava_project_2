package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateUserMobileNumber {

	@Test
	void testValidMobileNumber() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+919500320194"));
	}

	@Test
	void testInvalidMobileNumber() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateMobileNumber("abc1234567"));
	}

	@Test
	void testValidOutsideIndiaMobileNumber() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+44-7890123456"));
	}
}
