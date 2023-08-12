package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CourseValidator;
import com.google.protobuf.ServiceException;

public class TestValidateCourseTiming {

	@Test
	void testValidTiming() {
		assertTrue(CourseValidator.validateTiming("40hrs"));
	}

	@Test
	void testInvalidTiming() {
		assertFalse(CourseValidator.validateTiming("12.50hrs"));
	}
}
