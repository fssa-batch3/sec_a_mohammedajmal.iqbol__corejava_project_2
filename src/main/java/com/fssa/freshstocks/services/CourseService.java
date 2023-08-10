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

	public static boolean registerCourse(Course course) throws ServiceException, DAOException {
		CourseDAO courseDAO = new CourseDAO();
		try {
		if(CourseValidator.validateCourse(course) && !courseDAO.sameNameExist(course.getName())) { 
			if(courseDAO.createCourse(course)) {
				System.out.println(course.getName() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}		} else {
			return false;
		}
		} catch ( SQLException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}
	
	// get course details from course name
	public static String listCourse(Course course) throws ServiceException, InvalidUserException, DAOException {
	    CourseDAO courseDAO = new CourseDAO();
	    Course course1 = new Course(course.getName());
	    try {
	        return courseDAO.readCourse(course1);
	    } catch (SQLException e) {
	        throw new ServiceException(e);
	    }
	}
	
	//updated course
	public static boolean updateCourse(Course course, String name) throws ServiceException, DAOException {
		CourseDAO courseDAO = new CourseDAO();
		try {
		if(CourseValidator.validateUpdatedCourse(course)) { 
			if(courseDAO.updateCourse(course,name)) {
				System.out.println("Course " + name + " Successfully Updated!");
				return true;
			} else {
				return false;
			}		} else {
			return false;
		}
		} catch ( SQLException | InvalidCourseException e) {
			throw new ServiceException(e);
		}
	}
	
	//delete course
	public static boolean deleteCourse(String name , int isDeleted) throws ServiceException, DAOException {
		CourseDAO courseDAO = new CourseDAO();
		try {
		if(courseDAO.sameNameExist(name)) {
			if(courseDAO.deleteCourse(name, isDeleted)) {
				System.out.println("Course " + name + " Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Course Name Doesn't Exist!");
			return false;
		}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	

}
