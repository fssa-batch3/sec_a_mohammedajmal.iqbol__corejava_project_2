package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
            UserValidator.validateMobileNumber(validMobileNumber);
        } catch (InvalidUserException e) {
            fail("Unexpected InvalidUserException was thrown.");
        }
    }

    @Test
    @Order(2)
    void testInvalidMobileNumber() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateMobileNumber(invalidMobileNumber));
    }

    @Test
    @Order(3)
    void testValidOutsideIndiaMobileNumber() {
        try {
            UserValidator.validateMobileNumber(validOutsideIndiaMobileNumber);
        } catch (InvalidUserException e) {
            fail("Unexpected InvalidUserException was thrown.");
        }
    }
    
    @Test
    @Order(4)
    void testEmptyMobileNumber() {
    	assertThrows(InvalidUserException.class, () -> UserValidator.validateMobileNumber(invalidMobileNumber));
    }
}
