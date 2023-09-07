package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestRegister {

    private UserService userService;
    private final long nanotime = System.nanoTime();

    @BeforeEach
    void setup() {
        userService = new UserService();
    }

    @Test
    @Order(1)
    void testRegistrationSuccess() {
        User user1 = new User("User_" + nanotime, "Male", "9500320194", "2004-12-26", "user" + nanotime + "@gmail.com",
                "Lakshmi@123",1);
        try {
            assertTrue(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testInvalidPassword() {
        User user1 = new User("User_" + nanotime, "Male", "9500320194", "2004-12-26", "user" + nanotime + "@gmail.com",
                "Lakshmi123",1);
        try {
            assertFalse(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void testUserNull() {
        User user1 = null;

        assertThrows(NullPointerException.class, () -> {
            userService.registerUser(user1);
        });
    }
    
    @Test
    @Order(4)
    void testRegistrationFailEmailExist() {
        User user1 = new User("User_" + nanotime, "Male", "9500320194", "2004-12-26", "freekyajmal65@gmail.com",
                "Ajmal@123",1);
        try {
            assertFalse(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
}