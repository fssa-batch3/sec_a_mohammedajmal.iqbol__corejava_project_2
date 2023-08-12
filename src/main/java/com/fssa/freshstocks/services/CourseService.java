package com.fssa.freshstocks.services;

import java.sql.SQLException;

import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

public class CourseService {

	public static boolean registerCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			if (CourseValidator.validateCourse(course) && !courseDAO.sameNameExist(course.getName())) {
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

	// get course details from course name
	public static String listCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		Course course1 = new Course(course.getName());
		try {
			return courseDAO.readCourse(course1);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	// updated course
	public static boolean updateCourse(Course course, String name) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			if (CourseValidator.validateUpdatedCourse(course)) {
				boolean success = courseDAO.updateCourse(course, name);
				if (success) {
					System.out.println("Course " + name + " Successfully Updated!");
				}
				return success;
			} else {
				return false;
			}
		} catch (DAOException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}

	// delete course
	public static boolean deleteCourse(String name, int isDeleted) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			if (courseDAO.sameNameExist(name)) {
				boolean success = courseDAO.deleteCourse(name, isDeleted);
				if (success) {
					System.out.println("Course " + name + " Successfully Deleted!");
				}
				return success;
			} else {
				System.out.println("Course Name Doesn't Exist!");
				return false;
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
