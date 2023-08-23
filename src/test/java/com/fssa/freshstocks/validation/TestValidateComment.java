package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.model.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fssa.freshstocks.validation.exception.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class TestValidateComment {

    private Comment validComment;
    private Comment invalidCommentNull;
    private Comment invalidCommentInvalidUserId;
    private Comment invalidCommentInvalidCourseId;
    private Comment invalidCommentInvalidComment;

    @BeforeEach
    void setup() {
        validComment = new Comment(1, 1, "this is test comment");
        invalidCommentNull = null;
        invalidCommentInvalidUserId = new Comment(1, -1, "test comment");
        invalidCommentInvalidCourseId = new Comment(-1, 1, "test comment");
        invalidCommentInvalidComment = new Comment(1, 1, "");
    }

    @Test
    @Order(1)
    void testValidComment() throws InvalidCommentException {
        assertTrue(CommentValidator.validateComment(validComment));
    }

    @Test
    @Order(2)
    void testInvalidCommentWithNull() {
        assertThrows(NullPointerException.class, () -> {
            CommentValidator.validateComment(invalidCommentNull);
        });
    }

    @Test
    @Order(3)
    void testInvalidCommentWithInvalidUserId() {
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(invalidCommentInvalidUserId));
    }

    @Test
    @Order(4)
    void testInvalidCommentWithInvalidCourseId() {
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(invalidCommentInvalidCourseId));
    }

    @Test
    @Order(5)
    void testInvalidCommentWithInvalidComment() {
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(invalidCommentInvalidComment));
    }
}