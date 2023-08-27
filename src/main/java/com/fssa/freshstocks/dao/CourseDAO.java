package com.fssa.freshstocks.dao;

import java.util.*;
import com.fssa.freshstocks.constants.CourseModuleConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.utils.ConnectionUtil;

public class CourseDAO {

	
	/**
	 * Creates a new course in the database.
	 *
	 * @param course The Course object representing the course to be created.
	 * @return {@code true} if the creation was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean createCourse(Course course) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "INSERT INTO course (course_id, name, cover_image, timing, language, marked_price, selling_price, description, instructor_name, company_name, company_category, top_skills, user_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

	        pst.setInt(1, course.getCourseID());
	        pst.setString(2, course.getName().toLowerCase().trim());
	        pst.setString(3, course.getCoverImage());
	        pst.setString(4, course.getTiming());
	        pst.setString(5, course.getLanguage());
	        pst.setInt(6, course.getMarkedPrice());
	        pst.setInt(7, course.getSellingPrice());
	        pst.setString(8, course.getDescription());
	        pst.setString(9, course.getInstructorName());
	        pst.setString(10, course.getCompanyName());
	        pst.setString(11, course.getCompanyCategory());
	        pst.setString(12, course.getTopSkills());
	        pst.setInt(13, course.getUserID());

	        // Execute query
	        rows = pst.executeUpdate();
	    } catch (SQLException e) {
	        throw new DAOException(CourseModuleConstants.CREATE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}

	
	/**
	 * Checks whether a course with the same name exists in the database.
	 *
	 * @param course The Course object representing the course to check against.
	 * @return {@code true} if a course with the same name exists, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean sameNameExist(Course course) throws DAOException {
	    boolean match = false;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE name = ?")) {

	        pst.setString(1, course.getName());

	        ResultSet resultSet = pst.executeQuery();

	        while (resultSet.next()) {
	            String name1 = resultSet.getString("name").toLowerCase().trim();
	            if (course.getName().toLowerCase().trim().equals(name1)) {
	                match = true;
	                break;
	            }
	        }

	    } catch (SQLException e) {
	        throw new DAOException(CourseModuleConstants.SAME_NAME_EXIST_ERROR + e);
	    }

	    return match;
	}

	
	/**
	 * Retrieves a list of courses belonging to a specific user from the database.
	 *
	 * @param course The Course object representing the user and additional criteria for course retrieval.
	 * @return A list of Course objects representing the courses associated with the user.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public List<Course> readCourse(int userID) throws DAOException {
	    List<Course> list1 = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement("SELECT c.*, f.username FROM course c INNER JOIN freshstocks f ON c.user_id = f.user_id WHERE c.user_id = ? AND c.is_deleted = 0")) {
	        pst.setInt(1, userID);
	        try (ResultSet resultSet = pst.executeQuery()) {
	            
	            while (resultSet.next()) {
	            String username = resultSet.getString("username");
				String name = resultSet.getString("name");
				String coverImage = resultSet.getString("cover_image");
				String timing = resultSet.getString("timing");
				String language = resultSet.getString("language");
				int markedPrice = resultSet.getInt("marked_price");
				int sellingPrice = resultSet.getInt("selling_price");
				String description = resultSet.getString("description");
				String instructorName = resultSet.getString("instructor_name");
				String companyName = resultSet.getString("company_name");
				String companyCategory = resultSet.getString("company_category");
				String topSkills = resultSet.getString("top_skills");
				int userID1 = resultSet.getInt("user_id");
				int courseID = resultSet.getInt("course_id");
                
				Course course1 = new Course(username,courseID,name, coverImage,timing,language,markedPrice,sellingPrice,
						description, instructorName, companyName, companyCategory,topSkills,userID1);
				list1.add(course1);

			 }
	       }
	        } catch (SQLException e) {
	            throw new DAOException(CourseModuleConstants.READ_ERROR_MESSAGE + e);
	        }
	        return list1;
	    }

	
	/**
	 * Updates an existing course's information in the database.
	 *
	 * @param course   The Course object containing the updated course information.
	 * @param courseID The ID of the course to be updated.
	 * @return {@code true} if the update was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean updateCourse(Course course, int courseID) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "UPDATE course SET cover_image=?, timing=?, language=?, marked_price=?, selling_price=?, description=?, instructor_name=?, company_name=?, company_category=?, top_skills=? WHERE course_id = ?")) {

	        pst.setString(1, course.getCoverImage());
	        pst.setString(2, course.getTiming());
	        pst.setString(3, course.getLanguage());
	        pst.setInt(4, course.getMarkedPrice());
	        pst.setInt(5, course.getSellingPrice());
	        pst.setString(6, course.getDescription());
	        pst.setString(7, course.getInstructorName());
	        pst.setString(8, course.getCompanyName());
	        pst.setString(9, course.getCompanyCategory());
	        pst.setString(10, course.getTopSkills());
	        pst.setInt(11, courseID);

	        // Execute query
	        rows = pst.executeUpdate();
	    } catch (SQLException e) {
	        throw new DAOException(CourseModuleConstants.UPDATE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}

	
	/**
	 * Marks a course as deleted or undeleted in the database.
	 *
	 * @param courseID  The ID of the course to be marked.
	 * @param isDeleted The value indicating whether the course should be marked as deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean deleteCourse(int courseID, int isDeleted) throws DAOException {
	    int rows = 0;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(
	                 "UPDATE course SET is_deleted = ? WHERE course_id = ?")) {

	        String isDelete = Integer.toString(isDeleted);

	        pst.setString(1, isDelete);
	        pst.setInt(2, courseID);

	        // Execute query
	        rows = pst.executeUpdate();

	    } catch (SQLException e) {
	        throw new DAOException(CourseModuleConstants.DELETE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}

}
