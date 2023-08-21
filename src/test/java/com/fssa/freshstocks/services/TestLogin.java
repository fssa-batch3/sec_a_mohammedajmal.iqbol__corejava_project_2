package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.*;
import com.fssa.freshstocks.model.*;

class TestLogin {

	@Test
	void TestValidUser() {
		User user1 = new User("hacker4@gmail.com", "Kotie@123");
		UserService userService = new UserService();
		try {
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestInValidUser() {
		User user1 = new User("hacker@gmail.com", "Hacker@123");
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
