package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;
import com.google.protobuf.ServiceException;

public class TestValidateCommentUserId {

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
			assertFalse(CommentValidator.validateUserId("123a"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}
}
