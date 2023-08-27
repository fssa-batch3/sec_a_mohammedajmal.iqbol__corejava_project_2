package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

class TestUpdateCourseFeature {

    private CourseService courseService;

    @BeforeEach
    void setup() {
        courseService = new CourseService();
    }

    @Test
    @Order(1)
    void testUpdateCourseSuccess() {
        Course course1 = new Course(
                "https://example.com/image1.png",
                "20hrs", "Tamil", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Gowtham",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        int courseID = 4;
        try {
            assertTrue(courseService.updateCourse(course1, courseID));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testUpdateCourseInvalid() {

        Course course1 = new Course(
                "example.com/image1.png",
                "20hrs", "Tamil", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Gowtham",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        int courseID = -1;
        try {
            assertFalse(courseService.updateCourse(course1, courseID));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
