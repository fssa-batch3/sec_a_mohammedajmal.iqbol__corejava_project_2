package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;

public class TestLogin {

	public static void main(String[] args) {

		User user1 = new User("hacker4@gmail.com","Kotie@123");
		UserService userService = new UserService();

		try {
			userService.loginUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestValidUser() throws freshstocks.services.exception.ServiceException {
		User user1 = new User("hacker4@gmail.com","Kotie@123");
		assertTrue(UserService.loginUser(user1));
	}
	
	@Test
	void TestInValidUser() throws freshstocks.services.exception.ServiceException {
		User user1 = new User("hacker@gmail.com","Hacker@123");
		assertFalse(UserService.loginUser(user1));
	}
	
}
