package com.fssa.freshstocks.validation.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.google.protobuf.ServiceException;

public class TestValidateName {

	@Test 
	void testValidName() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertTrue(CourseValidator.validateName("forex course"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	void testInvalidName() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertFalse(CourseValidator.validateName("candles5_course"));
		} catch (InvalidCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
