package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.*;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.services.CommentService;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestDeleteCommentFeature {

	@Test
	void TestDeleteCommentSuccess() {
		int commentId = 7;
		int isDeleted = 1;
		CommentService commentService = new CommentService();
		try {
			assertTrue(commentService.deleteComment(commentId, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteCommentFail() {
		int commentId = 2;
		int isDeleted = 1;
		CommentService commentService = new CommentService();
		try {
			assertFalse(commentService.deleteComment(commentId, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
