package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;

import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class CommentValidator {

	
	// if three conditions valid then user valid
	public static boolean validateComment(Comment comment) throws InvalidUserException {
		String userId = Integer.toString(comment.getUserId());
		String courseId = Integer.toString(comment.getCourseId());
		if(comment != null && validateUserId(userId) && validateCourseId(courseId) 
				&& validateComment(comment.getComment())) {
			return true;
		} else {
			throw new InvalidUserException("Comment details not valid");
		}
	}

	public static boolean validateUserId(String userId) {
		boolean match = false;
		try {
			String regex = "^[1-9]\\d*$";
			match = Pattern.matches(regex, userId);
			if (match) {
				System.out.println("The user ID is valid.");
			} else {
				System.out.println("user ID is not valid");
			}
		} catch (Exception e) {
			System.out.println("user ID is not valid");
		}
		return match;
	}
	
	public static boolean validateCourseId(String courseId) {
		boolean match = false;
		try {
			String regex = "^[1-9]\\d*$";
			match = Pattern.matches(regex, courseId);
			if (match) {
				System.out.println("The course ID is valid.");
			} else {
				System.out.println("course ID is not valid");
			}
		} catch (Exception e) {
			System.out.println("course ID is not valid");
		}
		return match;
	}

	public static boolean validateComment(String commentbody) {
		boolean match = false;
		try {
			String regex = "^.*\\S.*$";
			match = Pattern.matches(regex, commentbody);
			if (match) {
				System.out.println("The course comment is valid.");
			} else {
				System.out.println("course comment is not valid");
			}
		} catch (Exception e) {
			System.out.println("course comment is not valid");
		}
		return match;
	}
}
