package com.fssa.freshstocks.validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

public class CourseValidator {

	/**
	 * Validates a Course object for various attributes including name, cover image
	 * URL, language, prices, timing, instructor name, company details, and top
	 * skills. (Create Course Validation)
	 *
	 * @param course The Course object to be validated.
	 * @return true if the course is valid, false otherwise.
	 * @throws InvalidCourseException If the course is found to be invalid.
	 */
	public static void validateCourse(Course course) throws InvalidCourseException {
		try {
			if(!validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice())) {
				throw new InvalidCourseException(
						"Invalid Price Difference. Marked Price Must be Greater than Selling Price");
			}
			validateCourseNotNull(course);
			validateName(course.getName());
			validateURL(course.getCoverImage());
			validateLanguage(course.getLanguage());
			validateMarkedPrice(course.getMarkedPrice());
			validateSellingPrice(course.getSellingPrice());
			validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice());
			validateTiming(course.getTiming());
			validateDescription(course.getDescription());
			validateInsutructorName(course.getInstructorName());
			validateCompanyName(course.getCompanyName());
			validateCompanyCategory(course.getCompanyCategory());
			validateTopSkils(course.getTopSkills());
			List<String> videoNames = Arrays.asList(course.getCourseVideoName1(),course.getCourseVideoName2(),course.getCourseVideoName3());
			List<String> courseVideos = Arrays.asList(course.getCourseVideo1(), course.getCourseVideo2(), course.getCourseVideo3());
			validateCourseVideoNames(videoNames);
			validateCourseVideos(courseVideos);
		} catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage());
		}
	}

	/**
	 * Validates a Course object for various attributes, intended for course
	 * updates. (Update Course Validation)
	 * 
	 * @param course The Course object to be validated.
	 * @return true if the updated course is valid, false otherwise.
	 * @throws InvalidCourseException If the updated course is found to be invalid.
	 */
	public static void validateUpdatedCourse(Course course) throws InvalidCourseException {
		try {
			if(!validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice())) {
				throw new InvalidCourseException("Invalid Price Difference. Marked Price Must be Greater than Selling Price");
			}
			List<String> videoNames = Arrays.asList(course.getCourseVideoName1(),course.getCourseVideoName2(),course.getCourseVideoName3());
			List<String> courseVideos = Arrays.asList(course.getCourseVideo1(), course.getCourseVideo2(), course.getCourseVideo3());
			validateCourseNotNull(course);
			validateURL(course.getCoverImage());
			validateLanguage(course.getLanguage());
			validateMarkedPrice(course.getMarkedPrice());
			validateSellingPrice(course.getSellingPrice());
			validatePriceDifference(course.getMarkedPrice(), course.getSellingPrice());
			validateTiming(course.getTiming());
			validateDescription(course.getDescription());
			validateInsutructorName(course.getInstructorName());
			validateCompanyName(course.getCompanyName());
			validateCompanyCategory(course.getCompanyCategory());
			validateTopSkils(course.getTopSkills());
			validateCourseVideoNames(videoNames);
			validateCourseVideos(courseVideos);
		} catch (InvalidCourseException e) {
			throw new InvalidCourseException(e.getMessage());
		}
	}
	
	/**
	 * Validates a course name based on specific pattern criteria.
	 *
	 * @param name The course name to be validated.
	 * @return true if the course name is valid, false otherwise.
	 * @throws InvalidCourseException If the course name is found to be invalid.
	 */
	public static void validateName(String name) throws InvalidCourseException {
		String trimmedName = name.trim();
		String regex = "^(?=.*[A-Za-z])[A-Za-z0-9\\s]{3,30}$";
		if (!Pattern.matches(regex, trimmedName)) {
			throw new InvalidCourseException(
					"Invalid course name. Course names must be 3 to 30 characters long and may include letters, numbers, and spaces.");
		}
	}

	/**
	 * Validates a course is null or not based on specific pattern criteria.
	 *
	 * @param name The course object to be validated.
	 * @return true if the course object is not null, false otherwise.
	 * @throws InvalidCourseException If the course object is found to be invalid.
	 */
	public static void validateCourseNotNull(Course course) throws InvalidCourseException {
		if (course == null) {
			throw new InvalidCourseException("Course Details Is Null.");
		}
	}

	/**
	 * Validates a Image URL based on specific pattern criteria.
	 *
	 * @param url The Image URL to be validated.
	 * @return true if the Image URL is valid, false otherwise.
	 * @throws InvalidCourseException If the Image URL is found to be invalid.
	 */
	public static void validateURL(String url) throws InvalidCourseException {
		String regex = "^https://.*\\.(png|jpeg|jpg)$";
		if (!Pattern.matches(regex, url)) {
			throw new InvalidCourseException("Invalid course image URL. Please provide a valid HTTP or HTTPS URL.");
		}
	}

	/**
	 * Validates a language name based on specific pattern criteria.
	 *
	 * @param name The language name to be validated.
	 * @return true if the language name is valid, false otherwise.
	 * @throws InvalidCourseException If the language name is found to be invalid.
	 */
	public static void validateLanguage(String name) throws InvalidCourseException {
		String trimmedLanguage = name.trim();
		String regex = "^[A-Za-z\\s]{3,30}$";
		if (!Pattern.matches(regex, trimmedLanguage)) {
			throw new InvalidCourseException(
					"Invalid course language. Course languages must be 3 to 30 characters long and may include letters and spaces.");
		}
	}

	/**
	 * Validates a marked price based on specific pattern criteria.
	 *
	 * @param markedPrice The marked price to be validated.
	 * @return true if the marked price is valid, false otherwise.
	 * @throws InvalidCourseException If the marked price is found to be invalid.
	 */
	public static void validateMarkedPrice(int markedprice) throws InvalidCourseException {
		String mp = Integer.toString(markedprice);
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
		if (!Pattern.matches(pricePattern, mp) || !mp.equals(Integer.toString(Integer.parseInt(mp)))) {
			throw new InvalidCourseException(
					"Invalid course marked price. Please provide a valid price (e.g., 100 or 99.99).");
		}
	}

	/**
	 * Validates a selling price based on specific pattern criteria.
	 *
	 * @param sellingPrice The selling price to be validated.
	 * @return true if the selling price is valid, false otherwise.
	 * @throws InvalidCourseException If the selling price is found to be invalid.
	 */
	public static void validateSellingPrice(int sellingprice) throws InvalidCourseException {
		String sp = Integer.toString(sellingprice);
		String pricePattern = "^(\\d+\\.\\d{1,2}|\\d+)$";
		if (!Pattern.matches(pricePattern, sp) || !sp.equals(Integer.toString(Integer.parseInt(sp)))) {
			throw new InvalidCourseException(
					"Invalid course selling price. Please provide a valid price (e.g., 100 or 99.99).");
		}
	}
 
	/**
	 * Validates the price difference between marked price and selling price.
	 *
	 * @param markedPrice  The marked price of the course.
	 * @param sellingPrice The selling price of the course.
	 * @return
	 * @return true if the price difference is valid, false otherwise.
	 */
	public static boolean validatePriceDifference(int markedPrice, int sellingPrice) {
		return markedPrice > sellingPrice;
	}

	/**
	 * Validates course timing based on specific pattern criteria.
	 *
	 * @param timing The course timing to be validated.
	 * @return true if the timing is valid, false otherwise.
	 * @throws InvalidCourseException If the timing is found to be invalid.
	 */
	public static void validateTiming(String timing) throws InvalidCourseException {
		String courseTimingPattern = "^(\\d+)hrs$";
		int hours = Integer.parseInt(timing.replaceAll("\\D+", ""));
		if (!Pattern.matches(courseTimingPattern, timing) || hours <= 0) {
			throw new InvalidCourseException(
					"Invalid course timing. Please provide a valid timing format (e.g., 10hrs).");
		} 
	}

	/**
	 * Validates an instructor name based on specific pattern criteria.
	 *
	 * @param instructorName The instructor name to be validated.
	 * @return true if the instructor name is valid, false otherwise.
	 * @throws InvalidCourseException If the instructor name is found to be invalid.
	 */
	public static void validateInsutructorName(String instructorname) throws InvalidCourseException {
		String trimmedInstructorName = instructorname.trim();
		String regex = "^[A-Za-z\\s]{3,50}$";
		if (!Pattern.matches(regex, trimmedInstructorName)) {
			throw new InvalidCourseException(
					"Invalid course instructor name. Instructor names must be 3 to 50 characters long and may include letters and spaces.");
		}
	}

	/**
	 * Validates a company name based on specific pattern criteria.
	 *
	 * @param companyName The company name to be validated.
	 * @return true if the company name is valid, false otherwise.
	 * @throws InvalidCourseException If the company name is found to be invalid.
	 */
	public static void validateCompanyName(String companyname) throws InvalidCourseException {
		String trimmedComapnyName = companyname.trim();
		String regex = "^[A-Za-z\\s]{3,100}$";
		if (!Pattern.matches(regex, trimmedComapnyName)) {
			throw new InvalidCourseException(
					"Invalid course company name. Company names must be 3 to 100 characters long and may include letters and spaces.");
		}
	}

	/**
	 * Validates a company category based on specific pattern criteria.
	 *
	 * @param companycategory The company category to be validated.
	 * @return true if the company category is valid, false otherwise.
	 * @throws InvalidCourseException If the company category is found to be
	 *                                invalid.
	 */
	public static void validateCompanyCategory(String companycategory) throws InvalidCourseException {
		String trimmedCompanyCategory = companycategory.trim();
		String regex = "^[A-Za-z\\s]{3,100}$";
		if (!Pattern.matches(regex, trimmedCompanyCategory)) {
			throw new InvalidCourseException(
					"Invalid course company category. Company categories must be 3 to 100 characters long and may include letters and spaces.");
		}
	}

	/**
	 * Validates top skills based on specific pattern criteria.
	 *
	 * @param topskills The top skills to be validated.
	 * @return true if the top skills are valid, false otherwise.
	 * @throws InvalidCourseException If the top skills are found to be invalid.
	 */
	public static void validateTopSkils(String topskills) throws InvalidCourseException {
		String trimmedTopSkills = topskills.trim();
		String regex = "^[A-Za-z\\s]{3,150}$";
		if (!Pattern.matches(regex, trimmedTopSkills)) {
			throw new InvalidCourseException(
					"Invalid course top skills. Top skills must be 3 to 150 characters long and may include letters and spaces.");
		}
	}
	
	
	/**
	 * Validates a course description to ensure it is not empty and contains more than 30 words.
	 *
	 * @param description The description to be validated.
	 * @throws InvalidCourseException If the description is found to be invalid.
	 */
	public static void validateDescription(String description) throws InvalidCourseException {
	    if (description == null || description.trim().isEmpty()) {
	        throw new InvalidCourseException("Description cannot be empty.");
	    }
	    String[] words = description.trim().split("\\s+");
	    
	    if (words.length < 30) {
	        throw new InvalidCourseException("Description must contain more than 30 words.");
	    }
	}
	
	
	/**
	 * Validates a list of course Video Names to ensure it is not empty and contains alphabets and space.
	 *
	 * @param course Video Names The Course Video Names to be Validated.
	 * @throws InvalidCourseException If the Names is found to be invalid.
	 */
	public static void validateCourseVideoNames(List<String> videoNames) throws InvalidCourseException {
	    String regex = "^[A-Za-z\\s]{3,100}$";
	    
	    for (String videoName : videoNames) {
	    	String trimmedVideoName = videoName.trim();
	        boolean match = Pattern.matches(regex, trimmedVideoName);
	        if (!match) {
	            throw new InvalidCourseException(
	                    "Invalid course video name. Video names must be 3 to 100 characters long and may include letters, and spaces.");
	        }
	    }
	}
	
	
	/**
	 * Validates a list of course Video URL to ensure it is not empty and its length should be more than 10.
	 *
	 * @param course Video URL The Course Video URL to be Validated.
	 * @throws InvalidCourseException If the Video URL is found to be invalid.
	 */
	public static void validateCourseVideos(List<String> videos) throws InvalidCourseException {
	    for (String video : videos) {
	        if (video.length() < 10) {
	            throw new InvalidCourseException(
	                    "Invalid course video. Video names must be between 3 and 100 characters long.");
	        }
	    }
	}
	

}