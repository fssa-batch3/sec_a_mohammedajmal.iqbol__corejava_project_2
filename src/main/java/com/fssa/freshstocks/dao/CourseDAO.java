package com.fssa.freshstocks.dao;

import java.util.*;
import com.fssa.freshstocks.constants.CourseModuleConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.model.CourseProgressData;
import com.fssa.freshstocks.utils.ConnectionUtil;
import com.fssa.freshstocks.utils.exception.DatabaseException;

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
	                    "INSERT INTO course (name, cover_image, timing, language, marked_price, selling_price, description, instructor_name, company_name, company_category, top_skills, user_id, courseVideo1, courseVideo2, courseVideo3, courseVideoName1, courseVideoName2, courseVideoName3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

	        pst.setString(1, course.getName().toLowerCase().trim());
	        pst.setString(2, course.getCoverImage());
	        pst.setString(3, course.getTiming());
	        pst.setString(4, course.getLanguage());
	        pst.setInt(5, course.getMarkedPrice());
	        pst.setInt(6, course.getSellingPrice());
	        pst.setString(7, course.getDescription());
	        pst.setString(8, course.getInstructorName());
	        pst.setString(9, course.getCompanyName());
	        pst.setString(10, course.getCompanyCategory());
	        pst.setString(11, course.getTopSkills());
	        pst.setInt(12, course.getUserID());
	        pst.setString(13, course.getCourseVideo1());
	        pst.setString(14, course.getCourseVideo2());
	        pst.setString(15, course.getCourseVideo3());
	        pst.setString(16, course.getCourseVideoName1());
	        pst.setString(17, course.getCourseVideoName2());
	        pst.setString(18, course.getCourseVideoName3());

	        // Execute query
	        rows = pst.executeUpdate();
	    } catch (SQLException | DatabaseException e) {
	    	e.printStackTrace();
	        throw new DAOException(CourseModuleConstants.CREATE_ERROR_MESSAGE + e);
	    }

	    return (rows == 1);
	}


	/**
	 * Checks whether a course with the same name exists in the database.
	 *
	 * @param course The Course object representing the course to check against.
	 * @return {@code true} if a course with the same name exists, {@code false}
	 *         otherwise.
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

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.SAME_NAME_EXIST_ERROR + e);
		}

		return match;
	}

	/**
	 * Retrieves a list of courses belonging to a specific user from the database.
	 *
	 * @param course The Course object representing the user and additional criteria
	 *               for course retrieval.
	 * @return A list of Course objects representing the courses associated with the
	 *         user.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public List<Course> readCourse(int userID) throws DAOException {
		List<Course> list1 = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(
						"SELECT c.*, f.username FROM course c INNER JOIN freshstocks f ON c.user_id = f.user_id WHERE c.user_id = ? AND c.is_deleted = 0")) {
			pst.setInt(1, userID);
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {
					String username = resultSet.getString("username");
					String name = resultSet.getString("name");
					String coverImage = resultSet.getString(CourseModuleConstants.COLUMN_COVER_IMAGE);
					String timing = resultSet.getString(CourseModuleConstants.COLUMN_TIMING);
					String language = resultSet.getString(CourseModuleConstants.COLUMN_LANGUAGE);
					int markedPrice = resultSet.getInt(CourseModuleConstants.COLUMN_MARKED_PRICE);
					int sellingPrice = resultSet.getInt(CourseModuleConstants.COLUMN_SELLING_PRICE);
					String description = resultSet.getString(CourseModuleConstants.COLUMN_DESCRIPTION);
					String instructorName = resultSet.getString(CourseModuleConstants.COLUMN_INSTRUCTOR_NAME);
					String companyName = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_NAME);
					String companyCategory = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_CATEGORY);
					String topSkills = resultSet.getString(CourseModuleConstants.COLUMN_TOP_SKILLS);
					int userID1 = resultSet.getInt(CourseModuleConstants.COLUMN_USER_ID);
					int courseID = resultSet.getInt(CourseModuleConstants.COLUMN_COURSE_ID);
					String courseVideo1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO1);
					String courseVideo2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO2);
					String courseVideo3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO3);
					String courseVideoName1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME1);
					String courseVideoName2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME2);
					String courseVideoName3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME3);

					Course course1 = new Course(username, courseID, name, coverImage, timing, language, markedPrice,
							sellingPrice, description, instructorName, companyName, companyCategory, topSkills,
							userID1,courseVideo1,courseVideo2,courseVideo3,courseVideoName1,courseVideoName2,courseVideoName3);
					list1.add(course1);

				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.READ_ERROR_MESSAGE + e);
		}
		return list1;
	}

	/**
	 * Retrieves full list of courses from the database.
	 *
	 * @param course The Course object representing the user and additional criteria
	 *               for course retrieval.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public List<Course> getAllCourse() throws DAOException {
		List<Course> list1 = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM course WHERE is_deleted = 0")) {
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {
					String name = resultSet.getString("name");
					String coverImage = resultSet.getString(CourseModuleConstants.COLUMN_COVER_IMAGE);
					String timing = resultSet.getString(CourseModuleConstants.COLUMN_TIMING);
					String language = resultSet.getString(CourseModuleConstants.COLUMN_LANGUAGE);
					int markedPrice = resultSet.getInt(CourseModuleConstants.COLUMN_MARKED_PRICE);
					int sellingPrice = resultSet.getInt(CourseModuleConstants.COLUMN_SELLING_PRICE);
					String description = resultSet.getString(CourseModuleConstants.COLUMN_DESCRIPTION);
					String instructorName = resultSet.getString(CourseModuleConstants.COLUMN_INSTRUCTOR_NAME);
					String companyName = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_NAME);
					String companyCategory = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_CATEGORY);
					String topSkills = resultSet.getString(CourseModuleConstants.COLUMN_TOP_SKILLS);
					int userID1 = resultSet.getInt(CourseModuleConstants.COLUMN_USER_ID);
					int courseID = resultSet.getInt(CourseModuleConstants.COLUMN_COURSE_ID);
					String courseVideo1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO1);
					String courseVideo2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO2);
					String courseVideo3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO3);
					String courseVideoName1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME1);
					String courseVideoName2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME2);
					String courseVideoName3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME3);

					Course course1 = new Course(name, coverImage, timing, language, markedPrice, sellingPrice,
							description, instructorName, companyName, companyCategory, topSkills, userID1, courseID
							,courseVideo1,courseVideo2,courseVideo3,courseVideoName1,courseVideoName2,courseVideoName3);
					list1.add(course1);

				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.READ_ERROR_MESSAGE + e);
		}
		return list1;
	}


	/**
	 * Retrieves a list of courses belonging to a specific course from the database.
	 *
	 * @param course The Course object representing the user and additional criteria
	 *               for course retrieval.
	 * @return A list of Course objects representing the courses.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public Course getCourseFromCourseId(int courseID) throws DAOException {
		Course course1 = null;
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("SELECT * FROM course WHERE course_id = ? AND is_deleted = 0")) {
			pst.setInt(1, courseID);
			try (ResultSet resultSet = pst.executeQuery()) {

				while (resultSet.next()) {
					String name = resultSet.getString("name");
					String coverImage = resultSet.getString(CourseModuleConstants.COLUMN_COVER_IMAGE);
					String timing = resultSet.getString(CourseModuleConstants.COLUMN_TIMING);
					String language = resultSet.getString(CourseModuleConstants.COLUMN_LANGUAGE);
					int markedPrice = resultSet.getInt(CourseModuleConstants.COLUMN_MARKED_PRICE);
					int sellingPrice = resultSet.getInt(CourseModuleConstants.COLUMN_SELLING_PRICE);
					String description = resultSet.getString(CourseModuleConstants.COLUMN_DESCRIPTION);
					String instructorName = resultSet.getString(CourseModuleConstants.COLUMN_INSTRUCTOR_NAME);
					String companyName = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_NAME);
					String companyCategory = resultSet.getString(CourseModuleConstants.COLUMN_COMPANY_CATEGORY);
					String topSkills = resultSet.getString(CourseModuleConstants.COLUMN_TOP_SKILLS);
					int userID1 = resultSet.getInt(CourseModuleConstants.COLUMN_USER_ID);
					int courseID1 = resultSet.getInt(CourseModuleConstants.COLUMN_COURSE_ID);
					String courseVideo1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO1);
					String courseVideo2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO2);
					String courseVideo3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO3);
					String courseVideoName1 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME1);
					String courseVideoName2 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME2);
					String courseVideoName3 = resultSet.getString(CourseModuleConstants.COLUMN_COURSE_VIDEO_NAME3);

					course1 = new Course(name, coverImage, timing, language, markedPrice, sellingPrice, description,
							instructorName, companyName, companyCategory, topSkills, userID1, courseID1
							,courseVideo1,courseVideo2,courseVideo3,courseVideoName1,courseVideoName2,courseVideoName3);

				}
			}
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.READ_ERROR_MESSAGE + e);
		}
		return course1;
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
	                    "UPDATE course SET cover_image=?, timing=?, language=?, marked_price=?, selling_price=?, description=?, instructor_name=?, company_name=?, company_category=?, top_skills=?, courseVideo1=?, courseVideo2=?, courseVideo3=?, courseVideoName1=?, courseVideoName2=?, courseVideoName3=? WHERE course_id = ?")) {

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
	        pst.setString(11, course.getCourseVideo1());
	        pst.setString(12, course.getCourseVideo2());
	        pst.setString(13, course.getCourseVideo3());
	        pst.setString(14, course.getCourseVideoName1());
	        pst.setString(15, course.getCourseVideoName2());
	        pst.setString(16, course.getCourseVideoName3());
	        pst.setInt(17, courseID);

	        // Execute query
	        rows = pst.executeUpdate();
		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.UPDATE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}

	/**
	 * Marks a course as deleted or undeleted in the database.
	 *
	 * @param courseID  The ID of the course to be marked.
	 * @param isDeleted The value indicating whether the course should be marked as
	 *                  deleted (1) or not deleted (0).
	 * @return {@code true} if the marking was successful, {@code false} otherwise.
	 * @throws DAOException If there's an error while interacting with the database.
	 */
	public boolean deleteCourse(int courseID, int isDeleted) throws DAOException {
		int rows = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection
						.prepareStatement("UPDATE course SET is_deleted = ? WHERE course_id = ?")) {

			String isDelete = Integer.toString(isDeleted);

			pst.setString(1, isDelete);
			pst.setInt(2, courseID);

			// Execute query
			rows = pst.executeUpdate();

		} catch (SQLException | DatabaseException e) {
			throw new DAOException(CourseModuleConstants.DELETE_ERROR_MESSAGE + e);
		}

		return (rows == 1);
	}
	
	
	
	
    public static Course getCourseById(int courseId) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM course WHERE course_id = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, courseId);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                    	String courseName = resultSet.getString("name");
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
                        String courseVideo1 = resultSet.getString("courseVideo1");
                	    String courseVideo2 = resultSet.getString("courseVideo2");
                	    String courseVideo3 = resultSet.getString("courseVideo3");
                	    String courseVideoName1 = resultSet.getString("courseVideoName1");
                	    String courseVideoName2 = resultSet.getString("courseVideoName2");
                	    String courseVideoName3 = resultSet.getString("courseVideoName3");
                	    int userID = resultSet.getInt("user_id");
                        
                        return new Course(courseName,coverImage,timing,language,markedPrice,sellingPrice,description,instructorName
                        		,companyName,companyCategory,topSkills, userID,courseVideo1, courseVideo2, courseVideo3, courseVideoName1,
                   	         courseVideoName2,courseVideoName3);
                    } else {
                        return null; // Course with given ID not found
                    }
                }
            }
        } catch (SQLException | DatabaseException e) {
            throw new DAOException("Failed to retrieve course by ID" + e);
        }
    }
    
    
	public CourseProgressData getCourseProgress(int userId, int courseId) throws DAOException {
	    CourseProgressData courseProgressData = null;

	    try {
	        String query = "SELECT SUM(progress) as total_progress, MAX(modified_at) as latest_modified_at FROM course_progress WHERE user_id = ? AND course_id = ?";
	        Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, userId);
	        statement.setInt(2, courseId);

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            double totalProgress = resultSet.getDouble("total_progress");
	            Timestamp latestModifiedAt = resultSet.getTimestamp("latest_modified_at");
	            courseProgressData = new CourseProgressData(totalProgress, latestModifiedAt);
	        }

	        resultSet.close();
	        statement.close();
	    } catch (SQLException | DatabaseException e) {
	    	 throw new DAOException("Failed to retrieve progress and modified at" + e);
	    }

	    return courseProgressData;
	}
	
	
	public void updateVideoWatchStatus(int courseID, int videoID, int userID) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement checkIfExistsStmt = connection.prepareStatement(
	                 "SELECT * FROM course_progress WHERE user_id = ? AND course_id = ? AND video_id = ?");
	         PreparedStatement updateStmt = connection.prepareStatement(
	                 "UPDATE course_progress SET watched = true, progress = 100, modified_at = NOW() " +
	                 "WHERE user_id = ? AND course_id = ? AND video_id = ?");
	         PreparedStatement insertStmt = connection.prepareStatement(
	                 "INSERT INTO course_progress (user_id, course_id, video_id, progress, watched, modified_at) " +
	                 "VALUES (?, ?, ?, ?, true, NOW())")) {

	        checkIfExistsStmt.setInt(1, userID);
	        checkIfExistsStmt.setInt(2, courseID);
	        checkIfExistsStmt.setInt(3, videoID);
	        ResultSet resultSet = checkIfExistsStmt.executeQuery();

	        if (resultSet.next()) {
	            updateStmt.setInt(1, userID);
	            updateStmt.setInt(2, courseID);
	            updateStmt.setInt(3, videoID);
	            updateStmt.setInt(4, 100);
	            updateStmt.executeUpdate();
	        } else {
	            insertStmt.setInt(1, userID);
	            insertStmt.setInt(2, courseID);
	            insertStmt.setInt(3, videoID);
	            insertStmt.setInt(4, 100); // Set initial progress to 100
	            insertStmt.executeUpdate();
	        }
	    } catch (SQLException | DatabaseException e) {
	    	 throw new DAOException("Failed to update progress" + e);
	    }
	}
	
	
	public int updatePurchaseCourse(String updatedPurchasedCourses, int userId) throws DAOException {
		// Update the database
		String sql = "UPDATE freshstocks SET purchased_courses = ? WHERE user_id = ?";
		int rowsUpdated = 0; // Initialize rowsUpdated

		try (Connection connection = ConnectionUtil.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {

		    statement.setString(1, updatedPurchasedCourses);
		    statement.setInt(2, userId);

		    rowsUpdated = statement.executeUpdate();
		    
		} catch (DatabaseException | SQLException e) {
			 throw new DAOException("Failed to update purchased courses" + e);
		}

		return rowsUpdated; // Return the value
	}
	
	
    public List<Course> getCoursesBySeller(int sellerId) throws DAOException {
        List<Course> courses = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();
        		PreparedStatement statement = connection.prepareStatement("SELECT * FROM course WHERE user_id = ?")) {
            statement.setInt(1, sellerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	String courseName = resultSet.getString("name");
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
                String courseVideo1 = resultSet.getString("courseVideo1");
        	    String courseVideo2 = resultSet.getString("courseVideo2");
        	    String courseVideo3 = resultSet.getString("courseVideo3");
        	    String courseVideoName1 = resultSet.getString("courseVideoName1");
        	    String courseVideoName2 = resultSet.getString("courseVideoName2");
        	    String courseVideoName3 = resultSet.getString("courseVideoName3");
        	    int userID = resultSet.getInt("user_id");
        	    int courseID = resultSet.getInt("course_id");
                
                Course course = new Course(courseName,coverImage,timing,language,markedPrice,sellingPrice,description,instructorName
                		,companyName,companyCategory,topSkills, userID,courseID,courseVideo1, courseVideo2, courseVideo3, courseVideoName1,
           	         courseVideoName2,courseVideoName3);
                
                courses.add(course);
            }
        } catch (SQLException | DatabaseException e) {
        	throw new DAOException("Failed to get all courses by seller" + e);
		}

        return courses;
    }

}
