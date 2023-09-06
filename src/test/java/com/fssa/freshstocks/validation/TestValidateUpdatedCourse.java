package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateUpdatedCourse {

    private Course validCourse;
    private Course InvalidCourseNull;
    private Course InvalidCourseName;
    private Course InvalidCourseImageURL;
    private Course InvalidCourseTiming;
    private Course InvalidCourseLanguage;
    private Course InvalidCourseMarkedPrice;
    private Course InvalidCourseSellingPrice;
    private Course InvalidCourseInstructorName;
    private Course InvalidCourseCompanyName;
    private Course InvalidCourseCompanyCategory;
    private Course InvalidCourseTopSkills;

    @BeforeEach
    void setup() {
        validCourse = new Course("https://example.com/course_image.jpg",
            "10hrs", "English", 5000, 2000,
            "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
            "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseNull = null;
        InvalidCourseImageURL = new Course(
                "//encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseTiming = new Course(
                "https://example.com/course_image.jpg",
                "10:00 hours", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseLanguage = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", " ", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseMarkedPrice = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", -5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseSellingPrice = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, -2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseInstructorName = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal234231",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseCompanyName = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                " ", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseCompanyCategory = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading & Finance", "learn core concepts SMC and Technical Analysis");
        InvalidCourseTopSkills = new Course("https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "technical & Analysis");
        
    }

    @Test
    @Order(1)
    void testValidUpdatedCourse() {
        try {
            CourseValidator.validateUpdatedCourse(validCourse);
        } catch (InvalidCourseException e) {
            e.printStackTrace();
            fail("Unexpected exception was thrown.");
        }
    }

    @Test
    @Order(2)
    void testInvalidUpdatedCourseNull() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseNull);
        });
    }

    @Test
    @Order(3)
    void testInvalidUpdatedCourseImageURL() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseImageURL);
        });
    }
    

    @Test
    @Order(4)
    void testInvalidUpdatedCourseTiming() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseTiming);
        });
    }

    @Test
    @Order(5)
    void testInvalidUpdatedCourseLanguage() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseLanguage);
        });
    }

    @Test
    @Order(6)
    void testInvalidUpdatedCourseMarkedPrice() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseMarkedPrice);
        });
    }

    @Test
    @Order(7)
    void testInvalidUpdatedCourseSellingPrice() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseSellingPrice);
        });
    }

    @Test
    @Order(8)
    void testInvalidCourseInstructorName() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseInstructorName);
        });
    }

    @Test
    @Order(9)
    void testInvalidUpdatedCourseCompanyName() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseCompanyName);
        });
    }

    @Test
    @Order(10)
    void testInvalidUpdatedCourseCompanyCategory() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseCompanyCategory);
        });
    }

    @Test
    @Order(11)
    void testInvalidUpdatedCourseTopSkills() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateUpdatedCourse(InvalidCourseTopSkills);
        });
    }
}
