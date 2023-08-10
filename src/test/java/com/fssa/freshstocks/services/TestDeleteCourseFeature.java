package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.services.CourseService;
import com.fssa.freshstocks.services.exception.ServiceException;

public class TestDeleteCourseFeature {

	@Test
	void TestDeleteCourseSuccess() throws DAOException {
		String name = "forex course";
		int isDeleted = 1;
		CourseService  courseService = new CourseService();
        try {
			assertTrue(courseService.deleteCourse(name,isDeleted));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void TestDeleteCourseFail() throws com.fssa.freshstocks.services.exception.ServiceException, DAOException {
		String name = "forex cours";
		int isDeleted = 1;
		CourseService  courseService = new CourseService();
        assertFalse(courseService.deleteCourse(name,isDeleted));
	}
}
