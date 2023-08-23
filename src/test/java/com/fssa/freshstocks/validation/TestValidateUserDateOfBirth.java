package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserDateOfBirth {

    private String validDateOfBirth;
    private String invalidDateOfBirth;
    private String dateOfBirthWithoutDot;
    private String emptyDateOfBirth;

    @BeforeEach
    void setup() {
        validDateOfBirth = "2004-12-26";
        invalidDateOfBirth = "2004-26-12";
        dateOfBirthWithoutDot = "26-12-2004";
        emptyDateOfBirth = " ";
    }

    @Test
    @Order(1)
    void testValidDateOfBirth() {
        try {
            assertTrue(UserValidator.validateDateOfBirth(validDateOfBirth));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidDateOfBirth() {
        try {
            UserValidator.validateDateOfBirth(invalidDateOfBirth);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid date of birth. Please provide a valid date in the format YYYY-MM-DD.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testDateOfBirthWithoutDot() {
        try {
            UserValidator.validateDateOfBirth(dateOfBirthWithoutDot);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid date of birth. Please provide a valid date in the format YYYY-MM-DD.", e.getMessage());
        }
    }
    
    @Test
    @Order(4)
    void testEmptyDateOfBirth() {
        try {
            UserValidator.validateDateOfBirth(emptyDateOfBirth);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid date of birth. Please provide a valid date in the format YYYY-MM-DD.", e.getMessage());
        }
    }
}