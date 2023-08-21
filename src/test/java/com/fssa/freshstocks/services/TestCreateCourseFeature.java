package com.fssa.freshstocks.services;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Course;
import com.fssa.freshstocks.services.exception.*;

class TestCreateCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course("Funds Courses",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"10hrs", "English", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis",5);
		CourseService courseService = new CourseService();

		try {
			if (!courseService.registerCourse(course1)) {
				System.out.println("Create Course not successful! Error : Validation Failed Or Course Already Exist");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testCreateCourseSuccess() {
		CourseService courseService = new CourseService();
		Course course1 = new Course("SMC High Courses",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"10hrs", "English", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis",4);
		try {
			assertTrue(courseService.registerCourse(course1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test // invalid because invalid image URL without https://
	void testCreateCourseInvalid() {

		CourseService courseService = new CourseService();
		Course course1 = new Course("Stock Course",
				"encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU",
				"10hrs", "English", "5000", "2000",
				"the course gives you the fair idea about how to start trading and become a day trader", "Ajmal",
				"freshstocks", "Trading and Finance", "learn core concepts SMC and Technical Analysis",1);
		try {
			assertFalse(courseService.registerCourse(course1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testCreateCourseNull() {

		CourseService courseService = new CourseService();
		Course course1 = null;

		assertThrows(ServiceException.class, () -> {
			courseService.registerCourse(course1);
		});
	}
}
