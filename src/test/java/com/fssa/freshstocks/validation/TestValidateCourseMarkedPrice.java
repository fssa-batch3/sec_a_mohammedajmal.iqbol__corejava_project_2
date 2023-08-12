package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.google.protobuf.ServiceException;

public class TestValidateCourseMarkedPrice {

	@Test 
	void testValidMarkedPrice()  {
		
		try {
			assertTrue(CourseValidator.validateMarkedPrice("1000"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	void testInvalidMarkedPrice()  {
		
		try {
			assertFalse(CourseValidator.validateMarkedPrice("Rs.1000"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
}
