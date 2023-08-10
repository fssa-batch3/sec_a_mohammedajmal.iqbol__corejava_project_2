package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.services.UserService;
import com.fssa.freshstocks.services.exception.ServiceException;

public class TestDelete {

	public static void main(String[] args) {

		String userEmail = "lakshmi12@gmail.com";
		
		// if (isDeleted = 1) then we have to consider that user is deleted
		final int isDeleted = 1;
	    UserService userService = new UserService();

	    try {
	        if (!userService.deleteUser(userEmail,isDeleted)) {
	            System.out.println("Delete User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        fail();
	    }
	}

	@Test
	void TestDeleteSuccess() throws DAOException {
		String userEmail = "lakshmi12@gmail.com";
		int isDeleted = 1;
		UserService userService = new UserService();
        try {
			assertTrue(UserService.deleteUser(userEmail,isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void TestDeleteFail() throws com.fssa.freshstocks.services.exception.ServiceException, DAOException {
		String userEmail = "lakshmi120@gmail.com";
		int is_deleted = 1;
		UserService userService = new UserService();
        assertFalse(UserService.deleteUser(userEmail,is_deleted));
	}
	
}