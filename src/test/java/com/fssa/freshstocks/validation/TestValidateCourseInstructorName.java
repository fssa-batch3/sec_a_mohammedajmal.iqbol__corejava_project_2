package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseInstructorName {

	@Test 
	void testValidInstructorName()  {
		
		try {
			assertTrue(CourseValidator.validateInsutructorName("Ajmal"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void testInvalidInstructorName()  {
		
		try {
			CourseValidator.validateInsutructorName("Mohammed_Ajmal");
		} catch (InvalidCourseException e) {
			assertEquals("Invalid course instructor name. Instructor names must be 3 to 50 characters long and may include letters and spaces.",e.getMessage());
		}
	}
}
