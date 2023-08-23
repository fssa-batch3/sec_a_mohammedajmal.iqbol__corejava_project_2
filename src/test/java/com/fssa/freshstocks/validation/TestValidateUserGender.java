package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;


class TestValidateUserGender {

    private String validGender;
    private String invalidGender;
    private String genderOthers;
    private String emptyGender;

    @BeforeEach
    void setup() {
        validGender = "male";
        invalidGender = "121323";
        genderOthers = "non-conforming";
        emptyGender = " ";
    }

    @Test
    @Order(1)
    void testValidGender() {
        try {
            assertTrue(UserValidator.validateGender(validGender));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidGender() {
        try {
            UserValidator.validateGender(invalidGender);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Given Gender is not valid. Expected Input: male|female|others", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testGenderOthers() {
        try {
            UserValidator.validateGender(genderOthers);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Given Gender is not valid. Expected Input: male|female|others", e.getMessage());
        }
    }
    
    @Test
    @Order(4)
    void testGenderEmpty() {
        try {
            UserValidator.validateGender(emptyGender);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Given Gender is not valid. Expected Input: male|female|others", e.getMessage());
        }
    }
}
