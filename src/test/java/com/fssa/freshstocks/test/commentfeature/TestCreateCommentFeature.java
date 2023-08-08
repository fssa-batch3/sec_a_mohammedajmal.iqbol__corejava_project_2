package com.fssa.freshstocks.test.commentfeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.CommentService;

public class TestCreateCommentFeature {

	
	public static void main(String[] args) {

		Comment comment1 = new Comment(23,12,"This course is really good and well-structured.");
		CommentService commentService = new CommentService();

		try {
			if(!commentService.registerComment(comment1)) {
				System.out.println("Create Comment not successful! Error : Comment Validation Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testCreateCommentSuccess() {
		CommentService commentService = new CommentService();
		Comment comment1 = new Comment(23,12,"This course is really informative and well-structured.");
		try {
			assertTrue(CommentService.registerComment(comment1));
		} catch (com.fssa.freshstocks.services.exception.ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test //invalid because invalid courseID
	void testCreateCommentInvalid() {

		CommentService commentService = new CommentService();
		Comment comment1 = new Comment(10,12,"This course is really informative and well-structured.");
		try {
			assertFalse(commentService.registerComment(comment1));
		} catch (com.fssa.freshstocks.services.exception.ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testCreateCommentNull() {
	    CommentService commentService = new CommentService();
	    Comment comment1 = null;

	    assertThrows(NullPointerException.class, () -> {
	        commentService.registerComment(comment1);
	    });
	}
	}
