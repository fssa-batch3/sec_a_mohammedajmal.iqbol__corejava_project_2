package com.fssa.freshstocks.services;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

class TestCreateCourseFeature {

    private CourseService courseService;
    private long nanotime;

    @BeforeEach
    void setup() {
        courseService = new CourseService();
        nanotime = System.nanoTime();
    }

    @Test
    @Order(1)
    void testCreateCourseSuccess() {
    	Course course1 = new Course("Course" + nanotime,
    	        "https://example.com/image1.png",
    	        "10hrs", "English", 5000, 2000,
    	        "the course gives you the fair idea about how to start trading and become a day trader", "Ajmalll",
    	        "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4);
        try {
            assertTrue(courseService.registerCourse(course1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testCreateCourseInvalid() {
        Course course1 = new Course("chart patterns course",
                "example.com/image1.png",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmall",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 1);
        try {
            assertFalse(courseService.registerCourse(course1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void testCreateCourseNull() {
        Course course1 = null;

        assertThrows(NullPointerException.class, () -> {
            courseService.registerCourse(course1);
        });
    }
}
