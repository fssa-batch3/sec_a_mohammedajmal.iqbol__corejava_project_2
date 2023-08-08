package com.fssa.freshstocks.test.courseattributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateMarkedPrice {

	@Test 
	void testValidMarkedPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateMarkedPrice("1000"));
	}
	
	@Test 
	void testInvalidMarkedPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateMarkedPrice("Rs.1000"));
	}
}
