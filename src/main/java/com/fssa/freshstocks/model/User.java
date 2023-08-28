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

    // Constructor for registration
    /**
     * Creates a new User object with registration information.
     *
     * @param username      The username of the user.
     * @param gender        The gender of the user.
     * @param mobileNumber  The mobile number of the user.
     * @param dateOfBirth   The date of birth of the user.
     * @param email         The email of the user.
     * @param password      The password of the user.
     * @param isSeller      The seller status of the user.
     */
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

    // Constructor for updating user information
    /**
     * Creates a new User object with updated information.
     *
     * @param gender        The updated gender of the user.
     * @param mobileNumber  The updated mobile number of the user.
     * @param dateOfBirth   The updated date of birth of the user.
     */
	public User(String gender, String mobileNumber, String dateOfBirth) {
		super();
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}

    // Constructor for deleting a user
    /**
     * Creates a new User object for deleting a user.
     *
     * @param userId  The ID of the user to be deleted.
     */
	public User(int userId) {
		super();
		this.userId = userId;
	}

    // Constructor for user login
    /**
     * Creates a new User object for user login.
     *
     * @param email     The email of the user for login.
     * @param password  The password of the user for login.
     */
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	   // Constructor for full user information
    /**
     * Creates a new User object with full information.
     *
     * @param userId      The ID of the user.
     * @param username    The username of the user.
     * @param gender      The gender of the user.
     * @param mobileNumber  The mobile number of the user.
     * @param dateOfBirth  The date of birth of the user.
     * @param email        The email of the user.
     * @param isSeller    The seller status of the user.
     * @param createdAt   The creation timestamp of the user.
     * @param modifiedAt  The modification timestamp of the user.
     * @param isDeleted   The deletion status of the user.
     */
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
	
    // Constructor for demo practice
    /**
     * Creates a new User object for demo practice.
     *
     * @param id         The ID of the user.
     * @param name       The username of the user.
     * @param emailId    The email of the user.
     * @param password   The password of the user.
     */
	public User(int id, String name, String emailId, String password) {
		this.userId = id;
		this.username = name;
		this.email = emailId;
		this.password = password;
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
	
    // toString method
    /**
     * Returns a string representation of the User object.
     *
     * @return A formatted string containing user information.
     */
	@Override
	public String toString() {
		return "UserID: " + userId + "username: " + username + "gender: " + gender + "mobile_number: " + mobileNumber
				+ "date_of_birth: " + dateOfBirth + "Email: " + email + " Password: " + password;
	}
}
