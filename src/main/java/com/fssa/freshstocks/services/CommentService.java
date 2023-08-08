package com.fssa.freshstocks.services;

import java.sql.SQLException;

import com.fssa.freshstocks.dao.CommentDAO;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CommentValidator;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class CommentService {

	public static boolean registerComment(Comment comment) throws ServiceException {
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
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
}
