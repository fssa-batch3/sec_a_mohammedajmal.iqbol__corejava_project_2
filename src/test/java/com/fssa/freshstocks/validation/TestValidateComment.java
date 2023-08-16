package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.validation.exception.InvalidCommentException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.*;

class TestValidateComment {

    @Test
    void testValidComment() throws InvalidCommentException {
    	 Comment comment = new Comment(1,1,"this is test comment");
        assertTrue(CommentValidator.validateComment(comment));
    }

    @Test
    void testInvalidCommentWithNull() {
    	Comment comment = new Comment(null);
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(comment));
    }

    @Test
    void testInvalidCommentWithInvalidUserId() {
    	Comment comment = new Comment(1,-1,"test comment"); // Invalid user ID
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(comment));
    }

    @Test
    void testInvalidCommentWithInvalidCourseId() {
        Comment comment = new Comment(-1,1,"test comment"); // Invalid course ID
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(comment));
    }

    @Test
    void testInvalidCommentWithInvalidComment() {
        Comment comment = new Comment(1,1,""); // Invalid comment
        assertThrows(InvalidCommentException.class, () -> CommentValidator.validateComment(comment));
    }
}
