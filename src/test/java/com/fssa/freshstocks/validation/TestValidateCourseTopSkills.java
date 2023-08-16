package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

class TestValidateCourseTopSkills {

	@Test
	void testValidTopSkills() {
		assertTrue(CourseValidator.validateTopSkils("smart money concepts"));
	}

	@Test
	void testInvalidTopSkills() {
		assertFalse(CourseValidator.validateTopSkils("number theory 12345"));
	}
}
