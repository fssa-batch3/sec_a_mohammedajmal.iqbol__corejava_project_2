package com.fssa.freshstocks.dao;

//import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.utils.ConnectionUtil;

public class CourseDAO {


	// add new course to DB - Register
	public boolean createCourse(Course course) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Prepare SQL Statement
			String insertQuery = "INSERT INTO course (courseID,name,cover_image,timing,language,marked_price,selling_price,instructor_name,company_name,company_category,top_skills) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, course.getCourseID());
			pst.setString(2, course.getName().toLowerCase().trim());
			pst.setString(3, course.getCoverImage());
			pst.setString(4, course.getTiming());
			pst.setString(5, course.getLanguage());
			pst.setString(6, course.getMarkedPrice());
			pst.setString(7, course.getSellingPrice());
			pst.setString(8, course.getInstructorName());
			pst.setString(9, course.getCompanyName());
			pst.setString(10, course.getCompanyCategory());
			pst.setString(11, course.getTopSkills());
			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while creating courses." + e);
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}

		// Return Successful or not
		return (rows == 1);
	}

	// Name Should Not Exist
	public boolean sameNameExist(String name) throws DAOException {
	    boolean match = false;
	    int count = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE name = ?")) {
	        pst.setString(1, name);
	        try (ResultSet resultSet = pst.executeQuery()) {
	            while (resultSet.next()) {
	                String name1 = resultSet.getString("name");
	                System.out.println("Name: " + name1);
	                if (name.toLowerCase().trim().equals(name1)) {
	                    count++;
	                }
	            }
	        }
	        if (count > 0) {
	            match = true;
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error: " + e);
	    }

	    return match;
	}

	// get courses by course name
	public String readCourse(Course course) throws DAOException {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement pst = null;
		StringBuilder resultBuilder = new StringBuilder();

		try {
			connection = ConnectionUtil.getConnection();
			String selectQuery = "SELECT * FROM course WHERE name = ?";
			pst = connection.prepareStatement(selectQuery);
			pst.setString(1, course.getName());
			resultSet = pst.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				return "No courses found for the given name: " + course.getName();
			}

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String coverImage = resultSet.getString("cover_image");
				String timing = resultSet.getString("timing");
				String language = resultSet.getString("language");
				String markedPrice = resultSet.getString("marked_price");
				String sellingPrice = resultSet.getString("selling_price");
				String description = resultSet.getString("description");
				String instructorName = resultSet.getString("instructor_name");
				String companyName = resultSet.getString("company_name");
				String companyCategory = resultSet.getString("company_category");
				String topSkills = resultSet.getString("top_skills");

				if (course.getName().equalsIgnoreCase(name)) {
					resultBuilder.append("Name: ").append(name).append(", Cover Image: ").append(coverImage)
							.append(", Timing: ").append(timing).append(", Language: ").append(language)
							.append(", Marked Price: ").append(markedPrice).append(", Selling Price: ")
							.append(sellingPrice).append(", Description: ").append(description)
							.append(", Instructor Name: ").append(instructorName).append(", Company Name: ")
							.append(companyName).append(", Company Category: ").append(companyCategory)
							.append(", Top Skills: ").append(topSkills).append("\n");
				}

			}
		} catch (SQLException e) {
			throw new DAOException("Error while reading course: " + e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}
		return resultBuilder.toString();
	}

	// update course
	public boolean updateCourse(Course course, String name) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String updateQuery = "UPDATE course SET cover_image=?, timing=?, language=?, marked_price=?, selling_price=?, instructor_name=?, company_name=?, company_category=?, top_skills=? WHERE name = ?;";
			pst = connection.prepareStatement(updateQuery);
			pst.setString(1, course.getCoverImage());
			pst.setString(2, course.getTiming());
			pst.setString(3, course.getLanguage());
			pst.setString(4, course.getMarkedPrice());
			pst.setString(5, course.getSellingPrice());
			pst.setString(6, course.getInstructorName());
			pst.setString(7, course.getCompanyName());
			pst.setString(8, course.getCompanyCategory());
			pst.setString(9, course.getTopSkills());
			pst.setString(10, name.toLowerCase().trim());

			// Execute query
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error while updating course: " + e);
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}

	// delete course
	public boolean deleteCourse(String name, int isDeleted) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String isDelete = Integer.toString(isDeleted);

			String deleteQuery = "UPDATE course SET is_deleted = ? WHERE name = ?;";
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, isDelete);
			pst.setString(2, name.toLowerCase().trim());

			// Execute query
			rows = pst.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error while deleting course: " + e);
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("Error while closing resources: " + e.getMessage());
			}
		}
		// Return Successful or not
		return (rows == 1);
	}
}
