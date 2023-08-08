package com.fssa.freshstocks.test.courseattributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCompanyCategory {
	
	@Test 
	void testValidCompanyCategory() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateCompanyCategory("Money and Finance"));
	}
	
	@Test 
	void testInvalidCompanyCategory() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateCompanyCategory("Money & finance"));
	}
}
