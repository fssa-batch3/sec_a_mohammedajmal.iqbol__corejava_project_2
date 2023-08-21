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

	    if (isValid) {
	        return true;
	    } else {
	        throw new InvalidCommentException("Comment details not valid");
	    }
	}
	
	public static boolean validateUserId(String userId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, userId) && userId.isEmpty()) {
	        throw new InvalidCommentException("user ID is not valid");
	    }
	    return true;
	}

	public static boolean validateCourseId(String courseId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, courseId) && courseId.isEmpty()) {
	        throw new InvalidCommentException("course ID is not valid");
	    }
	    return true;
	}

	public static boolean validateComment(String commentbody) throws InvalidCommentException {
		if (commentbody.trim().isEmpty()) {
	        throw new InvalidCommentException("Course comment is not valid");
	    }
		return true;
	}
}
