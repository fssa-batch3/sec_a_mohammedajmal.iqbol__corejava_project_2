package com.fssa.freshstocks.services;

import java.sql.Timestamp;
import java.util.List;

import com.fssa.freshstocks.dao.QuizDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.LeaderboardEntry;
import com.fssa.freshstocks.services.exception.ServiceException;

public class QuizService {

	/**
	 * Inserts or updates user data related to the quiz.
	 *
	 * @param userId The unique identifier of the user.
	 * @param streak The user's current streak in the quiz.
	 * @param quizStartTime The timestamp indicating when the quiz started.
	 * @param answeredToday A boolean indicating if the user has answered today's quiz.
	 * @throws ServiceException If an error occurs during the operation.
	 */
    public static void insertOrUpdateUserData(int userId, int streak, Timestamp quizStartTime, boolean answeredToday) throws ServiceException {
        try {
        	QuizDAO quizDAO = new QuizDAO();
        	quizDAO.insertOrUpdateUserData(userId, streak, quizStartTime, answeredToday);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    /**
     * Retrieves leaderboard data containing information about top performers.
     *
     * @return A list of leaderboard entries representing top performers.
     * @throws ServiceException If an error occurs during the retrieval process.
     */
    public static List<LeaderboardEntry> getLeaderboardData() throws ServiceException {
    	try {
    		QuizDAO quizDAO = new QuizDAO();
    		return quizDAO.getLeaderboardDatas();
    	} catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
}
