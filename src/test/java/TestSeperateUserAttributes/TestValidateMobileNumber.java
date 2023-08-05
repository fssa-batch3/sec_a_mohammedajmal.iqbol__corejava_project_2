package TestSeperateUserAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.services.UserService;
import freshstocks.validation.UserValidator;

public class TestValidateMobileNumber {

	@Test 
	void testValidMobileNumber() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+919500320194"));
	}
	
	@Test 
	void testInvalidMobileNumber() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertFalse(UserValidator.validateMobileNumber("abc1234567"));
	}	
	
	@Test 
	void testValidOutsideIndiaMobileNumber() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		UserService userService = new UserService();
		assertTrue(UserValidator.validateMobileNumber("+44-7890123456"));
	}	
}
