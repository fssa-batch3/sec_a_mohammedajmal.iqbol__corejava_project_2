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
import com.fssa.freshstocks.utils.*;

public class CommentDAO {

	public boolean createComment(Comment comment) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Prepare SQL Statement
			String insertQuery = "INSERT INTO Comment (courseID, userID, comment) VALUES (?,?,?);";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, comment.getCourseId());
			pst.setInt(2, comment.getUserId());
			pst.setString(3, comment.getComment().toLowerCase().trim());
			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while creating comment." + e);
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}

		// Return Successful or not
		return (rows == 1);
	}

	// get courses by course name
	public List<Comment> getAllComments(int courseID) throws DAOException {
		List<Comment> comments = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM Comment WHERE courseID =?");) {

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
	public boolean updateComment(Comment comment, int commentId) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String updateQuery = "UPDATE Comment SET comment=? WHERE commentID = ?;";
			pst = connection.prepareStatement(updateQuery);
			pst.setString(1, comment.getComment());
		    pst.setInt(2, commentId);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while updating comment." + e);
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}

	// delete comment
	public boolean deleteComment(int commentId, int isDeleted) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String isDelete = Integer.toString(isDeleted);

			String deleteQuery = "UPDATE Comment SET is_deleted = ? WHERE commentID = ?;";
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, isDelete);
			pst.setInt(2, commentId);

			// Execute query
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error while deleting comment." + e);
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}

}
