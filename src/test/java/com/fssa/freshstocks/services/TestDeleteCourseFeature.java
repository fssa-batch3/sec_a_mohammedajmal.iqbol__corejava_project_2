package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestDeleteCourseFeature {
	
    private CourseService courseService;
    private final int isDeleted = 1;

    @BeforeEach
    void setup() {
        courseService = new CourseService();
    }

    @Test
    @Order(1)
    void testDeleteCourseSuccess() {
        int courseID = 48;
        try {
            assertTrue(courseService.deleteCourse(courseID, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    } 

    @Test
    @Order(2)
    void testDeleteCourseFail() {
        int courseID = -1;
        try {
            assertFalse(courseService.deleteCourse(courseID, isDeleted));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
