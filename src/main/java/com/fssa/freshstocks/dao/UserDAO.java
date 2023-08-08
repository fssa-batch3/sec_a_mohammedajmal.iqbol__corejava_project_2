package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshstocks.model.User;

import io.github.cdimascio.dotenv.Dotenv;


public class UserDAO {

	
	 //connect to database
	// connection to database from environment variable in run configurations secure method
    public Connection getConnection() throws SQLException {
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

	
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
	
	   Connection connection = null;
	   ResultSet resultSet = null;
	   PreparedStatement pst = null;
	   
	   try {
	   
		   connection = getConnection();

	   String selectQuery = "SELECT * FROM freshstocks WHERE email = ?";
	   pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.getEmail());
	   resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailId = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailId + " Password: " + password);
		   
		   if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
			   match = true;
		   }
	   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   
		   if(resultSet != null) {
			   resultSet.close();
		   }
		   if(pst != null) {
			   pst.close();
		   }
		   if(connection != null) {
			   connection.close();
		   }
		   
	   }
	   return match;
	}
   
   //Email Not Exist
   public boolean emailExist(User user) throws SQLException {
		
	   Connection connection = null;
	   ResultSet resultSet = null;
	   PreparedStatement pst = null;
	   
	   try {
	   connection = getConnection();
	   
	   String emailExistQuery = "SELECT * FROM freshstocks WHERE email = ?";
	   pst = connection.prepareStatement(emailExistQuery);
	   pst.setString(1, user.getEmail());
	   resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailId = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailId + " Password: " + password);
		   
		   if(user.getEmail().equals(emailId)) {
			   match = true;
		   }
	   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   
		   if(resultSet != null) {
			   resultSet.close();
		   }
		   if(pst != null) {
			   pst.close();
		   }
		   if(connection != null) {
			   connection.close();
		   }
	   }
	   return match;
	}
   
   //email already exist using email params
   public boolean emailAlreadyExist(String email) throws SQLException {
		
	   Connection connection = null;
	   ResultSet resultSet = null;
	   PreparedStatement pst = null;
	   
	   try {
	   connection = getConnection();
	   
	   String emailExistQuery = "SELECT * FROM freshstocks WHERE email = ?";
	   pst = connection.prepareStatement(emailExistQuery);
	   pst.setString(1, email);
	   resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailId = resultSet.getString("email");
		   String password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailId + " Password: " + password);
		   
		   if(email.equals(emailId)) {
			   match = true;
		   }
	   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   
		   if(resultSet != null) {
			   resultSet.close();
		   }
		   if(pst != null) {
			   pst.close();
		   }
		   if(connection != null) {
			   connection.close();
		   }
	   }
	   return match;
	}
   
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;
		   
		try {
		//Get Connection
		connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO freshstocks (userID,username,gender,mobile_number,date_of_birth,email,password) VALUES (?,?,?,?,?,?,?);";
		pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUserID());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getGender());
		pst.setString(4, user.getmobileNumber());
		pst.setString(5, user.getdateOfBirth());
		pst.setString(6, user.getEmail());
		pst.setString(7, user.getPassword());
		//Execute query
		rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			   if(pst != null) {
				   pst.close();
			   }
			   if(connection != null) {
				   connection.close();
			   }
		}
		//Return Successful or not
		return (rows == 1);
	}
	
	// update user
	public boolean update(User user , String userEmail) throws SQLException {
		   
		   Connection connection = null;
		   PreparedStatement pst = null;
		   int rows = 0;
		   
		   try {
		   connection = getConnection();
		   
		   String updateQuery = "UPDATE freshstocks SET gender = ?, mobile_number = ?, date_of_birth = ? WHERE email = '" + userEmail + "';";
		   pst = connection.prepareStatement(updateQuery);
		   pst.setString(1, user.getGender());
		   pst.setString(2, user.getmobileNumber());
		   pst.setString(3, user.getdateOfBirth());
		   
		 //Execute query
			rows = pst.executeUpdate();
		   } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				   if(pst != null) {
					   pst.close();
				   }
				   if(connection != null) {
					   connection.close();
				   }
			}
			//Return Successful or not
			return (rows == 1);
}
	
	//delete user
	public boolean delete(String userEmail , int isDeleted) throws SQLException {
		   
		   Connection connection = null;
		   PreparedStatement pst = null;
		   int rows = 0;
		   
		   try {
		   connection = getConnection();
		   
		   String isDelete = Integer.toString(isDeleted);
		   
		   String deleteQuery = "UPDATE freshstocks SET is_deleted = ? WHERE email = '" + userEmail + "';";
		   pst = connection.prepareStatement(deleteQuery);
		   pst.setString(1, isDelete);
		   
		 //Execute query
			rows = pst.executeUpdate();
			
		   } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				   if(pst != null) {
					   pst.close();
				   }
				   if(connection != null) {
					   connection.close();
				   }
			}
			//Return Successful or not
			return (rows == 1);
     }
	
}