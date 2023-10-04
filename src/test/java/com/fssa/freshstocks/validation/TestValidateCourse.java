package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourse {

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
        validCourse = new Course("Stock Courses",
            "https://example.com/course_image.jpg",
            "10hrs", "English", 5000, 2000,
            "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
            "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
	        "Intermediate Investing","Advanced Trading");
        InvalidCourseNull = null;
        InvalidCourseName = new Course(" ",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseImageURL = new Course("Stock Courses",
                "//encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseTiming = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10:00 hours", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseLanguage = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", " ", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseMarkedPrice = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", -5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseSellingPrice = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, -2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseInstructorName = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal234231",
                "freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseCompanyName = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                " ", "Trading and Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseCompanyCategory = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading & Finance", "learn core concepts SMC and Technical Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        InvalidCourseTopSkills = new Course("Stock Courses",
                "https://example.com/course_image.jpg",
                "10hrs", "English", 5000, 2000,
                "the course gives you the fair idea about how to start trading and become a day trader by understanding the core concepts of stock market trading from scratch to end", "Ajmal",
                "freshstocks", "Trading and Finance", "technical & Analysis", 4,"data:video/mp4;base64,AAAAGGZ0eXBtcDQy",
    	        "data:video/mp4;base64,AAAAGGZ0eXBtcDQy","data:video/mp4;base64,AAAAGGZ0eXBtcDQy","Stock Investing Beginner",
    	        "Intermediate Investing","Advanced Trading");
        
    }

    @Test
    @Order(1)
    void testValidCourse() {
        try {
            CourseValidator.validateCourse(validCourse);
        } catch (InvalidCourseException e) {
            e.printStackTrace();
            fail("Unexpected exception was thrown.");
        }
    } 

    @Test
    @Order(2)
    void testInvalidCourseNull() {
        assertThrows(NullPointerException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseNull);
        });
    }

    @Test
    @Order(3)
    void testInvalidCourseName() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseName);
        });
    }

    @Test
    @Order(4)
    void testInvalidCourseImageURL() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseImageURL);
        });
    }
    

    @Test
    @Order(5)
    void testInvalidCourseTiming() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseTiming);
        });
    }

    @Test
    @Order(6)
    void testInvalidCourseLanguage() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseLanguage);
        });
    }

    @Test
    @Order(7)
    void testInvalidCourseMarkedPrice() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseMarkedPrice);
        });
    }

    @Test
    @Order(8)
    void testInvalidCourseSellingPrice() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseSellingPrice);
        });
    }

    @Test
    @Order(9)
    void testInvalidCourseInstructorName() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseInstructorName);
        });
    }

    @Test
    @Order(10)
    void testInvalidCourseCompanyName() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseCompanyName);
        });
    }

    @Test
    @Order(11)
    void testInvalidCourseCompanyCategory() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseCompanyCategory);
        });
    }

    @Test
    @Order(12)
    void testInvalidCourseTopSkills() {
        assertThrows(InvalidCourseException.class, () -> {
            CourseValidator.validateCourse(InvalidCourseTopSkills);
        });
    }
}
