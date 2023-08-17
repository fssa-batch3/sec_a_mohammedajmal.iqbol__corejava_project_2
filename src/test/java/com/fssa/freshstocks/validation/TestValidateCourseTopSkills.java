package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseTopSkills {

	@Test
	void testValidTopSkills() {
		try {
			assertTrue(CourseValidator.validateTopSkils("smart money concepts"));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidTopSkills() {
		try {
			CourseValidator.validateTopSkils("number theory 12345");
		} catch (InvalidCourseException e) {
			assertEquals("Course topskills is Invalid",e.getMessage());
		}
	}
}
