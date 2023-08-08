package com.fssa.freshstocks.test.courseattributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateName {

	@Test 
	void testValidName() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateName("forex course"));
	}
	
	@Test 
	void testInvalidName() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateName("candles5_course"));
	}
}
