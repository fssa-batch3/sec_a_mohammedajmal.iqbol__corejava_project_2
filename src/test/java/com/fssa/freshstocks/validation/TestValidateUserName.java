package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserName {

    private String validName;
    private String invalidName;
    private String emptyName;

    @BeforeEach
    void setup() {
        validName = "Ajaml656";
        invalidName = "Aj"; // Invalid Name
        emptyName = " ";
    }

    @Test
    @Order(1)
    void testValidName() {
        try {
            UserValidator.validateName(validName);
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testInvalidName() {
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateName(invalidName);
        });
    }
    
    @Test
    @Order(3)
    void testEmptyName() {
        try {
            UserValidator.validateName(emptyName);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid user name. User names must be 3 to 30 characters long and may include letters, numbers, and underscores.", e.getMessage());
        }
    }
}
