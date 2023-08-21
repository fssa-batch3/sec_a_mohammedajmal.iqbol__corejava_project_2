package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseLanguage {

	@Test 
	void testValidLanguage()  {
		
		try {
			assertTrue(CourseValidator.validateLanguage("English"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void testInvalidLanguage()  {
		
		try {
			CourseValidator.validateLanguage("India500");
		} catch (InvalidCourseException e) {
			assertEquals("Invalid course language. Course languages must be 3 to 30 characters long and may include letters and spaces.",e.getMessage());
		}
	}
}
