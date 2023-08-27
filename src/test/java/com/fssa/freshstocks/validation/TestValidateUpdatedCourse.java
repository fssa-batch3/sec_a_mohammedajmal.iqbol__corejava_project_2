package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateUpdatedCourse {

    private Course validUpdatedCourse;

    @BeforeEach
    void setup() {
        validUpdatedCourse = new Course(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
            "10hrs", "English", 5000, 2000,
            "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
            "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
    }

    @Test
    @Order(1)
    void testValidUpdatedCourse() {
        try {
            assertTrue(CourseValidator.validateUpdatedCourse(validUpdatedCourse));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidUpdatedCourseWithNull() {
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateUpdatedCourse(null));
    }
}
