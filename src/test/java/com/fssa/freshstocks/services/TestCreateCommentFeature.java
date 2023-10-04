package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestCreateCommentFeature {
	

    private CommentService commentService;

    @BeforeEach
    void setup() {
        commentService = new CommentService();
    }

    @Test
    @Order(1)
    void testCreateCommentSuccess() {
        Comment comment1 = new Comment(14, 56, "This course is really informative and well-structured.");
        try {
            assertTrue(commentService.registerComment(comment1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testCreateCommentInvalid() {
        Comment comment1 = new Comment(-1, -1, "");

        assertThrows(ServiceException.class, () -> {
            commentService.registerComment(comment1);
        });
    }

    @Test
    @Order(3)
    void testCreateCommentNull() {
        Comment comment1 = null;

        assertThrows(NullPointerException.class, () -> {
            commentService.registerComment(comment1);
        });
    }
}
