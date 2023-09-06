package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseTopSkills {

    private String validTopSkills;
    private String invalidTopSkills;
    private String emptyTopSkills;

    @BeforeEach
    void setup() {
        validTopSkills = "smart money concepts";
        invalidTopSkills = "number theory 12345";
        emptyTopSkills = " ";
    }

    @Test
    @Order(1)
    void testValidTopSkills() {
        try {
            CourseValidator.validateTopSkils(validTopSkills);
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidTopSkills() {
        try {
            CourseValidator.validateTopSkils(invalidTopSkills);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course top skills. Top skills must be 3 to 150 characters long and may include letters and spaces.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmptyTopSkills() {
        try {
            CourseValidator.validateTopSkils(emptyTopSkills);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course top skills. Top skills must be 3 to 150 characters long and may include letters and spaces.", e.getMessage());
        }
    }
}
