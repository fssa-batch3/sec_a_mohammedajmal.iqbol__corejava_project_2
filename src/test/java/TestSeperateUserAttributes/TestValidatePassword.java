package TestSeperateUserAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidatePassword {

	@Test 
	void testValidPassword() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validatePassword("Ajmal@123"));
	}

	@Test 
	void testInvalidPasswordWithoutSpecialCharacters() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal123"));
	}
	
	
	@Test 
	void testInvalidPasswordWithoutNumbers() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@@@@"));
	}
	
	@Test 
	void testInvalidPasswordWithoutSpecialAlphabets() throws ServiceException, freshstocks.services.exception.ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("@1234567"));
	}
	
	@Test 
	void testInvalidPasswordLengthlessThan8() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("Ajmal@1"));
	}
	
	@Test 
	void testInvalidPasswordWithoutUppercase() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validatePassword("ajmal@1234"));
	}
}

