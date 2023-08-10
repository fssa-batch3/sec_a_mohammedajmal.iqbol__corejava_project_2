package com.fssa.freshstocks.validation.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.validation.UserValidator;
import com.google.protobuf.ServiceException;

public class TestValidatePassword {

	@Test 
	void testValidPassword() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validatePassword("Ajmal@123"));
	}

	@Test 
	void testInvalidPasswordWithoutSpecialCharacters() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal123"));
	}
	
	
	@Test 
	void testInvalidPasswordWithoutNumbers() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@@@@"));
	}
	
	@Test 
	void testInvalidPasswordWithoutSpecialAlphabets() throws ServiceException, com.fssa.freshstocks.services.exception.ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("@1234567"));
	}
	
	@Test 
	void testInvalidPasswordLengthlessThan8() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@1"));
	}
	
	@Test 
	void testInvalidPasswordWithoutUppercase() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("ajmal@1234"));
	}
}

