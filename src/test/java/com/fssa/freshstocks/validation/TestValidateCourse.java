package com.fssa.freshstocks.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.validation.exception.*;

import org.junit.jupiter.api.Test;

class TestValidateCourse {

	@Test
	void testValidCourse() {
		Course course1 = new Course("Stock Courses",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"10hrs", "English", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis",4);
		try {
			assertTrue(CourseValidator.validateCourse(course1));
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidCourseWithNull() {
		assertThrows(InvalidCourseException.class, () -> CourseValidator.validateCourse(null));
	}
}
