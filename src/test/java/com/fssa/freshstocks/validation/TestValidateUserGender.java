package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.validation.exception.InvalidUserException;


class TestValidateUserGender {

	@Test
	void testValidGender() {
		try {
			assertTrue(UserValidator.validateGender("male"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidGender() {
		try {
			UserValidator.validateGender("121323");
		} catch (InvalidUserException e) {
			assertEquals("Given Gender is not valid. Expected Input: male|female|others",e.getMessage());
		}
	}

	@Test
	void testGenderOthers() {
		try {
			UserValidator.validateGender("non-conforming");
		} catch (InvalidUserException e) {
			assertEquals("Given Gender is not valid. Expected Input: male|female|others",e.getMessage());
		}
	}
}
