package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.fssa.freshstocks.constants.CommentModuleConstants;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.utils.ConnectionUtil;
import com.fssa.freshstocks.utils.exception.DatabaseException;

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
	 * @return {@code true} if the comment creation was successful, {@code false}
	 *         otherwise.
	 * @throws DAOException If there's an error during the database operation.
	 */
	public boolean createComment(Comment comment) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("INSERT INTO Comment (course_id, user_id, comment) VALUES (?,?,?);")) {

			pst.setInt(1, comment.getCourseId());
			pst.setInt(2, comment.getUserId());
			pst.setString(3, comment.getComment().toLowerCase().trim());

			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
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
						"SELECT co.comment_id, co.user_id, f.username AS username, f.avatar_url AS userProfile, c.name AS courseName, co.comment AS comment, co.created_at AS createdTime "
								+ "FROM Comment co " + "JOIN freshstocks f ON co.user_id = f.user_id "
								+ "JOIN course c ON co.course_id = c.course_id "
								+ "WHERE co.course_id = ? AND co.is_deleted = 0");) {
			pst.setInt(1, courseID);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int commentId = resultSet.getInt("comment_id");
				int userId = resultSet.getInt("user_id"); // Retrieve user ID
				String username = resultSet.getString("username");
				String userProfile = resultSet.getString("userProfile");
				String courseName = resultSet.getString("courseName");
				String commentBody = resultSet.getString("comment");
				String createdTime = formatTimeDifference(resultSet.getTimestamp("createdTime"));

				Comment comment1 = new Comment(commentId, userId, username, userProfile, courseName, commentBody,
						createdTime);
				comments.add(comment1);
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CommentModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return comments;
	}

	/**
	 * Retrieves a comment by its unique identifier.
	 *
	 * @param commentID The unique identifier of the comment.
	 * @return The Comment object associated with the provided ID, or null if not found.
	 * @throws DAOException If an error occurs during the retrieval process.
	 */
	public Comment getCommentByID(int commentID) throws DAOException {
		Comment comment1 = null;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("SELECT * FROM Comment WHERE comment_id = ? AND is_deleted = 0");) {
			pst.setInt(1, commentID);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				int commentId = resultSet.getInt("comment_id");
				String commentBody = resultSet.getString("comment");

				comment1 = new Comment(commentId, commentBody);
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CommentModuleConstants.READ_ERROR_MESSAGE + e);
		}

		return comment1;
	}

	/**
	 * Retrieves a formatted time string message from created_at.
	 *
	 * @param timestamp The time of the course is created for which to retrieve
	 *                  time.
	 * @return returns a formatted time string message from created_at.
	 */
	private String formatTimeDifference(Timestamp timestamp) {
		// Calculate the time difference
		long currentTimeMillis = System.currentTimeMillis();
		long createdTimeMillis = timestamp.getTime();
		long timeDifferenceMillis = currentTimeMillis - createdTimeMillis;

		// Convert time difference to IST (UTC+05:30)
		long istTimeDifferenceMillis = timeDifferenceMillis - (5 * 60 * 60 * 1000) - (30 * 60 * 1000);

		long minutes = istTimeDifferenceMillis / (60 * 1000);
		long hours = minutes / 60;
		long days = hours / 24;

		if (days > 0) {
			return days + (days == 1 ? " day ago" : " days ago");
		} else if (hours > 0) {
			return hours + (hours == 1 ? " hour ago" : " hours ago");
		} else if (minutes > 0) {
			return minutes + (minutes == 1 ? " minute ago" : " minutes ago");
		} else {
			return "Just now";
		}
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
				PreparedStatement pst = connection
						.prepareStatement("UPDATE Comment SET comment=? WHERE comment_id = ?")) {

			pst.setString(1, comment.getComment());
			pst.setInt(2, commentId);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CommentModuleConstants.UPDATE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}

	/**
	 * Marks a comment as deleted or undeleted in the database.
	 *
	 * @param commentId The ID of the comment to be marked.
	 * @param isDeleted The value indicating whether the comment should be marked as
	 *                  deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean deleteComment(int commentId, int isDeleted) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("UPDATE Comment SET is_deleted = ? WHERE comment_id = ?")) {

			String isDelete = Integer.toString(isDeleted);

			pst.setString(1, isDelete);
			pst.setInt(2, commentId);

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CommentModuleConstants.DELETE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}

}