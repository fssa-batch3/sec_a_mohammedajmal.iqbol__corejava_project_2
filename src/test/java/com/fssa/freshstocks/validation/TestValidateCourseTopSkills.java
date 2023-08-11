package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCourseTopSkills {

	@Test 
	void testValidTopSkills() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertTrue(CourseValidator.validateTopSkils("smart money concepts"));
	}
	
	@Test 
	void testInvalidTopSkills() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		assertFalse(CourseValidator.validateTopSkils("number theory 12345"));
	}	
}
