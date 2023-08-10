package com.fssa.freshstocks.validation.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.google.protobuf.ServiceException;

public class TestValidateMarkedPrice {

	@Test 
	void testValidMarkedPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertTrue(CourseValidator.validateMarkedPrice("1000"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	void testInvalidMarkedPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertFalse(CourseValidator.validateMarkedPrice("Rs.1000"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
}
