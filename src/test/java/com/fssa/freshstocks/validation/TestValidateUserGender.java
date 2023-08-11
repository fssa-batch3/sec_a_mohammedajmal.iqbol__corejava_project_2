package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateUserGender {

	@Test 
	void testValidGender() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateGender("male"));
	}
	
	@Test 
	void testInvalidGender() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateGender("121323"));
	}	
	
	@Test 
	void testGenderOthers() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateGender("non-conforming"));
	}	
}
