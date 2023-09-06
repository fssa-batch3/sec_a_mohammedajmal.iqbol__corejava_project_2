package com.fssa.freshstocks.services;

import java.util.List;

import com.fssa.freshstocks.constants.CommentModuleConstants;
import com.fssa.freshstocks.dao.CommentDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

public class CommentService {

	/**
	 * Registers a comment by creating it in the database.
	 *
	 * @param comment The Comment object to be registered.
	 * @return true if the comment was successfully registered, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process.
	 */
	public boolean registerComment(Comment comment) throws ServiceException {
		try {
			CommentDAO commentDAO = new CommentDAO();
			CommentValidator.validateComment(comment);
			return commentDAO.createComment(comment);
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of comments for a given course ID.
	 *
	 * @param comment The Comment object containing the course ID.
	 * @return A list of Comment objects associated with the given course ID.
	 * @throws ServiceException If an error occurs while retrieving the comments.
	 */
	public List<Comment> listComment(int courseId) throws ServiceException {
		String courseID = Integer.toString(courseId);
		CommentDAO commentDAO = new CommentDAO();
		try {
			CommentValidator.validateCourseId(courseID);
			return commentDAO.getAllComments(courseId);
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	public Comment getCommentByCommentID(int commentId) throws ServiceException {
		CommentDAO commentDAO = new CommentDAO();
		try {
			return commentDAO.getCommentByID(commentId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Updates a comment with the given comment ID.
	 *
	 * @param comment   The updated Comment object.
	 * @param commentId The ID of the comment to be updated.
	 * @return true if the comment was successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs while updating the comment.
	 */
	public boolean updateComment(Comment comment, int commentId) throws ServiceException {
		try {
			CommentValidator.validateComment(comment.getComment());
			CommentDAO commentDAO = new CommentDAO();
			return commentDAO.updateComment(comment, commentId);
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Deletes a comment with the given comment ID.
	 *
	 * @param commentId The ID of the comment to be deleted.
	 * @param isDeleted An indicator of whether the comment should be marked as
	 *                  deleted. (0 for not deleted, 1 for deleted)
	 * @return true if the comment was successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs while deleting the comment.
	 */
	public boolean deleteComment(int commentId, int isDeleted) throws ServiceException {
		CommentDAO commentDAO = new CommentDAO();
		try {
			return commentDAO.deleteComment(commentId, isDeleted);
		} catch (DAOException e) {
			throw new ServiceException(CommentModuleConstants.DELETE_ERROR_MESSAGE + e);
		}
	}
}
