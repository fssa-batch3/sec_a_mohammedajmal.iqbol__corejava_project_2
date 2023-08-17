package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestRegister {

	public static void main(String[] args) {

		User user1 = new User("Lakshmii_123", "Female", "9500320194", "2004-12-26", "lakshmi13@gmail.com",
				"Lakshmi@123",1);
		UserService userService = new UserService();

		try {
			if (!userService.registerUser(user1)) {
				System.out.println("Registration not successful! Error : Validation Failed Or User Already Exist");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com",
				"Lakshmi@123",1);
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Lakshmi_123", "Female", "9500320194", "2004-12-26", "lakshmi12@gmail.com", "Lakshmi123",1);
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;

		assertThrows(NullPointerException.class, () -> {
			userService.registerUser(user1);
		});
	}

}