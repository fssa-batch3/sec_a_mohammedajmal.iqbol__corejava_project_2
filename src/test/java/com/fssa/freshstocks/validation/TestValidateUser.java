package com.fssa.freshstocks.validation;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.validation.exception.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestValidateUser {
	

    @Test
    void testValidUser() throws InvalidUserException {
    	User user1 = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com",
				"Lakshmi@123");
        assertTrue(UserValidator.validateUser(user1));
    }

    @Test
    void testInvalidUserWithNull() {
    	User user1 = null;
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(user1));
    }

    @Test
    void testInvalidUserWithInvalidEmail() {
    	User user1 = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12gmail.com",
				"Lakshmi@123"); // Invalid email
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(user1));
    }

    @Test
    void testInvalidUserWithInvalidPassword() {
    	User user1 = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com",
				"Lakshmi123"); // Invalid password
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(user1));
    }
    
}
