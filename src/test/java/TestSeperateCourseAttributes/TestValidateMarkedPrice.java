package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.validation.CourseValidator;

public class TestValidateMarkedPrice {

	@Test 
	void testValidMarkedPrice() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateMarkedPrice("1000"));
	}
	
	@Test 
	void testInvalidMarkedPrice() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateMarkedPrice("Rs.1000"));
	}
}
