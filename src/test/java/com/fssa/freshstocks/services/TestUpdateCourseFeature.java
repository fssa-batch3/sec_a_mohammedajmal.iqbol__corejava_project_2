package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

public class TestUpdateCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"20hrs", "Tamil", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Gowtham",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
		int courseID = 1;
		CourseService courseService = new CourseService();

		try {
			if (!courseService.updateCourse(course1, courseID)) {
				System.out.println("Update Course not successful! Error : Validation Failed Or Course Doesn't Exist");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testUpdateCourseSuccess() {
		CourseService courseService = new CourseService();
		Course course1 = new Course(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"20hrs", "Tamil", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Gowtham",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
		int courseID = 1;
		try {
			assertTrue(courseService.updateCourse(course1, courseID));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test // invalid because invalid image URL without https://
	void testUpdateCourseInvalid() {

		CourseService courseService = new CourseService();
		Course course1 = new Course(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"20hrs", "Tamil", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Gowtham",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis");
		int courseID = -1;
		try {
			assertFalse(courseService.updateCourse(course1, courseID));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}