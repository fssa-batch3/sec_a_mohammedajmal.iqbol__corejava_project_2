package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
        // This should not throw an exception
        assertDoesNotThrow(() -> CourseValidator.validateLanguage(validLanguage));
    }

    @Test
    @Order(2)
    void testInvalidLanguage() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateLanguage(invalidLanguage));
    }

    @Test
    @Order(3)
    void testEmptyLanguage() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateLanguage(emptyLanguage));
    }
}
