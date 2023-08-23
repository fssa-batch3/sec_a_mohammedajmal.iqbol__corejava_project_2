package com.fssa.freshstocks.services;

import com.fssa.freshstocks.services.exception.ServiceException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Comment;

class TestUpdateCommentsFeature {

    private CommentService commentService;

    @BeforeEach
    void setup() {
        commentService = new CommentService();
    }

    @Test
    @Order(1)
    void testUpdateCommentSuccess() {
        int commentId = 5;
        Comment comment = new Comment("this is test update comments");
        try {
            assertTrue(commentService.updateComment(comment, commentId));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testUpdateCommentInvalid() {

        int commentId = 3;
        Comment comment = new Comment("");
        try {
            assertFalse(commentService.updateComment(comment, commentId));
        } catch (ServiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
