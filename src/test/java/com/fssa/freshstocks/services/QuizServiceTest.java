package com.fssa.freshstocks.services;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.model.LeaderboardEntry;
import com.fssa.freshstocks.services.QuizServiceTest;
import com.fssa.freshstocks.services.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;
import java.util.List;

public class QuizServiceTest {

    @Test
    void testInsertOrUpdateUserData() throws ServiceException {
        try {
            QuizService.insertOrUpdateUserData(12, 5, new Timestamp(System.currentTimeMillis()), true);
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    
    @Test
    void testInsertOrUpdateUserData_InvalidUserId() {
        // Assuming userId 0 is an invalid user ID
        assertThrows(ServiceException.class, () -> {
            QuizService.insertOrUpdateUserData(0, 5, new Timestamp(System.currentTimeMillis()), true);
        });
    }


    @Test
    void testGetLeaderboardData() throws ServiceException {
        try {
            List<LeaderboardEntry> leaderboardData = QuizService.getLeaderboardData();

            assertTrue(leaderboardData.size() > 0);
        } catch (ServiceException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
