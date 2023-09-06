package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.validation.exception.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestValidateUpdateUser {
	
    private User validUser;
    private User invalidUserWithNull;
    private User invalidUserWithInvalidMobileNumber;
    private User invalidUserWithInvalidDateOdBirth;
    private User invalidUserWithInvalidGender;

    @BeforeEach
    void setup() {
        validUser = new User("Female", "9500320194", "2004-12-26");
        invalidUserWithNull = null;
        invalidUserWithInvalidMobileNumber = new User("Female", "+-@9500320", "2004-12-26"); // Invalid Mobile Number
        invalidUserWithInvalidDateOdBirth = new User("Female", "9500320194", "20041226"); // Invalid DOB
        invalidUserWithInvalidGender = new User("India", "9500320194", "2004-12-26"); // Invalid Gender
    }

    @Test
    @Order(1)
    void testValidUser() {
    	 try {
             UserValidator.validateUpdateUser(validUser);
         } catch (InvalidUserException e) {
             e.printStackTrace();
         }
    }

    @Test
    @Order(2)
    void testInvalidUserWithNull() {
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateUpdateUser(invalidUserWithNull);
        });
    }

    @Test
    @Order(3)
    void testInvalidUserWithInvalidMobileNumber() {
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateUpdateUser(invalidUserWithInvalidMobileNumber);
        });
    }

    @Test
    @Order(4)
    void testInvalidUserWithInvalidDateOfBirth() {
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateUpdateUser(invalidUserWithInvalidDateOdBirth);
        });
    }

    @Test
    @Order(5)
    void testInvalidUserWithInvalidGender() {
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateUpdateUser(invalidUserWithInvalidGender);
        });
    }
}
