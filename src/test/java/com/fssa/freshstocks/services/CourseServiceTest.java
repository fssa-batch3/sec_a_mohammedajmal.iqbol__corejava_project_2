package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.ServiceException;

class CourseServiceTest {
	private CourseService courseService;

	@BeforeEach
	void setUp() {
		courseService = new CourseService();
	}

	@Test
	void testGetAllCourses() throws ServiceException {
		List<Course> actualCourses = courseService.getAllCourses();
        assertNotNull(actualCourses);
	}

	@Test
	void testGetFreeCourses() throws ServiceException {
		List<Course> actualCourses = courseService.getFreeCourses();
		assertNotNull(actualCourses);
	}

	@Test
	void testGetLatestCourses() throws ServiceException {
		List<Course> actualCourses = courseService.getLatestCourses();
		assertNotNull(actualCourses);
	}

	@Test
	void testGetCoursesFromCourseId() throws ServiceException {
		Course course = courseService.getCoursesFromCourseId(2);
		assertNotNull(course);

	}

	@Test
	void testInvalidGetAllCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);

	}

	@Test
	void testInvalidGetFreeCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);

	}

	@Test
	void testInvalidGetLatestCourses() throws ServiceException {
		List<Course> actualCourses = null;
		assertNull(actualCourses);

	}
}
