package com.fssa.freshstocks.model;

public class User {

	// Fields
	private int userId;
	private String username;
	private String gender;
	private String mobileNumber;
	private String dateOfBirth;
	private String createdAt;
	private String modifiedAt;
	String profilePic;
	String email;
	String password;
	int isSeller;
	int isDeleted;
	private String purchasedCourses;


	// Constructor for registration
	/**
	 * Creates a new User object with registration information.
	 *
	 * @param username     The username of the user.
	 * @param gender       The gender of the user.
	 * @param mobileNumber The mobile number of the user.
	 * @param dateOfBirth  The date of birth of the user.
	 * @param email        The email of the user.
	 * @param password     The password of the user.
	 * @param isSeller     The seller status of the user.
	 */
	public User(String username, String gender, String mobileNumber, String dateOfBirth, String email, String password,
			int isSeller) {
		super();
		this.username = username;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.isSeller = isSeller;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	// Constructor for updating user information
	/**
	 * Creates a new User object with updated information.
	 *
	 * @param gender       The updated gender of the user.
	 * @param mobileNumber The updated mobile number of the user.
	 * @param dateOfBirth  The updated date of birth of the user.
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
	 * @param userId The ID of the user to be deleted.
	 */
	public User(int userId) {
		super();
		this.userId = userId;
	}

	// Constructor for user login
	/**
	 * Creates a new User object for user login.
	 *
	 * @param email    The email of the user for login.
	 * @param password The password of the user for login.
	 */
	public User(String email) {
		super();
		this.email = email;
		// this.password = password;
	}

	// Constructor for full user information
	/**
	 * Creates a new User object with full information.
	 *
	 * @param userId       The ID of the user.
	 * @param username     The username of the user.
	 * @param gender       The gender of the user.
	 * @param mobileNumber The mobile number of the user.
	 * @param dateOfBirth  The date of birth of the user.
	 * @param email        The email of the user.
	 * @param isSeller     The seller status of the user.
	 * @param createdAt    The creation timestamp of the user.
	 * @param modifiedAt   The modification timestamp of the user.
	 * @param isDeleted    The deletion status of the user.
	 */
	public User(int userID, String username, String gender, String mobileNumber, String dateOfBirth, String email,
			String password, int isSeller, String createdAt, String modifiedAt, int isDeleted, String profilePic
			,String purchasedCourses) {
		super();
		this.userId = userID;
		this.username = username;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
		this.isSeller = isSeller;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.isDeleted = isDeleted;
		this.profilePic = profilePic;
		this.purchasedCourses = purchasedCourses;
	}

	// Constructor for demo practice
	/**
	 * Creates a new User object for demo practice.
	 *
	 * @param id       The ID of the user.
	 * @param name     The username of the user.
	 * @param emailId  The email of the user.
	 * @param password The password of the user.
	 */
	public User(int id, String name, String emailId, String password) {
		this.userId = id;
		this.username = name;
		this.email = emailId;
		this.password = password;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
	    this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public User(String username, String gender, String mobileNumber, String dateOfBirth, String email, int isSeller,
			String createdAt, String modifiedAt) {
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

	public String getModifiedAt() {
		return modifiedAt;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	// Getters And Setters

	public int getIsSeller() {
		return isSeller;
	}

	public String getUsername() {
		return username;
	}

	public String getGender() {
		return gender;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPurchasedCourses() {
		return purchasedCourses;
	}

	public void setPurchasedCourses(String purchasedCourses) {
		this.purchasedCourses = purchasedCourses;
	}

}
