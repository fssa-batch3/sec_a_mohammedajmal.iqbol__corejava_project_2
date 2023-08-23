package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;


class TestValidateCourseLanguage {

    private String validLanguage;
    private String invalidLanguage;
    private String emptyLanguage;

    @BeforeEach
    void setup() {
        validLanguage = "English";
        invalidLanguage = "India500";
        emptyLanguage = " ";
    }

    @Test
    @Order(1)
    void testValidLanguage() {
        try {
            assertTrue(CourseValidator.validateLanguage(validLanguage));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidLanguage() {
        try {
            CourseValidator.validateLanguage(invalidLanguage);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course language. Course languages must be 3 to 30 characters long and may include letters and spaces.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmptyLanguage() {
        try {
            CourseValidator.validateLanguage(emptyLanguage);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course language. Course languages must be 3 to 30 characters long and may include letters and spaces.", e.getMessage());
        }
    }
}
