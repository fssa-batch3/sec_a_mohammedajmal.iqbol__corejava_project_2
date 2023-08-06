package TestCourseCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;
import freshstocks.dao.CourseDAO;
import freshstocks.model.Course;
import freshstocks.services.CourseService;
import freshstocks.validation.exception.InvalidUserException;

public class TestReadCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course("CandleSticks Course");
			CourseDAO c = new CourseDAO();
		CourseService courseService = new CourseService();

		try {
			System.out.println(courseService.listCourse(course1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testListCourseEquals() throws freshstocks.services.exception.ServiceException, ServiceException, InvalidUserException {
		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = courseService.listCourse(course1);
		String[] split = s.split(",");
		assertEquals("name: forex course",split[0].toLowerCase().trim());
	}

	@Test
	void testListCourseValid() throws freshstocks.services.exception.ServiceException, InvalidUserException {

		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = courseService.listCourse(course1);
		String[] split = s.split(",");
		assertTrue(split[0].toLowerCase().trim().contains("name: forex course"));
	}
	
	@Test 
	void testListCourseInvalid() throws freshstocks.services.exception.ServiceException, InvalidUserException {

		CourseService courseService = new CourseService();
		Course course1 = new Course("forex course");
		String s = courseService.listCourse(course1);
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
