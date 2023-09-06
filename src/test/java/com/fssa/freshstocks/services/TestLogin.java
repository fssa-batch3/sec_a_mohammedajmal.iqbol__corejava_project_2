package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.*;
import com.fssa.freshstocks.model.*;

class TestLogin {

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService();
    }

    @Test
    @Order(1)
    void TestValidUser() {
        User user1 = new User("ajmal@gmail.com", "Ajmal@123");
        try {
            assertTrue(userService.loginUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void TestInValidUser() {
        User user1 = new User("hacker@gmail.com", "Hacker@123");
        try {
            assertFalse(userService.loginUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
