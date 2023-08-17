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

//	Get user from DB - Login
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

	// Email Not Exist
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

	// email already exist using email params
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


	// add new user to DB - Register
	public boolean register(User user) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Prepare SQL Statement
			String insertQuery = "INSERT INTO freshstocks (userID,username,gender,mobile_number,date_of_birth,email,password,is_seller) VALUES (?,?,?,?,?,?,?,?);";
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

	// update user
	public boolean update(User user, String userEmail) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String updateQuery = "UPDATE freshstocks SET gender = ?, mobile_number = ?, date_of_birth = ? WHERE email = ?;";
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

	// delete user
	public boolean delete(String userEmail, int isDeleted) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String isDelete = Integer.toString(isDeleted);

			String deleteQuery = "UPDATE freshstocks SET is_deleted = ? WHERE email = ?;";
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