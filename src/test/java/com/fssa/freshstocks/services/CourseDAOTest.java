package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.model.CourseProgressData;

class CourseDAOTest {
    private CourseDAO courseDAO;
    private long nanotime;

    @BeforeEach
     void setUp() {
        courseDAO = new CourseDAO();
        nanotime = System.nanoTime();
    }

    @Test
    void testSameNameExistWithMatchingName() throws DAOException {
    	Course course1 = new Course("foreign ex course",
    	        "https://example.com/image1.png",
    	        "10hrs", "English", 5000, 2000,
    	        "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmalll",
    	        "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        boolean result = courseDAO.sameNameExist(course1);
        assertTrue(result);
    }
 
    @Test
    void testSameNameExistWithNonMatchingName() throws DAOException {
    	Course course1 = new Course("Course" + nanotime,
    	        "https://example.com/image1.png",
    	        "10hrs", "English", 5000, 2000,
    	        "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmalll",
    	        "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        boolean result = courseDAO.sameNameExist(course1);
        assertFalse(result);
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
    public void testGetCourseProgressValid() throws DAOException {
        CourseProgressData progressData = courseDAO.getCourseProgress(68, 30);
        assertNotNull(progressData);
        assertNotNull(progressData.getLatestModifiedAt());
    }

    @Test
    public void testGetCourseProgressInvalid() throws DAOException {
        CourseProgressData progressData = courseDAO.getCourseProgress(-1, -1);
        assertNull(progressData.getLatestModifiedAt());
    }

    @Test
    public void testUpdateVideoWatchStatusValid() throws DAOException {
    	courseDAO.updateVideoWatchStatus(30, 1, 68);
        // Assert that the update was successful
        CourseProgressData progressData = courseDAO.getCourseProgress(68, 31);
        assertNotNull(progressData);
    }

    @Test
    public void testUpdatePurchaseCourseValid() throws DAOException {
        int rowsUpdated = courseDAO.updatePurchaseCourse("30,31,22", 62);
        assertTrue(rowsUpdated > 0);
    }

    @Test
    public void testUpdatePurchaseCourseInvalid() throws DAOException {
        int rowsUpdated = courseDAO.updatePurchaseCourse("30,31,22", -1);
        assertEquals(0, rowsUpdated);
    }

    @Test
    public void testGetCoursesBySellerValid() throws DAOException {
        List<Course> courses = courseDAO.getCoursesBySeller(63);
        assertNotNull(courses);
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testGetCoursesBySellerInvalid() throws DAOException {
        List<Course> courses = courseDAO.getCoursesBySeller(-1);
        assertNotNull(courses);
        assertTrue(courses.isEmpty());
    }
}
