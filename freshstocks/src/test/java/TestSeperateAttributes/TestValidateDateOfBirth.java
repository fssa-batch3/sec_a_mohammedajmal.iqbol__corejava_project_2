package TestSeperateAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidateDateOfBirth {

	@Test 
	void testValidEmail() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateDateOfBirth("2004-12-26"));
	}
	
	@Test 
	void testInvalidEmail() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("2004-26-12"));
	}	
	
	@Test 
	void testEmailWithoutdot() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateDateOfBirth("26-12-2004"));
	}	
}
