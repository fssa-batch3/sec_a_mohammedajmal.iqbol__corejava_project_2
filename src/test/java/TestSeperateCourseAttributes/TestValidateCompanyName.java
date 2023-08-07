package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.validation.CourseValidator;

public class TestValidateCompanyName {

	@Test 
	void testValidCompanyName() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateCompanyName("freshstocks"));
	}
	
	@Test 
	void testInvalidCompanyName() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateCompanyName("freshworks_STS_Academy"));
	}
}
