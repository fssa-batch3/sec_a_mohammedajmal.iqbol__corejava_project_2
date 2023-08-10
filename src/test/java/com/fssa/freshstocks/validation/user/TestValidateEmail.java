package com.fssa.freshstocks.validation.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateEmail {

	@Test 
	void testValidEmail() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateEmail("ajmal@gmail.com"));
	}
	
	@Test 
	void testInvalidEmail() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmalgmail.com"));
	}	
	
	@Test 
	void testEmailWithoutdot() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmal@gmailcom"));
	}	
}
