package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.services.exception.ServiceException;

class TestDelete {
	
	public static final int isDeleted = 1;

	public static void main(String[] args) {

		String userEmail = "lakshmi12@gmail.com";

		// if (isDeleted = 1) then we have to consider that user is deleted
		UserService userService = new UserService();

		try {
			if (!userService.deleteUser(userEmail, isDeleted)) {
				System.out.println("Delete User not successful!");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteSuccess() {
		String userEmail = "lakshmi12@gmail.com";
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
		String userEmail = "lakshmi120@gmail.com";
		UserService userService = new UserService();
		try {
			assertFalse(userService.deleteUser(userEmail, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}