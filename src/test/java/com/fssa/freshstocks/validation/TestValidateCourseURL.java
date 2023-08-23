package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseURL {

    private String validURL;
    private String invalidURL;
    private String emptyURL;

    @BeforeEach
    void setup() {
        validURL = "https://example.com/image1.png";
        invalidURL = "example.com";
        emptyURL = " ";
    }

    @Test
    @Order(1)
    void testValidURL() {
        try {
            assertTrue(CourseValidator.validateURL(validURL));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void testInvalidURL() {
        try {
            CourseValidator.validateURL(invalidURL);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course image URL. Please provide a valid HTTP or HTTPS URL.", e.getMessage());
        }
    }
    
    @Test
    @Order(3)
    void testEmptyURL() {
        try {
            CourseValidator.validateURL(emptyURL);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course image URL. Please provide a valid HTTP or HTTPS URL.", e.getMessage());
        }
    }
}
