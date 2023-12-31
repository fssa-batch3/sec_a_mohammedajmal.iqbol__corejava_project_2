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
	public static void validateComment(Comment comment) throws InvalidCommentException {
		String courseId = Integer.toString(comment.getCourseId());
		String userId = Integer.toString(comment.getUserId());

		try {
			validateCourseId(userId);
			validateCourseId(courseId);
			validateComment(comment.getComment());
		} catch (InvalidCommentException e) {
			throw new InvalidCommentException(e.getMessage());
		}
	}

	/**
	 * Validates a user ID to be a positive integer.
	 *
	 * @param userId The user ID to be validated.
	 * @return true if the user ID is valid, false otherwise.
	 * @throws InvalidCommentException If the user ID is found to be invalid.
	 */
	public static void validateUserId(String userId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
		if (!Pattern.matches(regex, userId)) {
			throw new InvalidCommentException("Invalid user ID. User IDs must be positive integers.");
		}
	}

	/**
	 * Validates a course ID to be a positive integer.
	 *
	 * @param courseId The course ID to be validated.
	 * @return true if the course ID is valid, false otherwise.
	 * @throws InvalidCommentException If the course ID is found to be invalid.
	 */
	public static void validateCourseId(String courseId) throws InvalidCommentException {
		String regex = "^[1-9]\\d*$";
		if (!Pattern.matches(regex, courseId)) {
			throw new InvalidCommentException("Invalid course ID. Course IDs must be positive integers.");
		}
	}

	/**
	 * Validates a comment body to be non-empty.
	 *
	 * @param commentBody The comment body to be validated.
	 * @return true if the comment body is valid, false otherwise.
	 * @throws InvalidCommentException If the comment body is found to be empty.
	 */
	public static void validateComment(String commentbody) throws InvalidCommentException {
		if (commentbody.trim().isEmpty()) {
			throw new InvalidCommentException("Invalid comment. Please provide a non-empty comment for the course.");
		}
	}
}
