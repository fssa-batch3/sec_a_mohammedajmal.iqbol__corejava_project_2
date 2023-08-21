package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.utils.ConnectionUtil;


public class UserDAO {


	boolean match = false;
	
	private static final String USER_SELECT_QUERY = "SELECT * FROM freshstocks WHERE email = ?";
	private static final String EMAIL_COLUMN_NAME = "email";
	private static final String PASSWORD_COLUMN_NAME = "password";
	private static final String PREFIX_EMAIL_STRING = "Email: ";
	private static final String PREFIX_PASSWORD_STRING = "Password: ";
    public static final String CLOSE_RESOURCE_ERROR = "Error while closing resources: ";


    /**
     * Attempts to log in a user by verifying their email and password in the database.
     *
     * @param user The User object representing the user's login information.
     * @return {@code true} if the login was successful, {@code false} otherwise.
     * @throws DAOException If there's an error while interacting with the database.
     */
	public boolean login(User user) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(USER_SELECT_QUERY)) 
		{ 
			pst.setString(1, user.getEmail());
			try(ResultSet resultSet = pst.executeQuery()) {

			while (resultSet.next()) {
				String emailId = resultSet.getString(EMAIL_COLUMN_NAME);
				String password = resultSet.getString(PASSWORD_COLUMN_NAME);

				System.out.println(PREFIX_EMAIL_STRING + emailId + PREFIX_PASSWORD_STRING + password);

				if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
					match = true;
				}
			}
			}
		} catch (SQLException e) {
	        throw new DAOException("Error checking email exist: " + e);
	    }
		return match;
	}

	/**
	 * Checks whether a given email address already exists in the database.
	 *
	 * @param The user object contains email to check for existence.
	 * @return {@code true} if the email address already exists, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean emailExist(User user) throws DAOException {
	    boolean emailExists = false;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(USER_SELECT_QUERY)) {
	        pst.setString(1, user.getEmail());
	        try (ResultSet resultSet = pst.executeQuery()) {
	            while (resultSet.next()) {
	                String emailId = resultSet.getString(EMAIL_COLUMN_NAME);
	                String password = resultSet.getString(PASSWORD_COLUMN_NAME);
	                System.out.println(PREFIX_EMAIL_STRING + emailId + PREFIX_PASSWORD_STRING + password);
	                if (user.getEmail().equals(emailId)) {
	                	emailExists = true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error checking email exist: " + e);
	    }

	    return emailExists;
	}

	
	/**
	 * Checks whether a given email address already exists in the database.
	 *
	 * @param email The email address to check for existence.
	 * @return {@code true} if the email address already exists, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean emailAlreadyExist(String email) throws DAOException {
	    boolean emailAlreadyExist = false;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(USER_SELECT_QUERY)) {
	        pst.setString(1, email);
	        try (ResultSet resultSet = pst.executeQuery()) {
	            while (resultSet.next()) {
	                String emailId = resultSet.getString(EMAIL_COLUMN_NAME);
	                String password = resultSet.getString(PASSWORD_COLUMN_NAME);
	                System.out.println(PREFIX_EMAIL_STRING + emailId + PREFIX_PASSWORD_STRING + password);
	                if (email.equals(emailId)) {
	                	emailAlreadyExist = true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error while checking email exist: " + e);
	    }

	    return emailAlreadyExist;
	}


	/**
	 * Registers a new user in the database.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return {@code true} if the registration was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean register(User user) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Prepare SQL Statement
			String insertQuery = "INSERT INTO freshstocks (userID,username,gender,mobile_number,date_of_birth,email,password,is_seller) VALUES (?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, user.getUserID());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getmobileNumber());
			pst.setString(5, user.getdateOfBirth());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getPassword());
			pst.setInt(8, user.getIsSeller());
			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while creating user: " + e);
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(CLOSE_RESOURCE_ERROR + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}

	
	/**
	 * Updates a user's information in the database.
	 *
	 * @param The User object containing the updated user information.
	 * @param userEmail The email address of the user to be updated.
	 * @return {@code true} if the update was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean update(User user, String userEmail) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String updateQuery = "UPDATE freshstocks SET gender = ?, mobile_number = ?, date_of_birth = ? WHERE email = ?";
			pst = connection.prepareStatement(updateQuery);
			pst.setString(1, user.getGender());
			pst.setString(2, user.getmobileNumber());
			pst.setString(3, user.getdateOfBirth());
			pst.setString(4, userEmail);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while updaing user: " + e);
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(CLOSE_RESOURCE_ERROR + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}

	
	/**
	 * Marks a user as deleted or undeleted in the database.
	 *
	 * @param userEmail The email address of the user to be marked.
	 * @param isDeleted The value indicating whether the user should be marked as deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean delete(String userEmail, int isDeleted) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String isDelete = Integer.toString(isDeleted);

			String deleteQuery = "UPDATE freshstocks SET is_deleted = ? WHERE email = ?";
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, isDelete);
			pst.setString(2, userEmail);

			// Execute query
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error while deleting user: " + e);
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(CLOSE_RESOURCE_ERROR + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}
}