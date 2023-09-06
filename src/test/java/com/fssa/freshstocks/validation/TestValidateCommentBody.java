package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

class TestValidateCommentBody {

    private String validCommentBody;
    private String invalidCommentBody;

    @BeforeEach
    void setup() {
        validCommentBody = "this is test comment";
        invalidCommentBody = " ";
    }

    @Test
    @Order(1)
    void testValidCommentBody() {
        try {
            CommentValidator.validateComment(validCommentBody);
            // If no exception is thrown, it's a valid comment body
        } catch (InvalidCommentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testInvalidCommentBody() {
    	 assertThrows(InvalidCommentException.class, () -> {
    	        CommentValidator.validateComment(invalidCommentBody);
    	    });
    }
}
