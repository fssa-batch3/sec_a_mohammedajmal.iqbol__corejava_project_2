package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        // This should not throw an exception
        assertDoesNotThrow(() -> CourseValidator.validateMarkedPrice(validMarkedPrice));
    }

    @Test
    @Order(2)
    void testInvalidMarkedPrice() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateMarkedPrice(invalidMarkedPrice));
    }
}
