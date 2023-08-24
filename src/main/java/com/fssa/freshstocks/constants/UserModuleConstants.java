package com.fssa.freshstocks.constants;

public class UserModuleConstants {

	//userDAO
	public static final String USER_SELECT_QUERY = "SELECT * FROM freshstocks WHERE email = ?";
	public static final String EMAIL_COLUMN_NAME = "email";
	public static final String PASSWORD_COLUMN_NAME = "password";
	public static final String PREFIX_EMAIL_STRING = "Email: ";
	public static final String PREFIX_PASSWORD_STRING = "Password: ";
    public static final String CLOSE_RESOURCE_ERROR = "Error while closing resources: ";
    
    //CRUD ERROR MESSAGES
    public static final String EMAIL_ERROR_MESSAGE = "Error checking email exist: ";
	public static final String REGISTER_ERROR_MESSAGE = "Error while creating user: ";
	public static final String UPDATE_ERROR_MESSAGE = "Error while updating user: ";
	public static final String DELETE_ERROR_MESSAGE = "Error while deleting user: ";
}
