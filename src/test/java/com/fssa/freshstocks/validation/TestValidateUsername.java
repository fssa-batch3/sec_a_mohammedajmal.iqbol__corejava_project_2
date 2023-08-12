package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateUsername {

	@Test
	void testValidUsername() {
		UserService userService = new UserService();
		assertTrue(UserValidator.validateName("Username_123"));
	}

	@Test
	void testInvalidUsernameLengthlessThan3() {
		UserService userService = new UserService();
		assertFalse(UserValidator.validateName("Us"));
	}
}
