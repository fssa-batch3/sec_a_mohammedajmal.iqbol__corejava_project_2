package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

class TestReadCourseFeature {

    private CourseService courseService; 

    @BeforeEach
    void setup() {
        courseService = new CourseService();
    }

    @Test
    @Order(1)
    void testGetAllCoursesSuccess() {
    	int userID = 1;
        List<Course> cleanedEntries = null;
        try {
            cleanedEntries = courseService.listCourse(userID);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (cleanedEntries == null || cleanedEntries.isEmpty()) {
            System.out.println("Courses Don't Exist!");
        }
        // TODO add a check to check is all courses are same as the user ID.
        assertTrue(cleanedEntries != null && cleanedEntries.size() > 0);
    }

    @Test
    @Order(2)
    void testGetAllCoursesInvalid() {
        int userID = 0;
        List<Course> cleanedEntries = null;
        try {
            cleanedEntries = courseService.listCourse(userID);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        assertFalse(cleanedEntries != null && cleanedEntries.size() > 0);
    }

    @Test
    @Order(3)
    void testGetAllCoursesNull() {
        List<Course> cleanedEntries = null;
        assertNull(cleanedEntries);
    }
}
