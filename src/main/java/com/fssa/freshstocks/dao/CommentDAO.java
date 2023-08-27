package com.fssa.freshstocks.dao;

import java.sql.Connection;
import com.fssa.freshstocks.constants.CommentModuleConstants;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.utils.*;

public class CommentDAO {

	/**
	 * Creates a new comment in the database.
	 *
	 * This method adds a new comment to the database by inserting the provided
	 * Comment object's information into the 'Comment' table. The provided Comment
	 * object should contain the course ID, user ID, and comment content. The
	 * comment content is normalized by converting it to lower-case and trimming
	 * leading/trailing spaces.
	 *
	 * @param comment The Comment object representing the comment to be created.
	 * @return {@code true} if the comment creation was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error during the database operation.
	 */
	public boolean createComment(Comment comment) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "INSERT INTO Comment (course_id, user_id, comment) VALUES (?,?,?);")) {

	        pst.setInt(1, comment.getCourseId());
	        pst.setInt(2, comment.getUserId());
	        pst.setString(3, comment.getComment().toLowerCase().trim());

	        rows = pst.executeUpdate();
	    } catch (SQLException e) {
	        throw new DAOException(CommentModuleConstants.CREATE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}
	
	
	/**
	 * Retrieves a list of comments for a specific course.
	 *
	 * @param courseID The ID of the course for which to retrieve comments.
	 * @return A list of Comment objects representing the comments for the course.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public List<Comment> getAllComments(int courseID) throws DAOException {
		List<Comment> comments = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(
						"SELECT  co.comment_id, f.username AS username, c.name AS coursename, co.comment AS comment FROM Comment co JOIN freshstocks f ON co.user_id = f.user_id JOIN course c ON co.course_id = c.course_id WHERE co.course_id = ?");) {

			pst.setInt(1, courseID);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int commentId = resultSet.getInt("comment_id");
				String username = resultSet.getString("username");
				String courseName = resultSet.getString("coursename");
				String commentBody = resultSet.getString("comment");
				Comment comment1 = new Comment(commentId,username, courseName, commentBody);
				comments.add(comment1);
			}
		} catch (SQLException e) {
			throw new DAOException(CommentModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return comments;
	}

	
	/**
	 * Updates an existing comment in the database.
	 *
	 * @param comment   The Comment object containing the updated comment text.
	 * @param commentId The ID of the comment to be updated.
	 * @return {@code true} if the update was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean updateComment(Comment comment, int commentId) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "UPDATE Comment SET comment=? WHERE comment_id = ?")) {

	        pst.setString(1, comment.getComment());
	        pst.setInt(2, commentId);

	        // Execute query
	        rows = pst.executeUpdate();
	    } catch (SQLException e) {
	        throw new DAOException(CommentModuleConstants.UPDATE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}


	
	/**
	 * Marks a comment as deleted or undeleted in the database.
	 *
	 * @param commentId The ID of the comment to be marked.
	 * @param isDeleted The value indicating whether the comment should be marked as deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean deleteComment(int commentId, int isDeleted) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "UPDATE Comment SET is_deleted = ? WHERE comment_id = ?")) {

	        String isDelete = Integer.toString(isDeleted);

	        pst.setString(1, isDelete);
	        pst.setInt(2, commentId);

	        // Execute query
	        rows = pst.executeUpdate();
	    } catch (SQLException e) {
	        throw new DAOException(CommentModuleConstants.DELETE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}

}