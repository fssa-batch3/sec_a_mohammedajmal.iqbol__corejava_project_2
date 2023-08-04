package TestSeperateAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidateGender {

	@Test 
	void testValidGender() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateGender("male"));
	}
	
	@Test 
	void testInvalidGender() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateGender("121323"));
	}	
	
	@Test 
	void testGenderOthers() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateGender("non-conforming"));
	}	
}
