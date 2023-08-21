package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
			assertEquals("Invalid course selling price. Please provide a valid price (e.g., 100 or 99.99).",e.getMessage());
		}
	}
}
