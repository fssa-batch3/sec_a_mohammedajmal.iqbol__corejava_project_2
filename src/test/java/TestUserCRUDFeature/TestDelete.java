package TestUserCRUDFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import freshstocks.services.UserService;

public class TestDelete {

	public static void main(String[] args) {

		String userEmail = "lakshmi12@gmail.com";
		
		// if (isDeleted = 1) then we have to consider that user is deleted
		final int isDeleted = 1;
	    UserService userService = new UserService();

	    try {
	        if (!userService.deleteUser(userEmail,isDeleted)) {
	            System.out.println("Delete User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Test
	void TestDeleteSuccess() throws freshstocks.services.exception.ServiceException {
		String userEmail = "lakshmi12@gmail.com";
		int isDeleted = 1;
		UserService userService = new UserService();
        assertTrue(UserService.deleteUser(userEmail,isDeleted));
	}
	
	@Test
	void TestDeleteFail() throws freshstocks.services.exception.ServiceException {
		String userEmail = "lakshmi120@gmail.com";
		int is_deleted = 1;
		UserService userService = new UserService();
        assertFalse(UserService.deleteUser(userEmail,is_deleted));
	}
	
}