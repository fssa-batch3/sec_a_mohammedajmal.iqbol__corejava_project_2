package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;

public class CourseDAOTest {
    private CourseDAO courseDAO;
    private long nanotime;

    @BeforeEach
    public void setUp() {
        // Initialize the DAO or use dependency injection
        courseDAO = new CourseDAO();
        nanotime = System.nanoTime();
    }

    @Test
    void testSameNameExistWithMatchingName() throws DAOException {
        // Arrange
    	Course course1 = new Course("stock analysis course",
    	        "https://example.com/image1.png",
    	        "10hrs", "English", 5000, 2000,
    	        "the course gives you the fair idea about how to start trading and become a day trader", "Ajmalll",
    	        "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4);

        // Act
        boolean result = courseDAO.sameNameExist(course1);

        // Assert
        assertTrue(result); // Expecting a match
    }

    @Test
    void testSameNameExistWithNonMatchingName() throws DAOException {
        // Arrange
    	Course course1 = new Course("Course" + nanotime,
    	        "https://example.com/image1.png",
    	        "10hrs", "English", 5000, 2000,
    	        "the course gives you the fair idea about how to start trading and become a day trader", "Ajmalll",
    	        "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4);

        // Act
        boolean result = courseDAO.sameNameExist(course1);

        // Assert
        assertFalse(result); // Expecting no match
    }
}
