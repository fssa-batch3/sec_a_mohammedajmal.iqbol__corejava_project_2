package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCoursePriceDifference {

	@Test 
	void testValidCoursePriceDifference() {
		assertTrue(CourseValidator.validatePriceDifference("1000","500"));
	}
	
	@Test 
	void testInvalidCoursePriceDifference()  {
		assertFalse(CourseValidator.validatePriceDifference("1000","2500"));
	}
}
