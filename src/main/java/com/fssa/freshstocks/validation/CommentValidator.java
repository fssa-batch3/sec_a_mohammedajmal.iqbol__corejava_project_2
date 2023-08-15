package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.validation.exception.InvalidCommentException;

public class CommentValidator {

	// if three conditions valid then user valid
	public static boolean validateComment(Comment comment) throws InvalidCommentException {
		String userId = Integer.toString(comment.getUserId());
		String courseId = Integer.toString(comment.getCourseId());
	    if (validateUserId(userId) && validateCourseId(courseId)
	            && validateComment(comment.getComment()) && !comment.getComment().trim().isEmpty()) {
	        return true;
	    } else {
	        throw new InvalidCommentException("Comment details not valid");
	    }
	}

	public static boolean validateUserId(String userId) throws InvalidCommentException {
		boolean match = false;
		String regex = "^[1-9]\\d*$";
		match = Pattern.matches(regex, userId);
		if (match && !userId.isEmpty()) {
			System.out.println("The user ID is valid.");
			match = true;
		} else {
			throw new InvalidCommentException("user ID is not valid");
		}
		return match;
	}

	public static boolean validateCourseId(String courseId) throws InvalidCommentException {
		boolean match = false;
		String regex = "^[1-9]\\d*$";
		match = Pattern.matches(regex, courseId);
		if (match && !courseId.isEmpty()) {
			System.out.println("The course ID is valid.");
			match = true;
		} else {
			throw new InvalidCommentException("course ID is not valid");
		}
		return match;
	}

	public static boolean validateComment(String commentbody) throws InvalidCommentException {
		if (!commentbody.trim().isEmpty() && !commentbody.trim().isEmpty()) {
	        System.out.println("The course comment is valid.");
	        return true;
	    } else {
	        throw new InvalidCommentException("Course comment is not valid");
	    }
	}
}
