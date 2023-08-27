package com.fssa.freshstocks.model;

public class User {

	//Fields
	private int userId;
	private String username;
	private String gender;
	private String mobileNumber;
	private String dateOfBirth;
	private String createdAt;
	private String modifiedAt;
	String email;
	String password;
	int isSeller;
	int isDeleted;

	// register
	public User(String username, String gender, String mobileNumber, String dateOfBirth, String email,
			String password,int isSeller) {
		super();
		this.username = username;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.isSeller = isSeller;
	}

	// update
	public User(String gender, String mobileNumber, String dateOfBirth) {
		super();
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}

	// delete
	public User(int userId) {
		super();
		this.userId = userId;
	}

	// login
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(int userID,String username, String gender, String mobileNumber, String dateOfBirth, String email,
			int isSeller,String createdAt,String modifiedAt,int isDeleted) {
		super();
		this.userId = userID;
		this.username = username;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.isSeller = isSeller;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isDeleted = isDeleted;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User(String username, String gender, String mobileNumber, String dateOfBirth, String email,
			int isSeller,String createdAt,String modifiedAt) {
		super();
		this.username = username;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.isSeller = isSeller;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	// Getters And Setters
	
	public int getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}

	public void setUserID(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getmobileNumber() {
		return mobileNumber;
	}

	public void setmobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getdateOfBirth() {
		return dateOfBirth;
	}

	public void setdateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString method
	@Override
	public String toString() {
		return "UserID: " + userId + "username: " + username + "gender: " + gender + "mobile_number: " + mobileNumber
				+ "date_of_birth: " + dateOfBirth + "Email: " + email + " Password: " + password;
	}
}
