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
	        throw new InvalidCourseException("Course details not valid");
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
	        throw new InvalidCourseException("Course details not valid");
	    }

	    return isValid;
	}

	public static boolean validateName(String name) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,30}$";
	    if (!Pattern.matches(regex, name)) {
	        throw new InvalidCourseException("Course Name is Invalid");
	    }
	    return true;
	}

	public static boolean validateURL(String url) throws InvalidCourseException {
		String regex = "^https?://\\S+$";
	    if (!Pattern.matches(regex, url)) {
	        throw new InvalidCourseException("Course Image is Invalid");
	    }
	    return true;
	}

	public static boolean validateLanguage(String name) throws InvalidCourseException {
		String regex = "^[A-Za-z\\\\s]{3,30}$";
	    if (!Pattern.matches(regex, name)) {
	        throw new InvalidCourseException("Course language is Invalid");
	    }
	    return true;
	}

	public static boolean validateMarkedPrice(String markedprice) throws InvalidCourseException {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
	    if (!Pattern.matches(pricePattern, markedprice)) {
	        throw new InvalidCourseException("Course marked price is Invalid");
	    }
	    return true;
	}

	public static boolean validateSellingPrice(String sellingprice) throws InvalidCourseException {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
	    if (!Pattern.matches(pricePattern, sellingprice)) {
	        throw new InvalidCourseException("Course selling price is Invalid");
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
	        throw new InvalidCourseException("Course timing is Invalid");
	    }
	    return true;
	}

	public static boolean validateInsutructorName(String instructorname) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,50}$";
	    if (!Pattern.matches(regex, instructorname)) {
	        throw new InvalidCourseException("Course instructor name is Invalid");
	    }
	    return true;
	}

	public static boolean validateCompanyName(String companyname) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,100}$";
	    if (!Pattern.matches(regex, companyname)) {
	        throw new InvalidCourseException("Course company name is Invalid");
	    }
	    return true;
	}

	public static boolean validateCompanyCategory(String companycategory) throws InvalidCourseException {	
		String regex = "^[A-Za-z\\s]{3,100}$";
	    if (!Pattern.matches(regex, companycategory)) {
	        throw new InvalidCourseException("Course company category is Invalid");
	    }
	    return true;
	}

	public static boolean validateTopSkils(String topskills) throws InvalidCourseException {
		String regex = "^[A-Za-z\\s]{3,150}$";
	    if (!Pattern.matches(regex, topskills)) {
	        throw new InvalidCourseException("Course topskills is Invalid");
	    }
	    return true;
	}

}
