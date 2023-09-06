package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

class TestValidateCommentUserId {

    private String validUserId;
    private String invalidUserId;

    @BeforeEach
    void setup() {
        validUserId = "12";
        invalidUserId = "123a";
    }

    @Test
    @Order(1)
    void testValidCommentUserID() {
        try {
            CommentValidator.validateUserId(validUserId);
            // If no exception is thrown, it's a valid user ID
        } catch (InvalidCommentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testInvalidCommentUserID() {
        try {
            CommentValidator.validateUserId(invalidUserId);
            fail("Expected InvalidCommentException was not thrown.");
        } catch (InvalidCommentException e) {
            assertEquals("Invalid user ID. User IDs must be positive integers.", e.getMessage());
        }
    }
}
