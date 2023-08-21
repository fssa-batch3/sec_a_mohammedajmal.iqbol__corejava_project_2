package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import com.fssa.freshstocks.model.*;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.ServiceException;

class TestDeleteCourseFeature {
	
	public static final int isDeleted = 1;

	@Test
	void TestDeleteCourseSuccess() {
		int courseID = 4;
		CourseService courseService = new CourseService();
		try {
			assertTrue(courseService.deleteCourse(courseID, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void TestDeleteCourseFail() {
		int courseID = 1;
		CourseService courseService = new CourseService();
		try {
			assertFalse(courseService.deleteCourse(courseID, isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
