package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseCompanyName {

	@Test 
	void testValidCompanyName()  {
		
		try {
			assertTrue(CourseValidator.validateCompanyName("freshstocks"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	void testInvalidCompanyName()  {
		
		try {
			CourseValidator.validateCompanyName("freshworks_STS_Academy");
		} catch (InvalidCourseException e) {
			assertEquals("Course company name is Invalid",e.getMessage());
		}
	}
}
