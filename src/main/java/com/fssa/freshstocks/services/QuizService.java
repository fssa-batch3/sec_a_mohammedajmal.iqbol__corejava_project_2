package com.fssa.freshstocks.services;

import java.sql.Timestamp;

import com.fssa.freshstocks.dao.QuizDAO;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.services.exception.ServiceException;

public class QuizService {

    public static void insertOrUpdateUserData(int userId, int streak, Timestamp quizStartTime, boolean answeredToday) throws ServiceException {
        try {
        	QuizDAO quizDAO = new QuizDAO();
        	quizDAO.insertOrUpdateUserData(userId, streak, quizStartTime, answeredToday);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
