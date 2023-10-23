package com.fssa.freshstocks.services;

import java.util.*;
import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.model.CourseProgressData;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

public class CourseService {

	/**
	 * Registers a new course.
	 *
	 * @param course The Course object containing the course details.
	 * @return true if the course was successfully registered, false otherwise.
	 * @throws ServiceException If an error occurs during the course registration
	 *                          process.
	 */
	public boolean registerCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			CourseValidator.validateCourse(course);
			courseDAO.sameNameExist(course);
			return courseDAO.createCourse(course);
		} catch (DAOException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of courses associated with the given user ID.
	 *
	 * @param userID The ID of the user whose courses are to be retrieved.
	 * @return A list of Course objects associated with the user.
	 * @throws ServiceException If an error occurs while retrieving the course list.
	 */
	public List<Course> listCourse(int userID) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.readCourse(userID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of all courses from the database.
	 *
	 * @return A list of full Course objects.
	 * @throws ServiceException If an error occurs while retrieving the course list.
	 */
	public List<Course> getAllCourses() throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.getAllCourse();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a course which using courseID from the database.
	 *
	 * @return full Course object.
	 * @throws ServiceException If an error occurs while retrieving the course.
	 */
	public Course getCoursesFromCourseId(int courseID) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.getCourseFromCourseId(courseID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Updates an existing course with the given course ID.
	 *
	 * @param course   The updated Course object.
	 * @param courseID The ID of the course to be updated.
	 * @return true if the course was successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs while updating the course.
	 */
	public boolean updateCourse(Course course, int courseID) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			CourseValidator.validateUpdatedCourse(course);
			return courseDAO.updateCourse(course, courseID);
		} catch (DAOException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Deletes a course with the given course ID.
	 *
	 * @param courseID  The ID of the course to be deleted.
	 * @param isDeleted An indicator of whether the course should be marked as
	 *                  deleted. (0 for not deleted, 1 for deleted)
	 * @return true if the course was successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs while deleting the course.
	 */
	public boolean deleteCourse(int courseID, int isDeleted) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.deleteCourse(courseID, isDeleted);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	/**
	 * Purchases a course for a user.
	 *
	 * @param user The user making the purchase.
	 * @param course The course being purchased.
	 * @param courseId The unique identifier of the course.
	 * @return True if the purchase was successful, false if the course is already purchased.
	 * @throws ServiceException If an error occurs during the purchase process.
	 */
	public boolean purchaseCourse(User user, Course course, int courseId) throws ServiceException {
	    String userId = Integer.toString(user.getUserId());
	    String purchasedCourses = user.getPurchasedCourses();

	    // Check if purchasedCourses is not null and contains the course ID
	    if (purchasedCourses != null && purchasedCourses.contains(String.valueOf(courseId))) {
	        // The course is already purchased by the user
	        return false;
	    }

	    // Add logic to update purchasedCourses string with the new course ID
	    if (purchasedCourses == null) {
	        purchasedCourses = String.valueOf(courseId);
	    } else {
	        purchasedCourses += "," + courseId;
	    }

	    UserDAO userDAO = new UserDAO();
	    
	    try {
	        return userDAO.updateUserPurchasedCourses(userId, purchasedCourses);
	    } catch (DAOException e) {
	    	throw new ServiceException(e);
	    }
	}
	
	
	/**
	 * Retrieves a course by its unique identifier.
	 *
	 * @param courseId The unique identifier of the course to retrieve.
	 * @return The course with the specified ID.
	 * @throws ServiceException If an error occurs during the retrieval process.
	 */
    public Course getCourseById(int courseId) throws ServiceException {
        try {
            Course course = CourseDAO.getCourseById(courseId);

            if (course != null) {
                return course;
            } else {
                throw new ServiceException("Course with ID " + courseId + " not found.");
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Retrieves a list of courses that a user has purchased.
     *
     * @param email The email address of the user.
     * @return A list of purchased courses.
     * @throws ServiceException If an error occurs during the retrieval process.
     * @throws DAOException If an error occurs in the data access layer.
     */
    public List<Course> getPurchasedCourses(String email) throws ServiceException, DAOException {
        // Assuming userDAO is your Data Access Object for users
    	CourseDAO courseDAO = new CourseDAO();
    	UserService userService = new UserService();
       User user = null;
	user = userService.getUserByEmail(email);

        if (user != null && user.getPurchasedCourses() != null) {
            // Split the purchasedCourses string into an array of course IDs
            String[] courseIds = user.getPurchasedCourses().split(",");

            List<Course> purchasedCourses = new ArrayList<>();

            // Assuming courseDAO is your Data Access Object for courses
            for (String courseId : courseIds) {
                Course course = null;
				try {
					course = courseDAO.getCourseFromCourseId(Integer.parseInt(courseId));
				} catch (NumberFormatException | DAOException e) {
					throw new ServiceException(e);
				} 
                if (course != null) {
                    purchasedCourses.add(course);
                }
            }

            return purchasedCourses;
        }

        return Collections.emptyList(); // User not found or no purchased courses
    }
    
    
    /**
     * Retrieves the progress data of a user in a specific course.
     *
     * @param userId The unique identifier of the user.
     * @param courseId The unique identifier of the course.
     * @return The progress data of the user in the specified course.
     * @throws ServiceException If an error occurs during the retrieval process.
     */
    public CourseProgressData getCourseProgress(int userId, int courseId) throws ServiceException {
        try {
        	CourseDAO courseDAO = new CourseDAO();
            return courseDAO.getCourseProgress(userId, courseId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Retrieves a list of courses associated with a seller.
     *
     * @param sellerId The unique identifier of the seller.
     * @return A list of courses sold by the seller.
     * @throws ServiceException If an error occurs during the retrieval process.
     */
    public List<Course> getCoursesBySeller(int sellerId) throws ServiceException {
     try {
    	CourseDAO courseDAO = new CourseDAO();
        return courseDAO.getCoursesBySeller(sellerId);
    } catch (DAOException e) {
        throw new ServiceException(e);
    }
    }
    
    /**
     * Updates the watch status of a video for a user in a specific course.
     *
     * @param courseID The unique identifier of the course.
     * @param videoID The unique identifier of the video.
     * @param userID The unique identifier of the user.
     * @throws ServiceException If an error occurs during the update process.
     */
    public void updateVideoWatchStatus(int courseID, int videoID, int userID) throws ServiceException {
        try {
        	CourseDAO courseDAO = new CourseDAO();
        	courseDAO.updateVideoWatchStatus(courseID, videoID, userID);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    /**
     * Updates the list of purchased courses for a user.
     *
     * @param updatedPurchasedCourses The updated list of purchased courses.
     * @param userId The unique identifier of the user.
     * @return The number of rows updated in the database.
     * @throws ServiceException If an error occurs during the update process.
     */
    public int updatePurchasedCourses(String updatedPurchasedCourses, int userId) throws ServiceException {
        int rowsUpdated = 0;

        try {
        	CourseDAO courseDAO = new CourseDAO();
            rowsUpdated = courseDAO.updatePurchaseCourse(updatedPurchasedCourses, userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return rowsUpdated;
    }
    
    
    /**
     * Retrieves a list of courses from the database with a specified limit and offset.
     *
     * @param offset The starting point for fetching courses.
     * @param limit The maximum number of courses to fetch.
     * @return A list of courses within the specified limit and offset.
     * @throws ServiceException If an error occurs while fetching courses.
     */
    public List<Course> getCoursesWithLimitOffset(int offset, int limit) throws ServiceException {
        try {
        	CourseDAO courseDAO = new CourseDAO();
            return courseDAO.getCoursesWithLimitOffset(offset, limit);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Retrieves the total count of courses in the database.
     *
     * @return The total count of courses in the database.
     * @throws ServiceException If an error occurs while fetching the total course count.
     */
    public int getTotalCourseCount() throws ServiceException {
        try {
        	CourseDAO courseDAO = new CourseDAO();
            return courseDAO.getTotalCourseCount();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    
}
