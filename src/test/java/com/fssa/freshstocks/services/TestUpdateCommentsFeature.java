package com.fssa.freshstocks.services;

import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Comment;

class TestUpdateCommentsFeature {

	public static void main(String[] args) throws InvalidCommentException {

		int commentId = 5;
		Comment comment = new Comment("this is test update comments");
		CommentService commentService = new CommentService();
		try {
			if(!commentService.updateComment(comment, commentId)) {
				System.out.println("CommentID Doesn't Exist");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testUpdateCommentSuccess() {
		int commentId = 5;
		Comment comment = new Comment("this is test update comments");
		CommentService commentService = new CommentService();
		try {
			assertTrue(commentService.updateComment(comment, commentId));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test // invalid because invalid comment body
	void testUpdateCommentInvalid() {

		int commentId = 3;
		Comment comment = new Comment("");
		CommentService commentService = new CommentService();
		try {
			assertFalse(commentService.updateComment(comment, commentId));
		} catch (ServiceException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
