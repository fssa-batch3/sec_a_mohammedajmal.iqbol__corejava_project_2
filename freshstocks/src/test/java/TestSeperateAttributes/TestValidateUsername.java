package TestSeperateAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidateUsername {

	@Test 
	void testValidUsername() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateName("Username_123"));
	}
	
	@Test 
	void testInvalidUsernameLengthlessThan3() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateName("Us"));
	}	
}
