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
	String confirmPassword;
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
	
	
	/**
	 * Creates a new User object with updated information.
	 *
	 * @param profilepic   The updated profilepic of the user.
	 * @param gender       The updated gender of the user.
	 * @param mobileNumber The updated mobile number of the user.
	 * @param dateOfBirth  The updated date of birth of the user.
	 */
	public User(String profilepic ,String gender, String mobileNumber, String dateOfBirth) {
		super();
		this.profilePic = profilepic;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Creates a new User object for deleting a user.
	 *
	 * @param userId The ID of the user to be deleted.
	 */
	public User(int userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Creates a new User object for user login.
	 *
	 * @param email    The email of the user for login.
	 * @param password The password of the user for login.
	 */
	public User(String email) {
		super();
		this.email = email;
	}

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
	
	/**
	 * Constructs a User object with the specified email and password.
	 *
	 * @param email The email address of the user.
	 * @param password The password associated with the user.
	 */
	public User(String email, String password) {
		super();
		this.email = email;
	    this.password = password;
	}
	
	/**
	 * Constructs a User object with the specified password and confirmPassword.
	 *
	 * @param i The integer parameter added for unique constructor.
	 * @param password The password associated with the user.
	 * @param confirmPassword The confirmation of the user's password.
	 */
	public User(int i,String password, String confirmPassword) {
		super();
		this.password = email;
	    this.confirmPassword = confirmPassword;
	}

	/**
	 * Constructs a User object with the specified details.
	 *
	 * @param username The username of the user.
	 * @param gender The gender of the user.
	 * @param mobileNumber The mobile number of the user.
	 * @param dateOfBirth The date of birth of the user.
	 * @param email The email address of the user.
	 * @param isSeller A flag indicating if the user is a seller.
	 * @param createdAt The timestamp indicating when the user account was created.
	 * @param modifiedAt The timestamp indicating when the user account was last modified.
	 */
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
	
	/**
	 * Constructs a User object with the specified details including user ID and deletion status.
	 *
	 * @param userID The unique identifier of the user.
	 * @param username The username of the user.
	 * @param gender The gender of the user.
	 * @param mobileNumber The mobile number of the user.
	 * @param dateOfBirth The date of birth of the user.
	 * @param email The email address of the user.
	 * @param isSeller A flag indicating if the user is a seller.
	 * @param createdAt The timestamp indicating when the user account was created.
	 * @param modifiedAt The timestamp indicating when the user account was last modified.
	 * @param isDeleted A flag indicating if the user account is marked as deleted.
	 */
	public User(int userID,String username, String gender, String mobileNumber, String dateOfBirth, String email, int isSeller,
			String createdAt, String modifiedAt, int isDeleted) {
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
	
	// Getters And Setters
	
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
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

}
