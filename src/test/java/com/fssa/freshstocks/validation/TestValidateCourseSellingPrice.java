package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseSellingPrice {

	@Test
	void testValidSellingPrice() {
		try {
			assertTrue(CourseValidator.validateSellingPrice("5000"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidSellingPrice() {
		try {
			CourseValidator.validateSellingPrice("Rs.5000");
		} catch (InvalidCourseException e) {
			assertEquals("Course selling price is Invalid",e.getMessage());
		}
	}
}
