package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidCourseException;

class TestValidateCourseCategory {

    private String validCompanyCategory;
    private String invalidCompanyCategory;
    private String emptyCompanyCategory;

    @BeforeEach
    void setup() {
        validCompanyCategory = "Trading and Finance";
        invalidCompanyCategory = "&&&finance";
        emptyCompanyCategory = " ";
    }

    @Test
    @Order(1)
    void testValidCompanyCategory() {
        try {
            CourseValidator.validateCompanyCategory(validCompanyCategory);
            // If no exception is thrown, it's a valid company category
        } catch (InvalidCourseException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void testInvalidCompanyCategory() {
        try {
            CourseValidator.validateCompanyCategory(invalidCompanyCategory);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course company category. Company categories must be 3 to 100 characters long and may include letters and spaces.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testEmptyCompanyCategory() {
        try {
            CourseValidator.validateCompanyCategory(emptyCompanyCategory);
            fail("Expected InvalidCourseException was not thrown.");
        } catch (InvalidCourseException e) {
            assertEquals("Invalid course company category. Company categories must be 3 to 100 characters long and may include letters and spaces.", e.getMessage());
        }
    }
}
