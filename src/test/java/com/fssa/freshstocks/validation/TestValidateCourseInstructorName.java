package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseInstructorName {

    private String validInstructorName;
    private String invalidInstructorName;
    private String emptyInstructorName;

    @BeforeEach
    void setup() {
        validInstructorName = "Ajmal";
        invalidInstructorName = "Mohammed_Ajmal";
        emptyInstructorName = " ";
    }

    @Test
    @Order(1)
    void testValidInstructorName() {
        // This should not throw an exception
        assertDoesNotThrow(() -> CourseValidator.validateInsutructorName(validInstructorName));
    }

    @Test
    @Order(2)
    void testInvalidInstructorName() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateInsutructorName(invalidInstructorName));
    }

    @Test
    @Order(3)
    void testEmptyInstructorName() {
        // Expecting InvalidCourseException
        assertThrows(InvalidCourseException.class, () -> CourseValidator.validateInsutructorName(emptyInstructorName));
    }
}
