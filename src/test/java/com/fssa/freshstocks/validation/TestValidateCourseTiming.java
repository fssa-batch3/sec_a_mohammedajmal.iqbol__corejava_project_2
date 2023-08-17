package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseTiming {

	@Test
	void testValidTiming() {
		try {
			assertTrue(CourseValidator.validateTiming("40hrs"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidTiming() {
		try {
			CourseValidator.validateTiming("12.50hrs");
		} catch (InvalidCourseException e) {
			assertEquals("Course timing is Invalid",e.getMessage());
		}
	}
}
