package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


class TestValidateCoursePriceDifference {

    private int validMarkedPrice;
    private int validDiscountedPrice;

    @BeforeEach
    void setup() {
        validMarkedPrice = 1000;
        validDiscountedPrice = 500;
    }

    @Test
    @Order(1)
    void testValidCoursePriceDifference() {
        assertTrue(CourseValidator.validatePriceDifference(validMarkedPrice, validDiscountedPrice));
    }

    @Test
    @Order(2)
    void testInvalidCoursePriceDifference() {
        assertFalse(CourseValidator.validatePriceDifference(validMarkedPrice, 2500));
    }
}
