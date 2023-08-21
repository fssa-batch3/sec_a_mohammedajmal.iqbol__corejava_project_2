package com.fssa.freshstocks.validation;

import java.util.regex.Pattern;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

public class CourseValidator {

	// if three conditions valid then user valid
	public static boolean validateCourse(Course course) throws InvalidCourseException {
	    boolean isValid = course != null &&
	        validateName(course.getName()) &&
	        validateURL(course.getCoverImage()) &&
	        validateLanguage(course.getLanguage()) &&
	        validateMarkedPrice(course.getMarkedPrice()) &&
	        validateSellingPrice(course.getSellingPrice()) &&
	        validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice()) &&
	        validateTiming(course.getTiming()) &&
	        validateInsutructorName(course.getInstructorName()) &&
	        validateCompanyName(course.getCompanyName()) &&
	        validateCompanyCategory(course.getCompanyCategory()) &&
	        validateTopSkils(course.getTopSkills());

	    if (!isValid) {
	    	throw new InvalidCourseException("Invalid course details. Please ensure that all course information is valid.");
	    }

	    return isValid;
	}


	// if three conditions valid then user valid
	public static boolean validateUpdatedCourse(Course course) throws InvalidCourseException {
	    boolean isValid = course != null &&
	        validateURL(course.getCoverImage()) &&
	        validateLanguage(course.getLanguage()) &&
	        validateMarkedPrice(course.getMarkedPrice()) &&
	        validateSellingPrice(course.getSellingPrice()) &&
	        validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice()) &&
	        validateTiming(course.getTiming()) &&
	        validateInsutructorName(course.getInstructorName()) &&
	        validateCompanyName(course.getCompanyName()) &&
	        validateCompanyCategory(course.getCompanyCategory()) &&
	        validateTopSkils(course.getTopSkills());

	    if (!isValid) {
	    	throw new InvalidCourseException("Invalid Updating course details. Please ensure that all course information is valid.");
	    }

	    return isValid;
	}

	public static boolean validateName(String name) throws InvalidCourseException {
		String regex = "^(?=.*[A-Za-z])[A-Za-z0-9\\s]{3,30}$";
	    if (!Pattern.matches(regex, name)) {
	    	 throw new InvalidCourseException("Invalid course name. Course names must be 3 to 30 characters long and may include letters, numbers, and spaces.");
	    }
	    return true;
	}

	public static boolean validateURL(String url) throws InvalidCourseException {
		String regex = "^https?://\\S+$";
	    if (!Pattern.matches(regex, url)) {
	    	throw new InvalidCourseException("Invalid course image URL. Please provide a valid HTTP or HTTPS URL.");
	    }
	    return true;
	}

	public static boolean validateLanguage(String name) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,30}$";
	    if (!Pattern.matches(regex, name)) {
	    	throw new InvalidCourseException("Invalid course language. Course languages must be 3 to 30 characters long and may include letters and spaces.");
	    }
	    return true;
	}

	public static boolean validateMarkedPrice(String markedprice) throws InvalidCourseException {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
	    if (!Pattern.matches(pricePattern, markedprice)) {
	    	throw new InvalidCourseException("Invalid course marked price. Please provide a valid price (e.g., 100 or 99.99).");
	    }
	    return true;
	}

	public static boolean validateSellingPrice(String sellingprice) throws InvalidCourseException {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
	    if (!Pattern.matches(pricePattern, sellingprice)) {
	    	throw new InvalidCourseException("Invalid course selling price. Please provide a valid price (e.g., 100 or 99.99).");
	    }
	    return true;
	}

	public static boolean validatePriceDifference(String markedPrice, String sellingPrice) {
	    try {
	        int marked = Integer.parseInt(markedPrice);
	        int selling = Integer.parseInt(sellingPrice);
	        return marked > selling;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public static boolean validateTiming(String timing) throws InvalidCourseException {
		String courseTimingPattern = "^(\\d+)hrs$";
	    if (!Pattern.matches(courseTimingPattern, timing)) {
	    	 throw new InvalidCourseException("Invalid course timing. Please provide a valid timing format (e.g., 10hrs).");
	    }
	    return true;
	}

	public static boolean validateInsutructorName(String instructorname) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,50}$";
	    if (!Pattern.matches(regex, instructorname)) {
	    	throw new InvalidCourseException("Invalid course instructor name. Instructor names must be 3 to 50 characters long and may include letters and spaces.");
	    }
	    return true;
	}

	public static boolean validateCompanyName(String companyname) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,100}$";
	    if (!Pattern.matches(regex, companyname)) {
	    	throw new InvalidCourseException("Invalid course company name. Company names must be 3 to 100 characters long and may include letters and spaces.");
	    }
	    return true;
	}

	public static boolean validateCompanyCategory(String companycategory) throws InvalidCourseException {	
		String regex = "^[A-Za-z\\s]{3,100}$";
	    if (!Pattern.matches(regex, companycategory)) {
	    	 throw new InvalidCourseException("Invalid course company category. Company categories must be 3 to 100 characters long and may include letters and spaces.");
	    }
	    return true;
	}

	public static boolean validateTopSkils(String topskills) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,150}$";
	    if (!Pattern.matches(regex, topskills)) {
	    	 throw new InvalidCourseException("Invalid course top skills. Top skills must be 3 to 150 characters long and may include letters and spaces.");
	    }
	    return true;
	}

}