package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import freshstocks.services.UserService;

public class TestDelete {

	public static void main(String[] args) {

		int userID = 20;
		
		// if (isDeleted = 1) then we have to consider that user is deleted
		final int isDeleted = 1;
	    UserService userService = new UserService();

	    try {
	        if (!userService.deleteUser(userID,isDeleted)) {
	            System.out.println("Delete User not successful!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Test
	void TestDeleteSuccess() throws freshstocks.services.exception.ServiceException {
		int userID = 11;
		int isDeleted = 1;
		UserService userService = new UserService();
        assertTrue(UserService.deleteUser(userID,isDeleted));
	}
	
	@Test
	void TestDeleteFail() throws freshstocks.services.exception.ServiceException {
		int userID = 1;
		int is_deleted = 1;
		UserService userService = new UserService();
        assertFalse(UserService.deleteUser(userID,is_deleted));
	}
	
}
