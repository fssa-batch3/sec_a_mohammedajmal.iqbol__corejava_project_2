package com.fssa.freshstocks.services;

import java.util.*;
import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;
import com.fssa.freshstocks.validation.CourseValidator;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

public class CourseService {

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

	// get course details from course name
	public List<Course> listCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			return courseDAO.readCourse(course);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	// updated course
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

	// delete course
	public boolean deleteCourse(Course course, int isDeleted) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
			if (courseDAO.sameNameExist(course)) {
				boolean success = courseDAO.deleteCourse(course.getCourseID(), isDeleted);
				if (success) {
					System.out.println("Course with courseID: " + course.getCourseID() + " Successfully Deleted!");
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
