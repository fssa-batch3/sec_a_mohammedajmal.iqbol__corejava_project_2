package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;

 class UserServiceTest {
    private UserService userService;

    @BeforeEach
     void setUp() {
        userService = new UserService();
    }

    @Test
     void testDeleteUserWithEmailDoesNotExist() throws ServiceException {    
        String userEmail = "ajmal@freshworks.com";
        int isDeleted = 1;
        boolean result = userService.deleteUser(userEmail, isDeleted);
        assertFalse(result);
    }

    @Test
     void testGetUserProfilesFromUserID() throws ServiceException {
        int userID = 19;
        String userProfile = userService.getUserProfilesFromUserID(userID);
        assertNotNull(userProfile);
    }
    
    @Test
    void testGetUserProfilesFromInvalidUserID() throws ServiceException {
       int userID = 219;
       String userProfile = userService.getUserProfilesFromUserID(userID);
       assertNull(userProfile);
   }
    
    @Test
    void testGetUserFromEmail() throws ServiceException {
       String email = "ajmal78@gmail.com";
       User user = userService.getUserByEmail(email);
       assertNotNull(user);
   }
    
    @Test
    void testGetUserFromUserID() throws ServiceException {
       int userID = 65;
       User user = userService.getUserByUserId(userID);
       assertNotNull(user);
   }
    
    @Test
    public void testpdatePassword() throws DAOException {
        boolean user;
		try {
			user = userService.updateUserPassword("$2a$10$E4SqDEbGKCYMD5b/wzsruuvgbH0BNwYTOfV.egtJ7qD886yVg2Jqi", "user478900606602600@gmail.com");
		} catch (ServiceException e) {
			throw new DAOException(e);
		}
        assertTrue(user);
    }
    
    @Test
    public void testpdatePasswordInvalid() throws DAOException {
        boolean user;
		try {
			user = userService.updateUserPassword("$2a$10$E4SqDEbGKCYMD5b/wzsruuvgbH0BNwYTOfV.egtJ7qD886yVg2Jqi", "user47890@gmail.com");
		} catch (ServiceException e) {
			throw new DAOException(e);
		}
        assertFalse(user);
    }
    
    
    @Test
    void testDetailedConstructor() {
        int userID = 1;
        String username = "JohnDoe";
        String gender = "Male";
        String mobileNumber = "1234567890";
        String dateOfBirth = "1990-01-01";
        String email = "john@example.com";
        int isSeller = 1;
        String createdAt = "2023-09-07";
        String modifiedAt = "2023-09-07";
        int isDeleted = 0;
        User user = new User(userID, username, gender, mobileNumber, dateOfBirth, email, isSeller, createdAt, modifiedAt, isDeleted);
        assertNotNull(user);
    }
    
    @Test
    void testDemoPracticeConstructor() {
        int id = 1;
        String name = "John";
        String emailId = "john@example.com";
        String password = "password123";
        User user = new User(id, name, emailId, password);
        assertNotNull(user);
    }
    
    @Test
    void testLimitedConstructor() {
        String username = "Alice";
        String gender = "Female";
        String mobileNumber = "987-654-3210";
        String dateOfBirth = "1995-05-15";
        String email = "alice@example.com";
        int isSeller = 0;
        String createdAt = "2023-09-07";
        String modifiedAt = "2023-09-07";
        User user = new User(username, gender, mobileNumber, dateOfBirth, email, isSeller, createdAt, modifiedAt);
        assertNotNull(user);
    }
}
