package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCourseCategory {
	
	@Test 
	void testValidCompanyCategory() throws ServiceException {
		
		assertTrue(CourseValidator.validateCompanyCategory("Money and Finance"));
	}
	
	@Test 
	void testInvalidCompanyCategory() throws ServiceException {
		
		assertFalse(CourseValidator.validateCompanyCategory("Money & finance"));
	}
}
