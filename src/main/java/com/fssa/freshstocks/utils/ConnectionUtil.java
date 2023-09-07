package com.fssa.freshstocks.utils;

import java.sql.Connection;
import com.fssa.freshstocks.utils.exception.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Private constructor to prevent instantiation
	private ConnectionUtil() {
		// Do nothing (empty constructor)
	}

	// Call the database connection
	public static Connection getConnection() throws DatabaseException {

		// Database URL and credentials
		final String dbUrl;
		final String dbUser;
		final String dbPassword;

		// localhost Credentials
		dbUrl = System.getenv("DB_URL1");
		dbUser = System.getenv("DB_USER1");
		dbPassword = System.getenv("DB_PASSWORD1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException | ClassNotFoundException e) {
			throw new DatabaseException("Unable to Connect to Database", e);
		} 
	}

}