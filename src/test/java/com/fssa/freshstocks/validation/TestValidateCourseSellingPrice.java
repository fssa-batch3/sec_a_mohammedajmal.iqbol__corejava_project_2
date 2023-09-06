package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseSellingPrice {

    @Test
    void testValidSellingPrice() {
        // No exception should be thrown for a valid selling price
        assertDoesNotThrow(() -> CourseValidator.validateSellingPrice(5000));
    }

    @Test
    void testInvalidSellingPrice() {
        // An exception should be thrown for an invalid selling price
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateSellingPrice(-100));
    }
}
