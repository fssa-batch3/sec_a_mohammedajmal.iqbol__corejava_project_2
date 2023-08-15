package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.CommentDAO;
import com.fssa.freshstocks.dao.CourseDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.CourseService;
import com.fssa.freshstocks.validation.exception.InvalidUserException;
import com.fssa.freshstocks.services.exception.*;

public class TestReadCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course(4);
		CourseDAO c = new CourseDAO();
		CourseService courseService = new CourseService();
		List<Course> cleanedEntries = null;
		try {
			cleanedEntries = courseService.listCourse(course1);
			for(Course course2 : cleanedEntries) {
				System.out.println(course2);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testGetAllCoursesSuccess() {
		CourseDAO c = new CourseDAO();
		Course course1 = new Course(4);
		CourseService courseService = new CourseService();
		List<Course> cleanedEntries = null;
		try {
			cleanedEntries = courseService.listCourse(course1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(cleanedEntries.isEmpty()) {
			System.out.println("Courses Doesn't Exist!");
		}
		assertTrue(cleanedEntries.size() > 0);
	}

	@Test
	void testGetAllCoursesInvalid() {
		CourseDAO c = new CourseDAO();
		Course course1 = new Course(1);
		CourseService courseService = new CourseService();
		List<Course> cleanedEntries = null;
		try {
			cleanedEntries = courseService.listCourse(course1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(cleanedEntries.isEmpty()) {
			System.out.println("Courses Doesn't Exist!");
		}
		assertFalse(!cleanedEntries.isEmpty());
	}

	@Test
	void testGetAllCoursesNull() {
		CourseDAO c = new CourseDAO();
		List<Course> cleanedEntries = null;
		assertNull(cleanedEntries);
	}
}
