package com.fssa.freshstocks.services;

import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.UserValidator;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class UserService {

	/**
	 * Registers a new user.
	 *
	 * @param user The User object containing the user details.
	 * @return true if the user was successfully registered, false otherwise.
	 * @throws ServiceException If an error occurs during the user registration
	 *                          process.
	 */
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getEmail(), user.getPassword());
		try {
			UserValidator.validateUser(user);
			userDAO.emailExist(user1);
			return userDAO.register(user);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Attempts to log in a user with the given credentials.
	 *
	 * @param user The User object containing the user's login credentials.
	 * @return true if the login was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the login process.
	 */
	public boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			return userDAO.login(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Updates user details based on the given user email.
	 *
	 * @param user      The updated User object.
	 * @param userEmail The email of the user whose details are to be updated.
	 * @return true if the user details were successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs while updating the user details.
	 */
	public boolean updateUser(User user, String userEmail) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.emailAlreadyExist(userEmail);
			UserValidator.validateUpdateUser(user);
			return userDAO.update(user, userEmail);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Deletes a user's details based on the given user email.
	 *
	 * @param userEmail The email of the user whose details are to be deleted.
	 * @param isDeleted An indicator of whether the user should be marked as
	 *                  deleted. (0 for not deleted, 1 for deleted)
	 * @return true if the user details were successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs while deleting the user details.
	 */
	public boolean deleteUser(String userEmail, int isDeleted) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.emailAlreadyExist(userEmail)) {
				return userDAO.delete(userEmail, isDeleted);
			} else {
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public String getUserProfilesFromUserID(int userID) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			return userDAO.getUserProfileFromUserID(userID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
