package com.fssa.freshstocks.model;

public class Course {

	private int courseID;
	private String name;
	private String coverImage;
	private String timing;
	private String language;
	private String markedPrice;
	private String sellingPrice;
	private String description;
	private String instructorName;
	private String companyName;
	private String companyCategory;
	private String topSkills;

	public Course(String name, String coverImage, String timing, String language, String markedPrice,
			String sellingPrice, String description, String instructorName, String companyName, String companyCategory,
			String topSkills) {
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
	}

	public Course(String coverImage, String timing, String language, String markedPrice, String sellingPrice,
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

	public Course(String name) {
		this.name = name;
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

	public String getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(String markedPrice) {
		this.markedPrice = markedPrice;
	}

	public String getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(String sellingPrice) {
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

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", name=" + name + ", coverImage=" + coverImage + ", timing=" + timing
				+ ", language=" + language + ", markedPrice=" + markedPrice + ", sellingPrice=" + sellingPrice
				+ ", description=" + description + ", instructorName=" + instructorName + ", companyName=" + companyName
				+ ", companyCategory=" + companyCategory + ", topSkills=" + topSkills + "]";
	}

}
