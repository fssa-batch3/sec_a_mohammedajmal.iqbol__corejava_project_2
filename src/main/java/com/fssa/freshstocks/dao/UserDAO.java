package com.fssa.freshstocks.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshstocks.constants.*;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.utils.ConnectionUtil;
import com.fssa.freshstocks.utils.exception.DatabaseException;

public class UserDAO {

	/**
	 * Attempts to log in a user by verifying their email and password in the
	 * database.
	 *
	 * @param user The User object representing the user's login information.
	 * @return {@code true} if the login was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public User login(User user) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(UserModuleConstants.USER_SELECT_QUERY)) {

			pst.setString(1, user.getEmail());

			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String emailId = resultSet.getString(UserModuleConstants.EMAIL_COLUMN_NAME);
					String password = resultSet.getString(UserModuleConstants.PASSWORD_COLUMN_NAME);

					return new User(emailId, password);
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.EMAIL_ERROR_MESSAGE + e);
		}
		return null;
	}

	/**
	 * Checks whether a given email address already exists in the database.
	 *
	 * @param The user object contains email to check for existence.
	 * @return {@code true} if the email address already exists, {@code false}
	 *         otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean emailExist(User user) throws DAOException {
		boolean emailExists = false;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(UserModuleConstants.USER_SELECT_QUERY)) {
			pst.setString(1, user.getEmail());
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String emailId = resultSet.getString(UserModuleConstants.EMAIL_COLUMN_NAME);
					if (user.getEmail().equals(emailId)) {
						emailExists = true;
					}
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.EMAIL_ERROR_MESSAGE + e);
		}

		return emailExists;
	}

	/**
	 * Checks whether a given email address already exists in the database.
	 *
	 * @param email The email address to check for existence.
	 * @return {@code true} if the email address already exists, {@code false}
	 *         otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean emailAlreadyExist(String email) throws DAOException {
		boolean emailAlreadyExist = false;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(UserModuleConstants.USER_SELECT_QUERY)) {
			pst.setString(1, email);
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String emailId = resultSet.getString(UserModuleConstants.EMAIL_COLUMN_NAME);
					if (email.equals(emailId)) {
						emailAlreadyExist = true;
						break;
					}
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.EMAIL_ERROR_MESSAGE + e);
		}

		return emailAlreadyExist;
	}

	/**
	 * Registers a new user in the database.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return {@code true} if the registration was successful, {@code false}
	 *         otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean register(User user) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(
						"INSERT INTO freshstocks (user_id, username, gender, mobile_number, date_of_birth, email, password, is_seller, avatar_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

			pst.setInt(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getMobileNumber());
			pst.setString(5, user.getDateOfBirth());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getPassword());
			pst.setInt(8, user.getIsSeller());
			pst.setString(9, "https://ui-avatars.com/api/?name=" + user.getUsername() + "&background=random");

			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.REGISTER_ERROR_MESSAGE + e);
		}

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
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(
						"UPDATE freshstocks SET avatar_url= ?, gender = ?, mobile_number = ?, date_of_birth = ? WHERE email = ?")) {

			pst.setString(1, user.getProfilePic());
			pst.setString(2, user.getGender());
			pst.setString(3, user.getMobileNumber());
			pst.setString(4, user.getDateOfBirth());
			pst.setString(5, userEmail);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.UPDATE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}
	
	/**
	 * Updates the user's password in the database.
	 *
	 * @param password The new password.
	 * @param userEmail The email address associated with the user.
	 * @return True if the password was updated successfully, false otherwise.
	 * @throws DAOException If an error occurs during the update process.
	 */
	public boolean updatePassword(String password, String userEmail) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(
						"UPDATE freshstocks SET password = ? WHERE email = ?")) {

			pst.setString(1, password);
			pst.setString(2, userEmail);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.UPDATE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}

	/**
	 * Marks a user as deleted or undeleted in the database.
	 *
	 * @param userEmail The email address of the user to be marked.
	 * @param isDeleted The value indicating whether the user should be marked as
	 *                  deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean delete(String userEmail, int isDeleted) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("UPDATE freshstocks SET is_deleted = ? WHERE email = ?")) {

			String isDelete = Integer.toString(isDeleted);
			pst.setString(1, isDelete);
			pst.setString(2, userEmail);

			// Execute query
			rows = pst.executeUpdate();

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.DELETE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}
	
	
	
	/**
	 * retrieve the user profile using getUserProfileFromUserID method from the database.
	 *
	 * @param The parameter contains userID to check for existence.
	 * @return {@code true} if the userID is valid, {@code false}
	 *         otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public String getUserProfileFromUserID(int userID) throws DAOException {
		String userProfile = null;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT avatar_url FROM freshstocks WHERE user_id=?")) {
			pst.setInt(1, userID);
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					userProfile = resultSet.getString("avatar_url");
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(UserModuleConstants.EMAIL_ERROR_MESSAGE + e);
		}

		return userProfile;
	}
	
	
	/**
	 * Updates the purchased courses for a user in the database.
	 *
	 * @param userId The unique identifier of the user.
	 * @param purchasedCourses A string representing the updated list of purchased courses.
	 * @return True if the update was successful, false otherwise.
	 * @throws DAOException If an error occurs during the update process.
	 */
	public boolean updateUserPurchasedCourses(String userId, String purchasedCourses) throws DAOException {
	    String sql = "UPDATE freshstocks SET purchased_courses = ? WHERE user_id = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, purchasedCourses);
	        stmt.setString(2, userId);
	        int rowsAffected = stmt.executeUpdate();

	        return rowsAffected > 0;
	    } catch (SQLException | DatabaseException e) {
	    	throw new DAOException("Error Updating Purchase Courses: " + e);
		}
	}
	
	

	/**
	 * Retrieves user details based on the provided email address.
	 *
	 * @param email The email address of the user.
	 * @return The User object associated with the provided email, or null if not found.
	 * @throws DAOException If an error occurs during the retrieval process.
	 */
	public static User fetchUserIDByEmail(String email) throws DAOException {
		User user1 = null;
		// Database query
		String query = "SELECT * FROM freshstocks WHERE email = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, email);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int userID = resultSet.getInt("user_id");
					String username = resultSet.getString("username");
					String gender = resultSet.getString("gender");
					String mobileNumber = resultSet.getString("mobile_number");
					String dateOfBirth = resultSet.getString("date_of_birth");
					String profilePic = resultSet.getString("avatar_url");
					String userEmail = resultSet.getString("email");
					String password = resultSet.getString("password");
					int isSeller = resultSet.getInt("is_seller");
					String createdAt = resultSet.getString("created_at");
					String modifiedAt = resultSet.getString("modified_at");
					int isDeleted = resultSet.getInt("is_deleted");
					String purchasedCourses;
					if(resultSet.getString("purchased_courses") != null) {
					 purchasedCourses = resultSet.getString("purchased_courses");
					} else {
					 purchasedCourses = "0";
					}
					
					user1 = new User(userID,username,gender,mobileNumber,dateOfBirth,userEmail,password,isSeller,createdAt,modifiedAt,isDeleted,profilePic,purchasedCourses);
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException("Error fetching user details: " + e);
		}
		return user1;
	}
	
	
	/**
	 * Retrieves user details based on the provided user ID.
	 *
	 * @param userId The unique identifier of the user.
	 * @return The User object associated with the provided user ID, or null if not found.
	 * @throws DAOException If an error occurs during the retrieval process.
	 */
	public static User fetchUserIDByEmail(int userId) throws DAOException {
		User user1 = null;
		// Database query
		String query = "SELECT * FROM freshstocks WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, userId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int userID = resultSet.getInt("user_id");
					String username = resultSet.getString("username");
					String gender = resultSet.getString("gender");
					String mobileNumber = resultSet.getString("mobile_number");
					String dateOfBirth = resultSet.getString("date_of_birth");
					String profilePic = resultSet.getString("avatar_url");
					String userEmail = resultSet.getString("email");
					String password = resultSet.getString("password");
					int isSeller = resultSet.getInt("is_seller");
					String createdAt = resultSet.getString("created_at");
					String modifiedAt = resultSet.getString("modified_at");
					int isDeleted = resultSet.getInt("is_deleted");
					String purchasedCourses;
					if(resultSet.getString("purchased_courses") != null) {
					 purchasedCourses = resultSet.getString("purchased_courses");
					} else {
					 purchasedCourses = "0";
					}
					
					user1 = new User(userID,username,gender,mobileNumber,dateOfBirth,userEmail,password,isSeller,createdAt,modifiedAt,isDeleted,profilePic,purchasedCourses);
				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException("Error fetching user details: " + e);
		}
		return user1;
	}
	 
	/**
	 * Retrieves a list of all users from the database.
	 *
	 * @return A list of User objects representing all users.
	 * @throws SQLException If an SQL error occurs during the retrieval process.
	 * @throws DAOException If an error occurs during the retrieval process.
	 */
    public List<User> getAllUsers() throws SQLException, DAOException {
        List<User> users = new ArrayList<>();
        User user1 = null;
        try (Connection connection = ConnectionUtil.getConnection();
        		Statement statement = connection.createStatement();) {
            String query = "SELECT * FROM freshstocks";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
            	int userID = resultSet.getInt("user_id");
				String username = resultSet.getString("username");
				String gender = resultSet.getString("gender");
				String mobileNumber = resultSet.getString("mobile_number");
				String dateOfBirth = resultSet.getString("date_of_birth");
				String profilePic = resultSet.getString("avatar_url");
				String userEmail = resultSet.getString("email");
				String password = resultSet.getString("password");
				int isSeller = resultSet.getInt("is_seller");
				String createdAt = resultSet.getString("created_at");
				String modifiedAt = resultSet.getString("modified_at");
				int isDeleted = resultSet.getInt("is_deleted");
				String purchasedCourses;
				if(resultSet.getString("purchased_courses") != null) {
				 purchasedCourses = resultSet.getString("purchased_courses");
				} else {
				 purchasedCourses = "0";
				}
				
				user1 = new User(userID,username,gender,mobileNumber,dateOfBirth,userEmail,password,isSeller,createdAt,modifiedAt,isDeleted,profilePic,purchasedCourses);
				
				users.add(user1);
            }
        } catch (DatabaseException e) {
        	throw new DAOException("Error fetching all users: " + e);
		}

        return users;
    }
}