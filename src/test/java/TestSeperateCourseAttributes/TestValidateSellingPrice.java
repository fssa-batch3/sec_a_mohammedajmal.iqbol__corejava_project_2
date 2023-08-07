package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.validation.CourseValidator;

public class TestValidateSellingPrice {

	@Test 
	void testValidSellingPrice() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateSellingPrice("5000"));
	}
	
	@Test 
	void testInvalidSellingPrice() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateSellingPrice("Rs.5000"));
	}
}
