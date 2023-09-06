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
	 * Retrieves a list of courses which is free of cost from the database.
	 *
	 * @return A list of full Course objects.
	 * @throws ServiceException If an error occurs while retrieving the course list.
	 */
	public List<Course> getFreeCourses() throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.getFreeCourse();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of courses which is created latest 5 courses from the
	 * database.
	 *
	 * @return A list of full Course objects.
	 * @throws ServiceException If an error occurs while retrieving the course list.
	 */
	public List<Course> getLatestCourses() throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.getLatestCourse();
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
}
