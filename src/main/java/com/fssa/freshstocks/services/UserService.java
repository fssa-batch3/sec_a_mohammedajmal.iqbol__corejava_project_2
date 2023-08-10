package com.fssa.freshstocks.services;
import java.sql.SQLException;

import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.*;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.UserValidator;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class UserService {
	
	public static boolean registerUser(User user) throws ServiceException, DAOException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getEmail(),user.getPassword());
		try {
		if(UserValidator.validateUser(user) && !userDAO.emailExist(user1)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getUsername() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	//update user
	public static boolean updateUser(User user , String userEmail) throws ServiceException, DAOException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.emailAlreadyExist(userEmail)) {
			if(userDAO.update(user , userEmail)) {
				System.out.println("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
			} else {
				System.out.println("User Email Doesn't Exist!");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//delete user
	public static boolean deleteUser(String userEmail , int isDeleted) throws ServiceException, DAOException {
		UserDAO userDAO = new UserDAO();
		try {
		if(userDAO.emailAlreadyExist(userEmail)) {
			if(userDAO.delete(userEmail, isDeleted)) {
				System.out.println("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("User Email Doesn't Exist!");
			return false;
		}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public static boolean loginUser(User user) throws ServiceException, DAOException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.login(user)) {
				System.out.println("\n" + user.getEmail() + " Login Successful!");
				return true;
			} else {
				System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
}
