package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCourseSellingPrice {

	@Test 
	void testValidSellingPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateSellingPrice("5000"));
	}
	
	@Test 
	void testInvalidSellingPrice() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateSellingPrice("Rs.5000"));
	}
}
