package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class CommentDAO {
	
	 //connect to database
	 public Connection getConnection() throws SQLException {
		    Dotenv dotenv = Dotenv.load(); 
	        String dbUrl = dotenv.get("DB_URL");
	        String dbUser = dotenv.get("DB_USERNAME");
	        String dbPassword = dotenv.get("DB_PASSWORD");

	     return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	 }

}
