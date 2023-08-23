package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

public class CommentValidator {

	/**
	 * Validates a Comment object for its userId, courseId, and comment.
	 *
	 * @param comment The Comment object to be validated.
	 * @return true if the comment is valid, false otherwise.
	 * @throws InvalidCommentException If the comment is found to be invalid.
	 */
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
	
	/**
	 * Validates a user ID to be a positive integer.
	 *
	 * @param userId The user ID to be validated.
	 * @return true if the user ID is valid, false otherwise.
	 * @throws InvalidCommentException If the user ID is found to be invalid.
	 */
	public static boolean validateUserId(String userId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, userId)) {
	    	throw new InvalidCommentException("Invalid user ID. User IDs must be positive integers.");
	    }
	    return true;
	}

	/**
	 * Validates a course ID to be a positive integer.
	 *
	 * @param courseId The course ID to be validated.
	 * @return true if the course ID is valid, false otherwise.
	 * @throws InvalidCommentException If the course ID is found to be invalid.
	 */
	public static boolean validateCourseId(String courseId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
	    if (!Pattern.matches(regex, courseId)) {
	       throw new InvalidCommentException("Invalid course ID. Course IDs must be positive integers.");
	    }
	    return true;
	}

	/**
	 * Validates a comment body to be non-empty.
	 *
	 * @param commentBody The comment body to be validated.
	 * @return true if the comment body is valid, false otherwise.
	 * @throws InvalidCommentException If the comment body is found to be empty.
	 */
	public static boolean validateComment(String commentbody) throws InvalidCommentException {
		if (commentbody.trim().isEmpty()) {
			throw new InvalidCommentException("Invalid comment. Please provide a non-empty comment for the course.");
	    }
		return true;
	}
}
