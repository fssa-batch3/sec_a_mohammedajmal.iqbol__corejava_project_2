package TestSeperateCourseAttributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.validation.CourseValidator;

public class TestValidateTiming {

	@Test 
	void testValidTiming() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateTiming("40hrs"));
	}
	
	@Test 
	void testInvalidTiming() throws freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateTiming("12.50hrs"));
	}
}
