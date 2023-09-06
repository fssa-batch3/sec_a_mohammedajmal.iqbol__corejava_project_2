package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

class TestValidateCommentCourseId {

    private String validCourseID;
    private String invalidCourseID;

    @BeforeEach
    void setup() {
        validCourseID = "12";
        invalidCourseID = "123a";
    }

    @Test
    @Order(1)
    void testValidCommentCourseID() {
        try {
            CommentValidator.validateCourseId(validCourseID);
            // If no exception is thrown, it's a valid course ID
        } catch (InvalidCommentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testInvalidCommentCourseID() {
        try {
            CommentValidator.validateCourseId(invalidCourseID);
            fail("Expected InvalidCommentException was not thrown.");
        } catch (InvalidCommentException e) {
            assertEquals("Invalid course ID. Course IDs must be positive integers.", e.getMessage());
        }
    }
}
