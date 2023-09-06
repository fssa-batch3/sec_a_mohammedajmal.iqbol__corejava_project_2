package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestDeleteCommentFeature {
	

    private CommentService commentService;
    private final int isDeleted = 1;

    @BeforeEach
    void setup() {
        commentService = new CommentService();
    }

    @Test
    @Order(1)
    void testDeleteCommentSuccess() {
        int commentId = 1;
        try {
            assertTrue(commentService.deleteComment(commentId, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testDeleteCommentFail() {
        int commentId = 0;
        try {
            assertFalse(commentService.deleteComment(commentId, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
