package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseTiming {

    private String validTiming;
    private String invalidTiming;
    private String emptyTiming;

    @BeforeEach
    void setup() {
        validTiming = "40hrs";
        invalidTiming = "12.50hrs";
    }

    @Test
    @Order(1)
    void testValidTiming() {
        try {
            CourseValidator.validateTiming(validTiming);
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidTiming() {
        try {
            CourseValidator.validateTiming(invalidTiming);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course timing. Please provide a valid timing format (e.g., 10hrs).", e.getMessage());
        }
    }
}
