package com.fssa.freshstocks.test.userattributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidateMobileNumber {

	@Test 
	void testValidMobileNumber() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+919500320194"));
	}
	
	@Test 
	void testInvalidMobileNumber() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateMobileNumber("abc1234567"));
	}	
	
	@Test 
	void testValidOutsideIndiaMobileNumber() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+44-7890123456"));
	}	
}
