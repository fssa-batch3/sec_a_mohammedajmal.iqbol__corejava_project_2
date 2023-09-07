package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;

 class UserServiceTest {
    private UserService userService;

    @BeforeEach
     void setUp() {
        // Initialize the service
        userService = new UserService();
    }

    @Test
     void testDeleteUserWithEmailDoesNotExist() throws ServiceException {
        // Arrange
        String userEmail = "ajmal@freshworks.com";
        int isDeleted = 1;

        // Act
        boolean result = userService.deleteUser(userEmail, isDeleted);

        // Assert
        assertFalse(result);
    }

    @Test
     void testGetUserProfilesFromUserID() throws ServiceException {
        // Arrange
        int userID = 19;

        // Act
        String userProfile = userService.getUserProfilesFromUserID(userID);

        // Assert
        assertNotNull(userProfile);
        // Add more specific assertions based on your expectations
    }
    
    @Test
    void testGetUserProfilesFromInvalidUserID() throws ServiceException {
       // Arrange
       int userID = 219;

       // Act
       String userProfile = userService.getUserProfilesFromUserID(userID);

       // Assert
       assertNull(userProfile);
       // Add more specific assertions based on your expectations
   }
    
    @Test
    void testDetailedConstructor() {
        // Arrange
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

        // Act
        User user = new User(userID, username, gender, mobileNumber, dateOfBirth, email, isSeller, createdAt, modifiedAt, isDeleted);

        // Assert
        assertNotNull(user);
    }
    
    @Test
    void testDemoPracticeConstructor() {
        // Arrange
        int id = 1;
        String name = "John";
        String emailId = "john@example.com";
        String password = "password123";

        // Act
        User user = new User(id, name, emailId, password);

        // Assert
        assertNotNull(user);
    }
    
    @Test
    void testLimitedConstructor() {
        // Arrange
        String username = "Alice";
        String gender = "Female";
        String mobileNumber = "987-654-3210";
        String dateOfBirth = "1995-05-15";
        String email = "alice@example.com";
        int isSeller = 0;
        String createdAt = "2023-09-07";
        String modifiedAt = "2023-09-07";

        // Act
        User user = new User(username, gender, mobileNumber, dateOfBirth, email, isSeller, createdAt, modifiedAt);

        // Assert
        assertNotNull(user);
    }
}
