package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.model.Course;

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
	 
	 public static boolean createComment(Comment comment) throws SQLException, DAOException {
		 
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
					throw new DAOException("Error: " + e);
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
	 
	 
	 
	   //get courses by course name
	 public static List<Comment> getAllComments(int courseID) throws DAOException {
		    List<Comment> comments = new ArrayList<>();

		    try (Connection connection = getConnection();
		         PreparedStatement pst = connection.prepareStatement("SELECT * FROM comment WHERE courseID =?");
		         ) {
		    	
		    	pst.setInt(1, courseID);
		    	ResultSet resultSet = pst.executeQuery();

		        while (resultSet.next()) {
		            int commentId = resultSet.getInt("commentID");
		            int courseId = resultSet.getInt("courseID");
		            int userId = resultSet.getInt("userID");
		            String commentBody = resultSet.getString("comment");
		            Comment comment1 = new Comment(commentId, courseId, userId, commentBody);
		            comments.add(comment1);
		        }
		    } catch (SQLException e) {
		        throw new DAOException("Error: " + e);
		    }

		    return comments;
		}
	   
		// update comment
		public boolean updateComment(Comment comment, int commentId) throws SQLException, DAOException {
			   
			   Connection connection = null;
			   PreparedStatement pst = null;
			   int rows = 0;
			   
			   try {
			   connection = getConnection();
			   
			   String updateQuery = "UPDATE comment SET comment=? WHERE commentID = " + commentId + ";";
			   pst = connection.prepareStatement(updateQuery);
			   pst.setString(1, comment.getComment());
			   
			 //Execute query
				rows = pst.executeUpdate();
			   } catch (SQLException e) {
				   throw new DAOException("Error: " + e);
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
		
		//delete comment
		public boolean deleteComment(int commentId , int isDeleted) throws SQLException, DAOException {
			   
			   Connection connection = null;
			   PreparedStatement pst = null;
			   int rows = 0;
			   
			   try {
			   connection = getConnection();
			   
			   String isDelete = Integer.toString(isDeleted);
			   
			   String deleteQuery = "UPDATE comment SET is_deleted = ? WHERE commentID = " + commentId + ";";
			   pst = connection.prepareStatement(deleteQuery);
			   pst.setString(1, isDelete);
			   
			 //Execute query
				rows = pst.executeUpdate();
				
			   } catch (SQLException e) {
				   throw new DAOException("Error: " + e);
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
