package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.fssa.freshstocks.validation.exception.InvalidUserException;

class TestValidateUserPassword {

    @ParameterizedTest
    @CsvSource({
            "Ajmal123, false",
            "Ajmal@@@@, false",
            "@1234567, false",
            "Ajmal@1, false",
            "ajmal@1234, false",
            "Ajmal@1234, true",
            "Ajmal@1123, true",
            "Ajmal@12, true"
    })
    void testPasswordValidation(String password, boolean expectedResult) {
        try {
			assertEquals(expectedResult, UserValidator.validatePassword(password));
		} catch (InvalidUserException e) {
			assertEquals("Invalid password. Passwords must meet specific complexity requirements.",e.getMessage());
		}
    }
}