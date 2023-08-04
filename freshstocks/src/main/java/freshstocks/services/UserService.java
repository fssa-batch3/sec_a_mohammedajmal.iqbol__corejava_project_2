package freshstocks.services;
import freshstocks.services.*;

import freshstocks.model.User;
import freshstocks.services.exception.ServiceException;
import java.sql.SQLException;

import freshstocks.dao.*;
import freshstocks.validation.UserValidator;
import freshstocks.validation.exception.InvalidUserException;

public class UserService {
	
	public static boolean registerUser(User user) throws ServiceException {
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
	public static boolean updateUser(User user , int userID) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.update(user , userID)) {
				System.out.println("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//delete user
	public static boolean deleteUser(int userID , int isDeleted) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.delete(userID, isDeleted)) {
				System.out.println("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public static boolean loginUser(User user) throws ServiceException {
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
