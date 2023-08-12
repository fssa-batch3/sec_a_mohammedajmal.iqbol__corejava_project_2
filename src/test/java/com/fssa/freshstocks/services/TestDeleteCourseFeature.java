package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.ServiceException;

public class TestDeleteCourseFeature {

	@Test
	void TestDeleteCourseSuccess() {
		String name = "forex course";
		int isDeleted = 1;
		CourseService courseService = new CourseService();
		try {
			assertTrue(courseService.deleteCourse(name, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteCourseFail() {
		String name = "forex cours";
		int isDeleted = 1;
		CourseService courseService = new CourseService();
		try {
			assertFalse(courseService.deleteCourse(name, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
