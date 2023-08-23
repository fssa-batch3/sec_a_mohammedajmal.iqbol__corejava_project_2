package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        try {
            assertTrue(CourseValidator.validateCompanyName(validCompanyName));
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidCompanyName() {
        try {
            CourseValidator.validateCompanyName(invalidCompanyName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course company name. Company names must be 3 to 100 characters long and may include letters and spaces.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmptyCompanyName() {
        try {
            CourseValidator.validateCompanyName(emptyCompanyName);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course company name. Company names must be 3 to 100 characters long and may include letters and spaces.", e.getMessage());
        }
    }
}
