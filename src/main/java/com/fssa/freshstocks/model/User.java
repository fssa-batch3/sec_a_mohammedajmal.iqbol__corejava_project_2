package com.fssa.freshstocks.model;

public class User {

	private int userId;
	private String username;
	private String gender;
	private String mobileNumber;
	private String dateOfBirth;
	String email;
	String password;
	int isSeller;

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

	public String toString() {
		return "UserID: " + userId + "username: " + username + "gender: " + gender + "mobile_number: " + mobileNumber
				+ "date_of_birth: " + dateOfBirth + "Email: " + email + " Password: " + password;
	}

	public int getUserID() {
		return userId;
	}
	
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
}
