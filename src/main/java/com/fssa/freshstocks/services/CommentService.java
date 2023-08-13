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

	public boolean registerComment(Comment comment) throws ServiceException {
		try {
			CommentDAO CommentDAO = new CommentDAO();
	        if (!CommentValidator.validateComment(comment)) {
	            return false;
	        }
	        boolean success = CommentDAO.createComment(comment);
	        if (success) {
	            System.out.println("Comment for the Course ID: " + comment.getCourseId() + " Successfully Added!");
	        }
	        return success;
		} catch (DAOException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}

	public List<Comment> ListComment(Comment comment) throws ServiceException {
	    String courseID = Integer.toString(comment.getCourseId());
	    CommentDAO CommentDAO = new CommentDAO();
	    try {
	        CommentValidator.validateCourseId(courseID);
	        return CommentDAO.getAllComments(comment.getCourseId());
	    } catch (DAOException | InvalidCommentException e) {
	        throw new ServiceException(e);
	    }
	}

	// updated comment
	public boolean updateComment(Comment comment, int commentId) throws ServiceException {
	    try {
	        if (!CommentValidator.validateComment(comment.getComment())) {
	            return false;
	        }
	        CommentDAO commentDAO = new CommentDAO();
	        boolean success = commentDAO.updateComment(comment, commentId);
	        if (success) {
	            System.out.println("CommentID of Comment: " + commentId + " Successfully Updated!");
	        }
	        return success;

	    } catch (DAOException | InvalidCommentException e) {
	        throw new ServiceException(e);
	    }
	}

	// delete comment
	public boolean deleteComment(int commentId, int isDeleted) throws ServiceException {
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