package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.*;

class TestUpdate {

	public static void main(String[] args) {

		User user1 = new User("Male", "9500320194", "2004-12-26");
		String userEmail = "freekyajmal@gmail.com";
		UserService userService = new UserService();

		try {
			if (!userService.updateUser(user1, userEmail)) {
				System.out.println("Update User not successful!");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestUpdateSuccess() {
		User user1 = new User("Male", "9500320194", "2004-12-26");
		String userEmail = "lakshmi12@gmail.com";
		UserService userService = new UserService();
		try {
			assertTrue(userService.updateUser(user1, userEmail));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestUpdateFail() {
		User user1 = new User("Male", "9500320194", "2004-12-26");
		// this userEmail doesn't exist so, it return false and our test cases is true
		String userEmail = "ajmal@gmail.com";
		UserService userService = new UserService();
		try {
			assertFalse(userService.updateUser(user1, userEmail));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
