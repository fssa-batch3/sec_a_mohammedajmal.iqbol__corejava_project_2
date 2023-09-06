package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.validation.exception.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestValidateUser {
	
    private User validUser;
    private User invalidUserWithNull;
    private User invalidUserWithInvalidEmail;
    private User invalidUserWithInvalidPassword;

    @BeforeEach
    void setup() {
        validUser = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com", "Lakshmi@123", 1);
        invalidUserWithNull = null;
        invalidUserWithInvalidEmail = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12gmail.com", "Lakshmi@123", 1);
        invalidUserWithInvalidPassword = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com", "Lakshmi123", 1);
    }

    @Test
    @Order(1)
    void testValidUser() {
        try {
            UserValidator.validateUser(validUser);
        } catch (InvalidUserException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidUserWithNull() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(invalidUserWithNull));
    }

    @Test
    @Order(3)
    void testInvalidUserWithInvalidEmail() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(invalidUserWithInvalidEmail));
    }

    @Test
    @Order(4)
    void testInvalidUserWithInvalidPassword() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(invalidUserWithInvalidPassword));
    }    
}
