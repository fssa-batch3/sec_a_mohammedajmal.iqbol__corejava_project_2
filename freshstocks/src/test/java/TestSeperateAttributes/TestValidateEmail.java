package TestSeperateAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidateEmail {

	@Test 
	void testValidEmail() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateEmail("ajmal@gmail.com"));
	}
	
	@Test 
	void testInvalidEmail() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmalgmail.com"));
	}	
	
	@Test 
	void testEmailWithoutdot() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateEmail("ajmal@gmailcom"));
	}	
}
