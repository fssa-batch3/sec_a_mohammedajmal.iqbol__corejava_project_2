package com.fssa.freshstocks.validation;

import java.net.URL;
import java.util.regex.Pattern;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class CourseValidator {

	// if three conditions valid then user valid
	public static boolean validateCourse(Course course) throws InvalidUserException {
		if(course != null && validateName(course.getName()) && validateURL(course.getCoverImage())
				&& validateLanguage(course.getLanguage()) 
				&& validateMarkedPrice(course.getMarkedPrice())
				&& validateSellingPrice(course.getSellingPrice())
				&& validatePriceDifference(course.getMarkedPrice(),course.getSellingPrice())
				&& validateTiming(course.getTiming())
				&& validateInsutructorName(course.getInstructorName())
				&& validateCompanyName(course.getCompanyName())
				&& validateCompanyCategory(course.getCompanyCategory())
				&& validateTopSkils(course.getTopSkills())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}
	
	// if three conditions valid then user valid
	public static boolean validateUpdatedCourse(Course course) throws InvalidUserException {
		if(course != null && validateURL(course.getCoverImage())
				&& validateLanguage(course.getLanguage()) 
				&& validateMarkedPrice(course.getMarkedPrice())
				&& validateSellingPrice(course.getSellingPrice())
				&& validatePriceDifference(course.getMarkedPrice(),course.getSellingPrice())
				&& validateTiming(course.getTiming())
				&& validateInsutructorName(course.getInstructorName())
				&& validateCompanyName(course.getCompanyName())
				&& validateCompanyCategory(course.getCompanyCategory())
				&& validateTopSkils(course.getTopSkills())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}
	
	public static boolean validateName(String name) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,30}$";
		match = Pattern.matches(regex, name);
		if(match) {
			System.out.println("course name is valid");
			return true;
		} else {
			System.out.println("course name is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course name is invalid");
		}
		return match;
	}
	
    public static boolean validateURL(String url) {
		boolean match = false;
		try {
		String regex = "^https?://\\S+$";
		match = Pattern.matches(regex, url);
		if(match) {
			System.out.println("course Image URL is valid");
			return true;
		} 
		} catch (Exception e) {
			System.out.println("course Image URL is invalid");
		}
		return match;
    }
	
	public static boolean validateLanguage(String name) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,30}$";
		match = Pattern.matches(regex, name);
		if(match) {
			System.out.println("course language is valid");
			return true;
		} else {
			System.out.println("course language is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course language is invalid");
		}
		return match;
	}
	
	
	public static boolean validateMarkedPrice(String markedprice) {
		boolean match = false;
		try {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
		match = Pattern.matches(pricePattern, markedprice);
		if(match) {
			System.out.println("course marked price is valid");
			return true;
		} else {
			System.out.println("course marked price is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course marked price is invalid");
		}
		return match;
	}
	
	public static boolean validateSellingPrice(String sellingprice) {
		boolean match = false;
		try {
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
		match = Pattern.matches(pricePattern, sellingprice);
		if(match) {
			System.out.println("course selling price is valid");
			return true;
		} else {
			System.out.println("course selling price is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course selling price is invalid");
		}
		return match;
	}
	
	public static boolean validatePriceDifference(String markedprice ,String sellingprice) {
		boolean match = false;
		try {
		match = (Integer.parseInt(markedprice) > Integer.parseInt(sellingprice));
		if(match) {
			System.out.println("course price is valid");
			return true;
		} else {
			System.out.println("course price is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course price is invalid");
		}
		return match;
	}
	
	public static boolean validateTiming(String timing) {
		boolean match = false;
		try {
			String courseTimingPattern = "^(\\d+)hrs$";
			match = Pattern.matches(courseTimingPattern, timing);
		if(match) {
			System.out.println("course timing is valid");
			return true;
		} else {
			System.out.println("course price is invalid  Input Hint : 10hrs");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course price is invalid  Input Hint : 10hrs");
		}
		return match;
	}
	
	public static boolean validateInsutructorName(String instructorname) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,50}$";
		match = Pattern.matches(regex, instructorname);
		if(match) {
			System.out.println("course instructor name is valid");
			return true;
		} else {
			System.out.println("course instructor name is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course instructor name is invalid");
		}
		return match;
	}
	
	public static boolean validateCompanyName(String companyname) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,100}$";
		match = Pattern.matches(regex, companyname);
		if(match) {
			System.out.println("course company name is valid");
			return true;
		} else {
			System.out.println("course company name is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course company name is invalid");
		}
		return match;
	}
	
	public static boolean validateCompanyCategory(String companycategory) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,100}$";
		match = Pattern.matches(regex, companycategory);
		if(match) {
			System.out.println("course company category is valid");
			return true;
		} else {
			System.out.println("course company category is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course company category is invalid");
		}
		return match;
	}
	
	public static boolean validateTopSkils(String topskills) {
		boolean match = false;
		try {
		String regex = "^[A-Za-z\\s]{3,150}$";
		match = Pattern.matches(regex, topskills);
		if(match) {
			System.out.println("course top skills is valid");
			return true;
		} else {
			System.out.println("course top skills is invalid");
			return false;
		}
		} catch (Exception e) {
			System.out.println("course top skills is invalid");
		}
		return match;
	}
	
}
