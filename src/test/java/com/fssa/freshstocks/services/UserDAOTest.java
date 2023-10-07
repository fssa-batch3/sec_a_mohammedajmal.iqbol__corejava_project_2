package com.fssa.freshstocks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;

public class UserDAOTest {
	
    private UserDAO dao;

    @BeforeEach
     void setUp() {
        dao = new UserDAO();
    }

    @Test
    public void testUpdateUserPurchasedCoursesValid() throws DAOException {
        boolean updated = dao.updateUserPurchasedCourses("1", "20,30,31");
        assertTrue(updated);
    }

    @Test
    public void testUpdateUserPurchasedCoursesInvalid() throws DAOException {
        boolean updated = dao.updateUserPurchasedCourses("-1", "20,30,31");
        assertFalse(updated);
    }

    @Test
    public void testFetchUserIDByEmailValid() throws DAOException {
        User user = dao.fetchUserIDByEmail("jayaprakash321@gmail.com");
        assertNotNull(user);
    }

    @Test
    public void testFetchUserIDByEmailInvalid() throws DAOException {
        User user = dao.fetchUserIDByEmail("test@example.com");
        assertNull(user);
    }

    @Test
    public void testFetchUserIDByUserIdValid() throws DAOException {
        User user = dao.fetchUserIDByEmail(65);
        assertNotNull(user);
        assertEquals(65, user.getUserId());
    }

    @Test
    public void testFetchUserIDByUserIdInvalid() throws DAOException {
        User user = dao.fetchUserIDByEmail(-1);
        assertNull(user);
    }
    
    @Test
    public void testpdatePassword() throws DAOException {
        boolean user = dao.updatePassword("$2a$10$E4SqDEbGKCYMD5b/wzsruuvgbH0BNwYTOfV.egtJ7qD886yVg2Jqi", "user478900606602600@gmail.com");
        assertTrue(user);
    }
    
    @Test
    public void testpdatePasswordInvalid() throws DAOException {
        boolean user = dao.updatePassword("$2a$10$E4SqDEbGKCYMD5b/wzsruuvgbH0BNwYTOfV.egtJ7qD886yVg2Jqi", "user47890@gmail.com");
        assertFalse(user);
    }

    @Test
    public void testGetAllUsers() throws DAOException, SQLException {
        List<User> users = dao.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
