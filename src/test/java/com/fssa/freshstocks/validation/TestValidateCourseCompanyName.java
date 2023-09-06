package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseCompanyName {

    private String validCompanyName;
    private String invalidCompanyName;
    private String emptyCompanyName;

    @BeforeEach
    void setup() {
        validCompanyName = "freshstocks";
        invalidCompanyName = "freshworks_STS_Academy";
        emptyCompanyName = " ";
    }

    @Test
    @Order(1)
    void testValidCompanyName() {
        // This should not throw an exception
        assertDoesNotThrow(() -> CourseValidator.validateCompanyName(validCompanyName));
    }

    @Test
    @Order(2)
    void testInvalidCompanyName() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateCompanyName(invalidCompanyName));
    }

    @Test
    @Order(3)
    void testEmptyCompanyName() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateCompanyName(emptyCompanyName));
    }
}
