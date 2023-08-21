package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCommentException;

class TestValidateCommentUserId {

	@Test
	void testValidCommentUserID() {

		try {
			assertTrue(CommentValidator.validateUserId("12"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidCommentUserID() {

		try {
			CommentValidator.validateUserId("123a");
		} catch (InvalidCommentException e) {
			assertEquals("Invalid user ID. User IDs must be positive integers.",e.getMessage());
		}
	}
}
