package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidCourseName {

    private String validName;
    private String invalidName;
    private String emptyName;

    @BeforeEach
    void setup() {
        validName = "forex course";
        invalidName = "candles5_course";
        emptyName = " ";
    }

    @Test
    @Order(1)
    void testValidName() {
        try {
            assertTrue(CourseValidator.validateName(validName));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidName() {
        try {
            CourseValidator.validateName(invalidName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course name. Course names must be 3 to 30 characters long and may include letters, numbers, and spaces.", e.getMessage());
        }
    }
    
    @Test
    @Order(3)
    void testEmptyName() {
        try {
            CourseValidator.validateName(emptyName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course name. Course names must be 3 to 30 characters long and may include letters, numbers, and spaces.", e.getMessage());
        }
    }
}