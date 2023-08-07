package TestCourseCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.Course;
import freshstocks.services.CourseService;

public class TestCreateCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course("Stock Course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","10hrs","English","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Ajmal","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		CourseService courseService = new CourseService();

		try {
			if(!courseService.registerCourse(course1)) {
				System.out.println("Create Course not successful! Error : Validation Failed Or Course Already Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testCreateCourseSuccess() throws freshstocks.services.exception.ServiceException, ServiceException {
		CourseService courseService = new CourseService();
		Course course1 = new Course("SMC High Course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","10hrs","English","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Ajmal","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		assertTrue(courseService.registerCourse(course1));
	}

	@Test //invalid because invalid image URL without https://
	void testCreateCourseInvalid() {

		CourseService courseService = new CourseService();
		Course course1 = new Course("Stock Course","encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","10hrs","English","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Ajmal","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		try {
			assertFalse(courseService.registerCourse(course1));
		} catch (freshstocks.services.exception.ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testCreateCourseNull() throws freshstocks.services.exception.ServiceException {

		CourseService courseService = new CourseService();
		Course course1 = null;
		
		 assertThrows(freshstocks.services.exception.ServiceException.class, () -> {
		        courseService.registerCourse(course1);
		    });
	}
}
