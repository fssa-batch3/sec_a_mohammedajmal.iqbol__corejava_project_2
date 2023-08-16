package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

class TestValidateCourseInstructorName {

	@Test 
	void testValidInstructorName()  {
		
		assertTrue(CourseValidator.validateInsutructorName("Ajmal"));
	}
	
	@Test 
	void testInvalidInstructorName()  {
		
		assertFalse(CourseValidator.validateInsutructorName("Mohammed_Ajmal"));
	}
}
