package com.fssa.freshstocks.services;

import java.sql.SQLException;

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

	public static boolean registerComment(Comment comment) throws ServiceException, DAOException {
		try {
		if(CommentValidator.validateComment(comment)) { 
			if(CommentDAO.createComment(comment)) {
				System.out.println("Comment for the Course ID: " + comment.getCourseId() + " Successfully Added!");
				return true;
			} else {
				return false;
			}		} else {
			return false;
		}
		} catch ( SQLException | InvalidCommentException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//updated course
	public static boolean updateComment(Comment comment, int commentId) throws ServiceException, DAOException, InvalidCommentException {
		CommentDAO commentDAO = new CommentDAO();
		try {
		if(CommentValidator.validateComment(comment.getComment())) { 
			if(commentDAO.updateComment(comment,commentId)) {
				System.out.println("CommentID of Comment: " + commentId + " Successfully Updated!");
				return true;
			} else {
				return false;
			}		} else {
			return false;
		}
		} catch ( SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	
	//delete comment
	public static boolean deleteComment(int commentId , int isDeleted) throws ServiceException, DAOException {
		CommentDAO commentDAO = new CommentDAO();
		try {
			if(commentDAO.deleteComment(commentId, isDeleted)) {
				System.out.println("Comment of CommentID: " + commentId + " Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
}
