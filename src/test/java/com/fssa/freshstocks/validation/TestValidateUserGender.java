package com.fssa.freshstocks.validation;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
            UserValidator.validateGender(validGender);
        } catch (InvalidUserException e) {
            fail("Unexpected InvalidUserException was thrown.");
        }
    }

    @Test
    @Order(2)
    void testInvalidGender() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateGender(invalidGender));
    }

    @Test
    @Order(3)
    void testGenderOthers() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateGender(genderOthers));
    }
    
    @Test
    @Order(4)
    void testGenderEmpty() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateGender(emptyGender));
    }
}
