package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.freshstocks.model.Comment;

//import io.github.cdimascio.dotenv.Dotenv;

public class CommentDAO {
	
	 //connect to database
	 public static Connection getConnection() throws SQLException {
//			String DB_URL;
//			String DB_USER;
//			String DB_PASSWORD;
//
//			if (System.getenv("CI") != null) {
//				DB_URL = System.getenv("DB_URL");
//				DB_USER = System.getenv("DB_USER");
//				DB_PASSWORD = System.getenv("DB_PASSWORD");
//			} else {
//				Dotenv env = Dotenv.load();
//				DB_URL = env.get("DB_URL");
//				DB_USER = env.get("DB_USER");
//				DB_PASSWORD = env.get("DB_PASSWORD");
//			}
//
//	     return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		 return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	 }
	 
	 public static boolean createComment(Comment comment) throws SQLException {
		 
		 Connection connection = null;
		 PreparedStatement pst = null;
		 int rows = 0;
		 
		 try {
				//Get Connection
				connection = getConnection();
				
				// Prepare SQL Statement
				String insertQuery = "INSERT INTO Comment (courseID, userID, comment) VALUES (?,?,?);";
				pst = connection.prepareStatement(insertQuery);
				pst.setInt(1, comment.getCourseId());
				pst.setInt(2, comment.getUserId());
				pst.setString(3, comment.getComment().toLowerCase().trim());
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
