package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;
import com.google.protobuf.ServiceException;

public class TestValidateCommentBody {

	@Test
	void testValidCommentBody() {

		try {
			assertTrue(CommentValidator.validateComment("this is test comment"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidCommentBody() {

		try {
			assertFalse(CommentValidator.validateComment(""));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}
}
