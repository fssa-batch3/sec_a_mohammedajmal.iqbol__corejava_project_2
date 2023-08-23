package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserMobileNumber {

    private String validMobileNumber;
    private String invalidMobileNumber;
    private String validOutsideIndiaMobileNumber;
    private String emptyMobileNumber;

    @BeforeEach
    void setup() {
        validMobileNumber = "+919500320194";
        invalidMobileNumber = "abc1234567";
        validOutsideIndiaMobileNumber = "+44-7890123456";
        emptyMobileNumber = " ";
    }

    @Test
    @Order(1)
    void testValidMobileNumber() {
        try {
            assertTrue(UserValidator.validateMobileNumber(validMobileNumber));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidMobileNumber() {
        try {
            UserValidator.validateMobileNumber(invalidMobileNumber);
            fail("Expected InvalidUserException was not thrown.");
        } catch (InvalidUserException e) {
            assertEquals("Invalid mobile number. Please provide a valid phone number, including the country code and area code if applicable.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testValidOutsideIndiaMobileNumber() {
        try {
            assertTrue(UserValidator.validateMobileNumber(validOutsideIndiaMobileNumber));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    @Order(4)
    void testEmptyMobileNumber() {
        try {
            assertTrue(UserValidator.validateMobileNumber(emptyMobileNumber));
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }
}
