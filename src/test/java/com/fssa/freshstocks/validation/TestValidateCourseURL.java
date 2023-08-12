package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.google.protobuf.ServiceException;

public class TestValidateCourseURL {

	@Test 
	void testValidURL()  {
		try {
			assertTrue(CourseValidator.validateURL("https://example.com"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	void testInvalidURL()  {
		try {
			assertFalse(CourseValidator.validateURL("example.com"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}	
		
}
