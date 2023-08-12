package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.CourseService;
import com.fssa.freshstocks.validation.exception.InvalidUserException;
import com.fssa.freshstocks.services.exception.*;

public class TestReadCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course("stock courses");
		CourseDAO c = new CourseDAO();
		CourseService courseService = new CourseService();

		try {
			System.out.println(courseService.listCourse(course1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testListCourseEquals() {
		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = null;
		try {
			s = courseService.listCourse(course1);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
		String[] split = s.split(",");
		assertEquals("name: forex course", split[0].toLowerCase().trim());
	}

	@Test
	void testListCourseValid() {

		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = null;
		try {
			s = courseService.listCourse(course1);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
		String[] split = s.split(",");
		assertTrue(split[0].toLowerCase().trim().contains("name: forex course"));
	}

	@Test
	void testListCourseInvalid() {

		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = null;
		try {
			s = courseService.listCourse(course1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String[] split = s.split(",");
		assertFalse(split[0].toLowerCase().trim().contains("name: stock course"));
	}

	@Test
	void testListCourseNull() {

		CourseService courseService = new CourseService();
		Course course1 = null;

		assertThrows(NullPointerException.class, () -> {
			courseService.listCourse(course1);
		});
	}
}
