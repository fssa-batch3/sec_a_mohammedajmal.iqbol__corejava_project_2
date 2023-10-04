package com.fssa.freshstocks.services;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.dao.QuizDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.LeaderboardEntry;
import com.fssa.freshstocks.services.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.sql.Timestamp;
import java.util.List;

public class QuizDAOTest {


    @Test
    void testInsertOrUpdateUserData() throws DAOException {
        try {
            QuizDAO quizDAO = new QuizDAO();
            quizDAO.insertOrUpdateUserData(12, 5, new Timestamp(System.currentTimeMillis()), true);
        } catch (DAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
    


    @Test
    void testGetLeaderboardData() throws DAOException {
        try {
            List<LeaderboardEntry> leaderboardData = new QuizDAO().getLeaderboardDatas();

            assertTrue(leaderboardData.size() > 0);
        } catch (DAOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
