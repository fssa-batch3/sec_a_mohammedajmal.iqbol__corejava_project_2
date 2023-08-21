package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseURL {

	@Test 
	void testValidURL()  {
		try {
			assertTrue(CourseValidator.validateURL("https://example.com"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void testInvalidURL()  {
		try {
			CourseValidator.validateURL("example.com");
		} catch (InvalidCourseException e) {
			assertEquals("Invalid course image URL. Please provide a valid HTTP or HTTPS URL.",e.getMessage());
		}
	}	
		
}
