package freshstocks.services;

import java.sql.SQLException;

import freshstocks.dao.CourseDAO;
import freshstocks.dao.UserDAO;
import freshstocks.model.Course;
import freshstocks.services.exception.ServiceException;
import freshstocks.validation.CourseValidator;
import freshstocks.validation.exception.InvalidUserException;

public class CourseService {

	public static boolean registerCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
		if(CourseValidator.validateCourse(course) && !courseDAO.SameNameExist(course.getName())) { 
			if(courseDAO.createCourse(course)) {
				System.out.println(course.getName() + " Successfully Registered!");
				return true;
			} else {
				return false;
			}		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	// get course details from course name
	public static String listCourse(Course course) throws ServiceException, InvalidUserException {
	    CourseDAO courseDAO = new CourseDAO();
	    Course course1 = new Course(course.getName());
	    try {
	        return courseDAO.readCourse(course1);
	    } catch (SQLException e) {
	        throw new ServiceException(e);
	    }
	}
	
	//updated course
	public static boolean updateCourse(Course course, String name) throws ServiceException {
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
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	//delete course
	public static boolean deleteCourse(String name , int isDeleted) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		try {
		if(courseDAO.SameNameExist(name)) {
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
