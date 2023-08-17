package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCommentException;

class TestValidateCommentCourseId {

	@Test
	void testValidCommentCourseID() {

		try {
			assertTrue(CommentValidator.validateCourseId("12"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidCommentCourseID() {

		try {
			CommentValidator.validateCourseId("123a");
		} catch (InvalidCommentException e) {
			assertEquals("Course commentID is Invalid",e.getMessage());
		}
	}
}
