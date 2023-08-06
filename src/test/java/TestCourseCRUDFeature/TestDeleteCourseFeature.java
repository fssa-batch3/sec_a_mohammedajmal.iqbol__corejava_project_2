package TestCourseCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import freshstocks.services.CourseService;

public class TestDeleteCourseFeature {

	@Test
	void TestDeleteCourseSuccess() throws freshstocks.services.exception.ServiceException {
		String name = "forex course";
		int isDeleted = 1;
		CourseService  courseService = new CourseService();
        assertTrue(courseService.deleteCourse(name,isDeleted));
	}
	
	@Test
	void TestDeleteCourseFail() throws freshstocks.services.exception.ServiceException {
		String name = "forex cours";
		int isDeleted = 1;
		CourseService  courseService = new CourseService();
        assertFalse(courseService.deleteCourse(name,isDeleted));
	}
}
