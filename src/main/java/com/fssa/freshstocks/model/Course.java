package com.fssa.freshstocks.model;

public class Course {

	//Fields
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
	
    // constructor to create course
	public Course(String name, String coverImage, String timing, String language, int markedPrice,
			int sellingPrice, String description, String instructorName, String companyName, String companyCategory,
			String topSkills,int userID) {
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

	 // constructor to update course
	public Course(String coverImage, String timing, String language, int markedPrice, int sellingPrice,
			String description, String instructorName, String companyName, String companyCategory, String topSkills
			,int userID) {
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
		this.userID = userID;
	}
	
	 // constructor to read or list course
	public Course(String username, int courseID, String name, String coverImage, String timing, String language, int markedPrice,
			int sellingPrice, String description, String instructorName, String companyName, String companyCategory,
			String topSkills,int userID) {
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
	
	//constructor to delete or update course
	public Course(int userID) {
		super();
		this.userID = userID;
	}
	
	//Getters And Setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(int markedPrice) {
		this.markedPrice = markedPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getTopSkills() {
		return topSkills;
	}

	public void setTopSkills(String topSkills) {
		this.topSkills = topSkills;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	// toString Method
	@Override
	public String toString() {
		return "[ userName=" + username + ", courseID=" + courseID + ", name=" + name + ", coverImage=" + coverImage + ", timing=" + timing
				+ ", language=" + language + ", markedPrice=" + markedPrice + ", sellingPrice=" + sellingPrice
				+ ", description=" + description + ", instructorName=" + instructorName + ", companyName=" + companyName
				+ ", companyCategory=" + companyCategory + ", topSkills=" + topSkills + "]";
	}
}
