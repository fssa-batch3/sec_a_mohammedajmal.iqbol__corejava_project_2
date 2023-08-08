package com.fssa.freshstocks.test.userattributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateDateOfBirth {

	@Test 
	void testValidEmail() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateDateOfBirth("2004-12-26"));
	}
	
	@Test 
	void testInvalidEmail() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("2004-26-12"));
	}	
	
	@Test 
	void testEmailWithoutdot() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("26-12-2004"));
	}	
}