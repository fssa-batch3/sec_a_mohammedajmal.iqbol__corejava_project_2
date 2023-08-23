package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseMarkedPrice {

    private int validMarkedPrice;
    private int invalidMarkedPrice;

    @BeforeEach
    void setup() {
        validMarkedPrice = 1000;
        invalidMarkedPrice = -100;
    }

    @Test
    @Order(1)
    void testValidMarkedPrice() {
        try {
            assertTrue(CourseValidator.validateMarkedPrice(validMarkedPrice));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidMarkedPrice() {
        try {
            CourseValidator.validateMarkedPrice(invalidMarkedPrice);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course marked price. Please provide a valid price (e.g., 100 or 99.99).", e.getMessage());
        }
    }
}
