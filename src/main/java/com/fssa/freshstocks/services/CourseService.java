package com.fssa.freshstocks.services;

import java.util.*;
import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

public class CourseService {

	/**
	 * Registers a new course.
	 *
	 * @param course The Course object containing the course details.
	 * @return true if the course was successfully registered, false otherwise.
	 * @throws ServiceException If an error occurs during the course registration process.
	 */
	public boolean registerCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			if (CourseValidator.validateCourse(course) && !courseDAO.sameNameExist(course)) {
				boolean success = courseDAO.createCourse(course);
				if (success) {
					System.out.println(course.getName() + " Successfully Registered!");
				}
				return success;
			} else {
				return false;
			}
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
			if (CourseValidator.validateUpdatedCourse(course)) {
				boolean success = courseDAO.updateCourse(course, courseID);
				if (success) {
					System.out.println("Course with CourseID: " + courseID + " Successfully Updated!");
				}
				return success;
			} else {
				return false;
			}
		} catch (DAOException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Deletes a course with the given course ID.
	 *
	 * @param courseID The ID of the course to be deleted.
	 * @param isDeleted An indicator of whether the course should be marked as deleted.
	 *                  (0 for not deleted, 1 for deleted)
	 * @return true if the course was successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs while deleting the course.
	 */
	public boolean deleteCourse(int courseID, int isDeleted) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
				boolean success = courseDAO.deleteCourse(courseID, isDeleted);
				if (success) {
					System.out.println("Course with courseID: " + courseID + " Successfully Deleted!");
				}
				return success;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
