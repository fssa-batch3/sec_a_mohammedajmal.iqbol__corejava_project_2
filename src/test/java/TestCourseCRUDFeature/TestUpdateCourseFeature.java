package TestCourseCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.Course;
import freshstocks.services.CourseService;

public class TestUpdateCourseFeature {

	public static void main(String[] args) {

		Course course1 = new Course("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","20hrs","Tamil","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Gowtham","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		String name = "CandleSticks Course";
		CourseService courseService = new CourseService();

		try {
			if(!courseService.updateCourse(course1,name)) {
				System.out.println("Update Course not successful! Error : Validation Failed Or Course Doesn't Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testUpdateCourseSuccess() throws freshstocks.services.exception.ServiceException, ServiceException {
		CourseService courseService = new CourseService();
		Course course1 = new Course("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","20hrs","Tamil","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Gowtham","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		String name = "SMC High Course";
		assertTrue(courseService.updateCourse(course1, name));
	}
	
	@Test //invalid because invalid image URL without https://
	void testUpdateCourseInvalid() throws freshstocks.services.exception.ServiceException {

		CourseService courseService = new CourseService();
		Course course1 = new Course("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjRRyaiUBPcuRCnOz0_5tK9eZBjGgbBORTqA1vCil3RcZjI7fRHcEorMenJnLBNak1Y4E&usqp=CAU","20hrs","Tamil","5000","2000","the course gives you the fair idea about how to start trading and become a day trader","Gowtham","freshstocks","Trading and Finance","learn core concepts SMC and Technical Analysis");
		String name = "CandleSticks Cours";
		assertFalse(courseService.updateCourse(course1, name));
	}
	
}
