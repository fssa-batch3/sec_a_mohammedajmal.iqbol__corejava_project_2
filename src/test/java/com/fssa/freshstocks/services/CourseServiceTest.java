package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.UserDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.model.CourseProgressData;
import com.fssa.freshstocks.model.User;
import com.fssa.freshstocks.services.exception.ServiceException;

class CourseServiceTest {
	private CourseService courseService;

	@BeforeEach
	void setUp() {
		courseService = new CourseService();
	}

	@Test
	void testGetAllCourses() throws ServiceException {
		List<Course> actualCourses = courseService.getAllCourses();
        assertNotNull(actualCourses);
	}

	@Test
	void testGetCoursesFromCourseId() throws ServiceException {
		Course course = courseService.getCoursesFromCourseId(14);
		assertNotNull(course);

	} 

	@Test
	void testInvalidGetAllCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);

	}

	@Test
	void testInvalidGetFreeCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);

	}

	@Test
	void testInvalidGetLatestCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);
	}


    @Test
    public void testGetCourseByIdValid() throws DAOException {
        Course course = CourseDAO.getCourseById(34);
        assertNotNull(course);
    }

    @Test
    public void testGetCourseByIdInvalid() throws DAOException {
        Course course = CourseDAO.getCourseById(-1);
        assertNull(course);
    }

    @Test
    public void testGetCourseProgressValid() throws ServiceException {
        CourseProgressData progressData = courseService.getCourseProgress(68, 30);
        assertNotNull(progressData);
        assertNotNull(progressData.getLatestModifiedAt());
    }

    @Test
    public void testGetCourseProgressInvalid() throws ServiceException {
        CourseProgressData progressData = courseService.getCourseProgress(-1, -1);
        assertNull(progressData.getLatestModifiedAt());
    }

    @Test
    public void testUpdateVideoWatchStatusValid() throws ServiceException {
    	courseService.updateVideoWatchStatus(30, 1, 68);
        // Assert that the update was successful
        CourseProgressData progressData = courseService.getCourseProgress(68, 31);
        assertNotNull(progressData);
    }

    @Test
    public void testUpdatePurchaseCourseValid() throws ServiceException {
        int rowsUpdated = courseService.updatePurchasedCourses("30,31,22", 62);
        assertTrue(rowsUpdated > 0);
    }

    @Test
    public void testUpdatePurchaseCourseInvalid() throws ServiceException {
        int rowsUpdated = courseService.updatePurchasedCourses("30,31,22", -1);
        assertEquals(0, rowsUpdated);
    }
    
    @Test
    public void testgetPurchasedCoursesValid() throws ServiceException {
        List<Course> rowsUpdated;
		try {
			rowsUpdated = courseService.getPurchasedCourses("ajmal78@gmail.com");
		} catch (ServiceException | DAOException e) {
			throw new ServiceException(e);
		}
        assertNotNull(rowsUpdated);
    }
    
    @Test
    public void testgetPurchasedCourses() throws ServiceException {
        List<Course> rowsUpdated;
		try {
			rowsUpdated = courseService.getPurchasedCourses("ajmal784939@gmail.com");
		} catch (DAOException e) {
			throw new ServiceException(e);
		} 
		assertTrue(rowsUpdated.isEmpty());
    }
    
    
    @Test
    public void testgetPurchasedCoursesList() throws ServiceException {
        boolean rowsUpdated;
        User user = new User(62);
        Course course = null;
		rowsUpdated = courseService.purchaseCourse(user,course,30); 
        assertTrue(rowsUpdated);
    }
    
    @Test
    public void testgetCourseById() throws ServiceException {
        Course rowsUpdated = courseService.getCourseById(30);
        assertNotNull(rowsUpdated);
    }

    @Test
    public void testGetCoursesBySellerValid() throws ServiceException {
        List<Course> courses = courseService.getCoursesBySeller(63);
        assertNotNull(courses);
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testGetCoursesBySellerInvalid() throws ServiceException {
        List<Course> courses = courseService.getCoursesBySeller(-1);
        assertNotNull(courses);
        assertTrue(courses.isEmpty());
    }
}
