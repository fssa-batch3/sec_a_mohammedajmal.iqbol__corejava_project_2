package com.fssa.freshstocks.validation.comment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;
import com.google.protobuf.ServiceException;

public class TestValidateCommentCourseId {

	@Test 
	void testValidCommentCourseID() throws ServiceException {
		
		try {
			assertTrue(CommentValidator.validateCourseId("12"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test 
	void testInvalidCommentCourseID() throws ServiceException {
		
		try {
			assertFalse(CommentValidator.validateCourseId("123a"));
		} catch (InvalidCommentException e) {
			System.out.println(e.getMessage());
		}
	}
}
