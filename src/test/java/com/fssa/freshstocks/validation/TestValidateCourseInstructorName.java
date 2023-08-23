package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
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
        try {
            assertTrue(CourseValidator.validateInsutructorName(validInstructorName));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidInstructorName() {
        try {
            CourseValidator.validateInsutructorName(invalidInstructorName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course instructor name. Instructor names must be 3 to 50 characters long and may include letters and spaces.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmptyInstructorName() {
        try {
            CourseValidator.validateInsutructorName(emptyInstructorName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course instructor name. Instructor names must be 3 to 50 characters long and may include letters and spaces.", e.getMessage());
        }
    }
}
