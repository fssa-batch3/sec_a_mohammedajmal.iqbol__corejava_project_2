package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;
import freshstocks.validation.CourseValidator;

public class TestValidateURL {

	@Test 
	void testValidURL() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateURL("https://example.com"));
	}
	
	@Test 
	void testInvalidURL() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateURL("example.com"));
	}	
		
}
