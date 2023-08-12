package com.fssa.freshstocks.services;

import java.sql.SQLException;
import java.util.List;

import com.fssa.freshstocks.dao.CommentDAO;
import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class CommentService {

	public static boolean registerComment(Comment comment) throws ServiceException {
		try {
			if (CommentValidator.validateComment(comment)) {
				boolean success = CommentDAO.createComment(comment);
				if (success) {
					System.out.println("Comment for the Course ID: " + comment.getCourseId() + " Successfully Added!");
				}
				return success;
			} else {
				return false;
			}
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	public static List<Comment> ListComment(Comment comment) throws ServiceException {

		try {
			String courseID = Integer.toString(comment.getCourseId());
			CommentValidator.validateCourseId(courseID);
			return CommentDAO.getAllComments(comment.getCourseId());
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	// updated comment
	public static boolean updateComment(Comment comment, int commentId) throws ServiceException {
		CommentDAO commentDAO = new CommentDAO();
		try {
			if (CommentValidator.validateComment(comment.getComment())) {
				boolean success = commentDAO.updateComment(comment, commentId);
				if (success) {
					System.out.println("CommentID of Comment: " + commentId + " Successfully Updated!");
				}
				return success;
			} else {
				return false;
			}
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	// delete comment
	public static boolean deleteComment(int commentId, int isDeleted) throws ServiceException {
		CommentDAO commentDAO = new CommentDAO();
		try {
			boolean success = commentDAO.deleteComment(commentId, isDeleted);
			if (success) {
				System.out.println("Comment of CommentID: " + commentId + " Successfully Deleted!");
			}
			return success;
		} catch (DAOException e) {
			throw new ServiceException("Error while deleting comment. " + e);
		}
	}
}
