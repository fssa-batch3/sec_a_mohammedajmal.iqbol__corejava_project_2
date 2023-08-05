package TestUserCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;

public class TestRegister {

	public static void main(String[] args) {

		User user1 = new User("Lakshmi_123","Female" ,"9500320194","2004-12-26", "lakshmi12@gmail.com","Lakshmi@123");
		UserService userService = new UserService();

		try {
			if(!userService.registerUser(user1)) {
				System.out.println("Registration not successful! Error : Validation Failed Or User Already Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testRegistrationSuccess() throws freshstocks.services.exception.ServiceException, ServiceException {
		UserService userService = new UserService();
		User user1 = new User("Lakshmi_123","Female" ,"9500320194","2004-12-26", "lakshmi12@gmail.com","Lakshmi@123");
		assertTrue(UserService.registerUser(user1));
	}

	@Test
	void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Lakshmi_123","Female" ,"9500320194","2004-12-26", "lakshmi12@gmail.com","Lakshmi123");
		try {
			assertFalse(UserService.registerUser(user1));
		} catch (freshstocks.services.exception.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		
		 assertThrows(NullPointerException.class, () -> {
		        userService.registerUser(user1);
		    });
	}

}