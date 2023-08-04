package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshstocks.model.User;
import freshstocks.services.UserService;

public class TestUpdate {
	
	public static void main(String[] args) {

	    User user1 = new User("Male", "9500320194", "2004-12-26");
	    int userID = 12;
	    UserService userService = new UserService();

	    try {
	        if (!userService.updateUser(user1, userID)) {
	            System.out.println("Update User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	
	@Test
	void TestUpdateSuccess() throws ServiceException, freshstocks.services.exception.ServiceException {
		User user1 = new User("Male","9500320194","2004-12-26");
		int userID = 12;
		UserService userService = new UserService();
		assertTrue(userService.updateUser(user1 , userID));
	}
	
	@Test
	void TestUpdateFail() throws ServiceException, freshstocks.services.exception.ServiceException {
		User user1 = new User("Male","9500320194","2004-12-26");
		//this userID doesn't exist so, it return false and our test cases is true
		int userID = 1;
		UserService userService = new UserService();
		assertFalse(userService.updateUser(user1 , userID));
	}

}
