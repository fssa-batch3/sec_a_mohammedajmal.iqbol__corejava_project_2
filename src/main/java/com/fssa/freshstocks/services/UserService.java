package com.fssa.freshstocks.services;

import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.UserValidator;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getEmail(), user.getPassword());
		try {
			if (UserValidator.validateUser(user) && !userDAO.emailExist(user1)) {
				boolean success = userDAO.register(user);
				if (success) {
					System.out.println(user.getUsername() + " Successfully Registered!");
				}
				return success;
			} else {
				return false;
			}
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	// update user
	public boolean updateUser(User user, String userEmail) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.emailAlreadyExist(userEmail)) {
				boolean success = userDAO.update(user, userEmail);
				if (success) {
					System.out.println("User Details Successfully Updated!");
				}
				return success;
			} else {
				System.out.println("User Email Doesn't Exist!");
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	// delete user
	public boolean deleteUser(String userEmail, int isDeleted) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.emailAlreadyExist(userEmail)) {
				boolean success = userDAO.delete(userEmail, isDeleted);
				if (success) {
					System.out.println("User Details Successfully Deleted!");
				}
				return success;
			} else {
				System.out.println("User Email Doesn't Exist!");
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			boolean success = userDAO.login(user);
			if (success) {
				System.out.println("\n" + user.getEmail() + " Login Successful!");
			}
			return success;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
