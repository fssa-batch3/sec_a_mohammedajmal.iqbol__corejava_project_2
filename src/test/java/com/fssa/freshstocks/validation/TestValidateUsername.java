package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUsername {

    private String validUsername;
    private String invalidUsernameLengthLessThan3;
    private String emptyUsername;

    @BeforeEach
    void setup() {
        validUsername = "Username_123";
        invalidUsernameLengthLessThan3 = "Us";
        emptyUsername = " ";
    }

    @Test
    @Order(1)
    void testValidUsername() {
        try {
            assertTrue(UserValidator.validateName(validUsername));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidUsernameLengthlessThan3() {
        try {
            UserValidator.validateName(invalidUsernameLengthLessThan3);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid user name. User names must be 3 to 30 characters long and may include letters, numbers, and underscores.", e.getMessage());
        }
    }
    
    @Test
    @Order(3)
    void testEmptyUsername() {
        try {
            UserValidator.validateName(emptyUsername);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid user name. User names must be 3 to 30 characters long and may include letters, numbers, and underscores.", e.getMessage());
        }
    }
}
