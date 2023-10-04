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
            "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
            "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
	        "Intermediate Investing","Advanced Trading");
        InvalidCourseNull = null;
        InvalidCourseImageURL = new Course(
                "//encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseTiming = new Course(
                "https://example.com/course_image.jpg",
                "10:00 hours", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseLanguage = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", " ", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseMarkedPrice = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", -5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseSellingPrice = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, -2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseInstructorName = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal234231",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseCompanyName = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                " ", "Trading and Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseCompanyCategory = new Course(
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading & Finance", "learn core concepts SMC and Technical Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseTopSkills = new Course("https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "technical & Analysis","data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        
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
        assertThrows(NullPointerException.class, () -> {
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
