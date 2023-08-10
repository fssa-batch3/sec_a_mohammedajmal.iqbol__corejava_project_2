package com.fssa.freshstocks.validation.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.google.protobuf.ServiceException;

public class TestValidateLanguage {

	@Test 
	void testValidLanguage() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertTrue(CourseValidator.validateLanguage("English"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	void testInvalidLanguage() throws com.fssa.freshstocks.services.exception.ServiceException, ServiceException {
		
		try {
			assertFalse(CourseValidator.validateLanguage("India500"));
		} catch (InvalidCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
