package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseCategory {

	@Test
	void testValidCompanyCategory() {

			try {
				assertTrue(CourseValidator.validateCompanyCategory("Trading and Finance"));
			} catch (InvalidCourseException e) {
				e.printStackTrace();
			}
	}

	@Test
	void testInvalidCompanyCategory() {

		try {
			CourseValidator.validateCompanyCategory("&&&finance");
		} catch (InvalidCourseException e) {
			assertEquals("Course company category is Invalid",e.getMessage());
		}
	}
}
