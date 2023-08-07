package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.validation.CourseValidator;

public class TestValidateTopSkills {

	@Test 
	void testValidTopSkills() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateTopSkils("smart money concepts"));
	}
	
	@Test 
	void testInvalidTopSkills() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateTopSkils("number theory 12345"));
	}	
}
