package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import com.fssa.freshstocks.model.*;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestDeleteCourseFeature {

	@Test
	void TestDeleteCourseSuccess() {
		Course course = new Course(1,"stock courses");
		int isDeleted = 1;
		CourseService courseService = new CourseService();
		try {
			assertTrue(courseService.deleteCourse(course, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteCourseFail() {
		Course course = new Course(1,"stock cours");
		int isDeleted = 1;
		CourseService courseService = new CourseService();
		try {
			assertFalse(courseService.deleteCourse(course, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
