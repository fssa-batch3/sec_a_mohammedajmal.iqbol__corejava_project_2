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
	private String courseVideo1;
	private String courseVideo2;
	private String courseVideo3;
	private String courseVideoName1;
	private String courseVideoName2;
	private String courseVideoName3;
	private int userID;
	private String username;
	private String createdAt;

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
			String description, String instructorName, String companyName, String companyCategory, String topSkills,int userID,
			String courseVideo1,String courseVideo2,String courseVideo3,String courseVideoName1,String courseVideoName2
			,String courseVideoName3) {
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
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
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
			int userID, String createdAt,String courseVideo1,String courseVideo2,String courseVideo3,String courseVideoName1,String courseVideoName2
			,String courseVideoName3) {
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
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
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
			int sellingPrice, String description,String courseVideo1,String courseVideo2,String courseVideo3,
			String courseVideoName1,String courseVideoName2,String courseVideoName3) {
		super();
		this.courseID = courseId;
		this.name = name;
		this.coverImage = coverImage;
		this.timing = timing;
		this.language = language;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
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
			String description, String instructorName, String companyName, String companyCategory, String topSkills
			,String courseVideo1,String courseVideo2,String courseVideo3,
			String courseVideoName1,String courseVideoName2,String courseVideoName3) {
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
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
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
			String companyCategory, String topSkills, int userID,String courseVideo1,String courseVideo2,String courseVideo3,String courseVideoName1,String courseVideoName2
			,String courseVideoName3) {
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
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
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
			String description, String instructorName, String companyName, String companyCategory, String topSkills,int userID, 
			int courseID,String courseVideo1,String courseVideo2,String courseVideo3,String courseVideoName1,String courseVideoName2
			,String courseVideoName3) {
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
		this.courseVideo1 = courseVideo1;
		this.courseVideo2 = courseVideo2;
		this.courseVideo3 = courseVideo3;
		this.courseVideoName1 = courseVideoName1;
		this.courseVideoName2 = courseVideoName2;
		this.courseVideoName3 = courseVideoName3;
		this.userID = userID;
		this.courseID = courseID;
	}
	
	
	public Course(String name, String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills,int userID, 
			int courseID) {
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
	
	/**
	 * Create a Course object with course payment information.
	 *
	 * @param courseID        The ID of the course.
	 * @param name            The name of the course.
	 * @param sellingPrice    The selling price of the course.
	 */	
    public Course(int courseID, String name, int sellingPrice) {
        this.courseID = courseID;
        this.name = name;
        this.sellingPrice = sellingPrice;
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
	
	public String getCourseVideo1() {
		return courseVideo1;
	}

	public void setCourseVideo1(String courseVideo1) {
		this.courseVideo1 = courseVideo1;
	}

	public String getCourseVideo2() {
		return courseVideo2;
	}

	public void setCourseVideo2(String courseVideo2) {
		this.courseVideo2 = courseVideo2;
	}

	public String getCourseVideo3() {
		return courseVideo3;
	}

	public void setCourseVideo3(String courseVideo3) {
		this.courseVideo3 = courseVideo3;
	}

	public String getCourseVideoName1() {
		return courseVideoName1;
	}

	public void setCourseVideoName1(String courseVideoName1) {
		this.courseVideoName1 = courseVideoName1;
	}

	public String getCourseVideoName2() {
		return courseVideoName2;
	}

	public void setCourseVideoName2(String courseVideoName2) {
		this.courseVideoName2 = courseVideoName2;
	}

	public String getCourseVideoName3() {
		return courseVideoName3;
	}

	public void setCourseVideoName3(String courseVideoName3) {
		this.courseVideoName3 = courseVideoName3;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
