package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

public class CommentValidator {

	// if three conditions valid then user valid
	public static boolean validateComment(Comment comment) throws InvalidCommentException {
		String userId = Integer.toString(comment.getUserId());
	    String courseId = Integer.toString(comment.getCourseId());

	    boolean isValid = validateUserId(userId) &&
	                      validateCourseId(courseId) &&
	                      validateComment(comment.getComment()) &&
	                      !comment.getComment().trim().isEmpty();

	    if (!isValid) {
	    	throw new InvalidCommentException("Invalid comment details. Please ensure that your comment adheres to the required format.");
	    }
	    return true;
	}
	
	public static boolean validateUserId(String userId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, userId)) {
	    	throw new InvalidCommentException("Invalid user ID. User IDs must be positive integers.");
	    }
	    return true;
	}

	public static boolean validateCourseId(String courseId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, courseId)) {
	       throw new InvalidCommentException("Invalid course ID. Course IDs must be positive integers.");
	    }
	    return true;
	}

	public static boolean validateComment(String commentbody) throws InvalidCommentException {
		if (commentbody.trim().isEmpty()) {
			throw new InvalidCommentException("Invalid comment. Please provide a non-empty comment for the course.");
	    }
		return true;
	}
}
