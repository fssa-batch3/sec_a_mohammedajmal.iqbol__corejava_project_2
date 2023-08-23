package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserEmail {

    private String validEmail;
    private String invalidEmail;
    private String emailWithoutDot;
    private String emptyEmail;

    @BeforeEach
    void setup() {
        validEmail = "ajmal@gmail.com";
        invalidEmail = "ajmalgmail.com";
        emailWithoutDot = "ajmal@gmailcom";
        emptyEmail = " ";
    }

    @Test
    @Order(1)
    void testValidEmail() {
        try {
            assertTrue(UserValidator.validateEmail(validEmail));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidEmail() {
        try {
            UserValidator.validateEmail(invalidEmail);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid email address. Please provide a valid email address.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmailWithoutDot() {
        try {
            UserValidator.validateEmail(emailWithoutDot);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid email address. Please provide a valid email address.", e.getMessage());
        }
    }
    
    @Test
    @Order(4)
    void testEmailEmpty() {
        try {
            UserValidator.validateEmail(emptyEmail);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid email address. Please provide a valid email address.", e.getMessage());
        }
    }
}
