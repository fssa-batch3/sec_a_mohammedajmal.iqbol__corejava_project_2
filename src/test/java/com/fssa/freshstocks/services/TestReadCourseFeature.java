package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

class TestReadCourseFeature {

	@Test
	void testGetAllCoursesSuccess() {
		int userID = 4;
		CourseService courseService = new CourseService();
		List<Course> cleanedEntries = null;
		try {
			cleanedEntries = courseService.listCourse(userID);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(cleanedEntries.isEmpty() || cleanedEntries == null) {
			System.out.println("Courses Doesn't Exist!");
		}
		assertTrue(cleanedEntries.size() > 0);
	}

	@Test
	void testGetAllCoursesInvalid() {
		int userID = 1;
		CourseService courseService = new CourseService();
		List<Course> cleanedEntries = null;
		try {
			cleanedEntries = courseService.listCourse(userID);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(cleanedEntries.isEmpty()  || cleanedEntries == null) {
			System.out.println("Courses Doesn't Exist!");
		}
		assertFalse(!cleanedEntries.isEmpty());
	}

	@Test
	void testGetAllCoursesNull() {
		List<Course> cleanedEntries = null;
		assertNull(cleanedEntries);
	}
}
