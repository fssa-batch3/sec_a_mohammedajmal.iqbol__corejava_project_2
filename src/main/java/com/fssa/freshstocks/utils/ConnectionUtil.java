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
		dbUrl = "jdbc:mysql://localhost:3306/freshstocks_trading";
		dbUser = "root";
		dbPassword = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			throw new DatabaseException("Unable to Connect to Database", e);
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("Unable to Connect to Database", e);
		}
	}

}