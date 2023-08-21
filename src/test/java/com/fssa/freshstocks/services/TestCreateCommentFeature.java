package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestCreateCommentFeature {
	

	@Test
	void testCreateCommentSuccess() {
		CommentService commentService = new CommentService();
		Comment comment1 = new Comment(4, 4, "This course is really informative and well-structured.");
		try {
			assertTrue(commentService.registerComment(comment1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test // invalid because invalid comment
	void testCreateCommentInvalid() {

		CommentService commentService = new CommentService();
		Comment comment1 = new Comment(-1, -1, "");

		assertThrows(ServiceException.class, () -> {
			commentService.registerComment(comment1);
		});
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
