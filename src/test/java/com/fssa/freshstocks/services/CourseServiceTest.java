package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;

 class CourseServiceTest {
    private CourseService courseService;

    @BeforeEach
     void setUp() {
        // Initialize the service
        courseService = new CourseService();
    }

    @Test
     void testGetAllCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = courseService.getAllCourses();

        // Assert
        assertNotNull(actualCourses);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testGetFreeCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = courseService.getFreeCourses();

        // Assert
        assertNotNull(actualCourses);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testGetLatestCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = courseService.getLatestCourses();

        // Assert
        assertNotNull(actualCourses);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testGetCoursesFromCourseId() throws ServiceException {
        // Act
        Course course = courseService.getCoursesFromCourseId(2);

        // Assert
        assertNotNull(course);
        // Add more specific assertions based on your expectations
    }
    
    @Test
     void testInvalidGetAllCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = null;

        // Assert
        assertNull(actualCourses);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testInvalidGetFreeCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = null;

        // Assert
        assertNull(actualCourses);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testInvalidGetLatestCourses() throws ServiceException {
        // Act
        List<Course> actualCourses = null;

        // Assert
        assertNull(actualCourses);
        // Add more specific assertions based on your expectations
    }
}

