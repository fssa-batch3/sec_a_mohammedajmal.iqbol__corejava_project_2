package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCourseName {

	@Test 
	void testValidCompanyName()  {
		
		assertTrue(CourseValidator.validateCompanyName("freshstocks"));
	}
	
	@Test 
	void testInvalidCompanyName()  {
		
		assertFalse(CourseValidator.validateCompanyName("freshworks_STS_Academy"));
	}
}
