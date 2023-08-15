package com.fssa.freshstocks.dao;

//import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
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
			String insertQuery = "INSERT INTO course (courseID,name,cover_image,timing,language,marked_price,selling_price,description,instructor_name,company_name,company_category,top_skills,userID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, course.getCourseID());
			pst.setString(2, course.getName().toLowerCase().trim());
			pst.setString(3, course.getCoverImage());
			pst.setString(4, course.getTiming());
			pst.setString(5, course.getLanguage());
			pst.setString(6, course.getMarkedPrice());
			pst.setString(7, course.getSellingPrice());
			pst.setString(8, course.getDescription());
			pst.setString(9, course.getInstructorName());
			pst.setString(10, course.getCompanyName());
			pst.setString(11, course.getCompanyCategory());
			pst.setString(12, course.getTopSkills());
			pst.setInt(13, course.getUserID());
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
	public boolean sameNameExist(Course course) throws DAOException {
	    boolean match = false;
	    int count = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE courseID = ?")) {
	        pst.setInt(1, course.getCourseID());
	        try (ResultSet resultSet = pst.executeQuery()) {
	            while (resultSet.next()) {
	                String name1 = resultSet.getString("name");
	                System.out.println("Name: " + name1);
	                if (course.getName().toLowerCase().trim().equals(name1)) {
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
	public List<Course> readCourse(Course course) throws DAOException {
	    List<Course> list1 = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE userID = ?")) {
	        pst.setInt(1, course.getUserID());
	        try (ResultSet resultSet = pst.executeQuery()) {
	            
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
				int userID = resultSet.getInt("userID");
                
				Course course1 = new Course(name, coverImage,timing,language,markedPrice,sellingPrice,
						description, instructorName, companyName, companyCategory,topSkills,userID);
				list1.add(course1);

			 }
	       }
	        } catch (SQLException e) {
	            throw new DAOException("Error while reading course: " + e);
	        }
	        return list1;
	    }

	// update course
	public boolean updateCourse(Course course, int courseID) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String updateQuery = "UPDATE course SET cover_image=?, timing=?, language=?, marked_price=?, selling_price=?, description=?, instructor_name=?, company_name=?, company_category=?, top_skills=? userID=? WHERE courseID = ?;";
			pst = connection.prepareStatement(updateQuery);
			pst.setString(1, course.getCoverImage());
			pst.setString(2, course.getTiming());
			pst.setString(3, course.getLanguage());
			pst.setString(4, course.getMarkedPrice());
			pst.setString(5, course.getSellingPrice());
			pst.setString(6, course.getDescription());
			pst.setString(7, course.getInstructorName());
			pst.setString(8, course.getCompanyName());
			pst.setString(9, course.getCompanyCategory());
			pst.setString(10, course.getTopSkills());
			pst.setInt(11, course.getUserID());
			pst.setInt(12, courseID);

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
	public boolean deleteCourse(int courseID, int isDeleted) throws DAOException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;

		try {
			connection = ConnectionUtil.getConnection();

			String isDelete = Integer.toString(isDeleted);

			String deleteQuery = "UPDATE course SET is_deleted = ? WHERE courseID = ?;";
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, isDelete);
			pst.setInt(2, courseID);

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
