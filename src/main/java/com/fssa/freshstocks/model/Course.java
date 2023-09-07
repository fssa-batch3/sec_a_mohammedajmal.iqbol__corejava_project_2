package com.fssa.freshstocks.model;

public class Course {

	// Fields
	private int courseID;
	private String name;
	private String coverImage;
	private String timing;
	private String language;
	private int markedPrice;
	private int sellingPrice;
	private String description;
	private String instructorName;
	private String companyName;
	private String companyCategory;
	private String topSkills;
	private int userID;
	private String username;
	private String createdAt;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	// Constructor to create a course
	/**
	 * Creates a new Course object with course creation information.
	 *
	 * @param name            The name of the course.
	 * @param coverImage      The cover image of the course.
	 * @param timing          The timing of the course.
	 * @param language        The language of the course.
	 * @param markedPrice     The marked price of the course.
	 * @param sellingPrice    The selling price of the course.
	 * @param description     The description of the course.
	 * @param instructorName  The name of the instructor.
	 * @param companyName     The name of the company.
	 * @param companyCategory The category of the company.
	 * @param topSkills       The top skills taught in the course.
	 * @param userID          The ID of the user associated with the course.
	 */
	public Course(String name, String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills,
			int userID) {
		super();
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.instructorName = instructorName;
		this.companyName = companyName;
		this.companyCategory = companyCategory;
		this.topSkills = topSkills;
		this.userID = userID;
	}

	// Constructor to display course information
	/**
	 * Creates a new Course object with displayed course information.
	 *
	 * @param name            The name of the course.
	 * @param coverImage      The cover image of the course.
	 * @param timing          The timing of the course.
	 * @param language        The language of the course.
	 * @param markedPrice     The marked price of the course.
	 * @param sellingPrice    The selling price of the course.
	 * @param description     The description of the course.
	 * @param instructorName  The name of the instructor.
	 * @param companyName     The name of the company.
	 * @param companyCategory The category of the company.
	 * @param topSkills       The top skills taught in the course.
	 * @param userID          The ID of the user associated with the course.
	 * @param createdAt       The creation timestamp of the course.
	 */
	public Course(String name, String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills,
			int userID, String createdAt) {
		super();
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.instructorName = instructorName;
		this.companyName = companyName;
		this.companyCategory = companyCategory;
		this.topSkills = topSkills;
		this.userID = userID;
		this.createdAt = createdAt;
	}

	// Constructor to show updated course information
	/**
	 * Creates a new Course object with updated course information.
	 *
	 * @param courseId     The ID of the course.
	 * @param name         The updated name of the course.
	 * @param coverImage   The updated cover image of the course.
	 * @param timing       The updated timing of the course.
	 * @param language     The updated language of the course.
	 * @param markedPrice  The updated marked price of the course.
	 * @param sellingPrice The updated selling price of the course.
	 * @param description  The updated description of the course.
	 */
	public Course(int courseId, String name, String coverImage, String timing, String language, int markedPrice,
			int sellingPrice, String description) {
		super();
		this.courseID = courseId;
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
	}

	// Constructor to update course information
	/**
	 * Creates a new Course object with updated course information.
	 *
	 * @param coverImage      The updated cover image of the course.
	 * @param timing          The updated timing of the course.
	 * @param language        The updated language of the course.
	 * @param markedPrice     The updated marked price of the course.
	 * @param sellingPrice    The updated selling price of the course.
	 * @param description     The updated description of the course.
	 * @param instructorName  The updated name of the instructor.
	 * @param companyName     The updated name of the company.
	 * @param companyCategory The updated category of the company.
	 * @param topSkills       The updated top skills taught in the course.
	 */
	public Course(String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills) {
		super();
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.instructorName = instructorName;
		this.companyName = companyName;
		this.companyCategory = companyCategory;
		this.topSkills = topSkills;
	}

	// Constructor to read or list course information
	/**
	 * Creates a new Course object with course information for reading or listing.
	 *
	 * @param username        The username of the course creator.
	 * @param courseID        The ID of the course.
	 * @param name            The name of the course.
	 * @param coverImage      The cover image of the course.
	 * @param timing          The timing of the course.
	 * @param language        The language of the course.
	 * @param markedPrice     The marked price of the course.
	 * @param sellingPrice    The selling price of the course.
	 * @param description     The description of the course.
	 * @param instructorName  The name of the instructor.
	 * @param companyName     The name of the company.
	 * @param companyCategory The category of the company.
	 * @param topSkills       The top skills taught in the course.
	 * @param userID          The ID of the user associated with the course.
	 */
	public Course(String username, int courseID, String name, String coverImage, String timing, String language,
			int markedPrice, int sellingPrice, String description, String instructorName, String companyName,
			String companyCategory, String topSkills, int userID) {
		super();
		this.username = username;
		this.courseID = courseID;
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.instructorName = instructorName;
		this.companyName = companyName;
		this.companyCategory = companyCategory;
		this.topSkills = topSkills;
		this.userID = userID;
	}

	/**
	 * Creates a new Course object with course creation information.
	 *
	 * @param name            The name of the course.
	 * @param coverImage      The cover image of the course.
	 * @param timing          The timing of the course.
	 * @param language        The language of the course.
	 * @param markedPrice     The marked price of the course.
	 * @param sellingPrice    The selling price of the course.
	 * @param description     The description of the course.
	 * @param instructorName  The name of the instructor.
	 * @param companyName     The name of the company.
	 * @param companyCategory The category of the company.
	 * @param topSkills       The top skills taught in the course.
	 * @param userID          The ID of the user associated with the course.
	 * @param courseID        The ID of the course.
	 */
	public Course(String name, String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills,
			int userID, int courseID) {
		super();
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.instructorName = instructorName;
		this.companyName = companyName;
		this.companyCategory = companyCategory;
		this.topSkills = topSkills;
		this.userID = userID;
		this.courseID = courseID;
	}

	// Constructor to delete or update course
	/**
	 * Creates a new Course object for deleting or updating a course.
	 *
	 * @param userID The ID of the user associated with the course.
	 */
	public Course(int userID) {
		super();
		this.userID = userID;
	}

	// Getters And Setters
	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public String getTiming() {
		return timing;
	}

	public String getLanguage() {
		return language;
	}

	public int getMarkedPrice() {
		return markedPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public String getDescription() {
		return description;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyCategory() {
		return companyCategory;
	}

	public String getTopSkills() {
		return topSkills;
	}

	public int getCourseID() {
		return courseID;
	}

}
