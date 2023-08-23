package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.exception.ServiceException;

class TestDelete {
	
    private UserService userService;
    private final int isDeleted = 1;

    @BeforeEach
    void setup() {
        userService = new UserService();
    }

    @Test
    @Order(1)
    void testDeleteSuccess() {
        String userEmail = "ajmal@gmail.com";
        try {
            assertTrue(userService.deleteUser(userEmail, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testDeleteFail() {
        String userEmail = "aji@gmail.com";
        try {
            assertFalse(userService.deleteUser(userEmail, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}