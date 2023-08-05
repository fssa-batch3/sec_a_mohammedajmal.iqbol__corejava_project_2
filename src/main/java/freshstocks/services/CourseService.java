package freshstocks.services;

import java.sql.SQLException;

import freshstocks.dao.CourseDAO;
import freshstocks.model.Course;
import freshstocks.services.exception.ServiceException;
import freshstocks.validation.CourseValidator;
import freshstocks.validation.exception.InvalidUserException;

public class CourseService {

	public static boolean registerCourse(Course course) throws ServiceException {
		CourseDAO courseDAO = new CourseDAO();
		Course course1 = new Course(course.getName());
		try {
		if(CourseValidator.validateCourse(course) && !courseDAO.SameNameExist(course1)) { 
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

}
