package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.exception.ServiceException;

class TestDelete {
	
	public static final int isDeleted = 1;

	@Test
	void TestDeleteSuccess() {
		String userEmail = "ajmal@gmail.com";
		UserService userService = new UserService();
		try {
			assertTrue(userService.deleteUser(userEmail, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteFail() {
		String userEmail = "aji@gmail.com";
		UserService userService = new UserService();
		try {
			assertFalse(userService.deleteUser(userEmail, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}