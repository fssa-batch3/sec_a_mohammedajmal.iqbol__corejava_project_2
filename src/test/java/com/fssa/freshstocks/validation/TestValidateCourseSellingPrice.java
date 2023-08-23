package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseSellingPrice {

    private int validSellingPrice;
    private int invalidSellingPrice;

    @BeforeEach
    void setup() {
        validSellingPrice = 5000;
        invalidSellingPrice = -100;
    }

    @Test
    @Order(1)
    void testValidSellingPrice() {
        try {
            assertTrue(CourseValidator.validateSellingPrice(validSellingPrice));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidSellingPrice() {
        try {
            CourseValidator.validateSellingPrice(invalidSellingPrice);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course selling price. Please provide a valid price (e.g., 100 or 99.99).", e.getMessage());
        }
    }
}
