package com.fssa.freshstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fssa.freshstocks.constants.CourseModuleConstants;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.utils.ConnectionUtil;
import com.fssa.freshstocks.utils.exception.DatabaseException;

public class QuizDAO {
	
    public void insertOrUpdateUserData(int userId, int streak, Timestamp quizStartTime, boolean answeredToday) throws DAOException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            // Check if a row with the given user_id already exists
            String checkIfExistsQuery = "SELECT COUNT(*) FROM user_quiz_info WHERE user_id = ?";
            try (PreparedStatement checkIfExistsStmt = connection.prepareStatement(checkIfExistsQuery)) {
                checkIfExistsStmt.setInt(1, userId);
                try (ResultSet resultSet = checkIfExistsStmt.executeQuery()) {
                    resultSet.next();
                    int rowCount = resultSet.getInt(1);

                    if (rowCount > 0) {
                        // If a row exists, update it
                        String updateQuery = "UPDATE user_quiz_info SET streak_count = ?, quiz_start_time = ?, answered_today = ? WHERE user_id = ?";
                        try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                            updateStmt.setInt(1, streak);
                            updateStmt.setTimestamp(2, quizStartTime);
                            updateStmt.setBoolean(3, answeredToday);
                            updateStmt.setInt(4, userId);
                            updateStmt.executeUpdate();
                        }
                    } else {
                        // If no row exists, insert a new one
                        String insertQuery = "INSERT INTO user_quiz_info (user_id, streak_count, quiz_start_time, answered_today) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                            insertStmt.setInt(1, userId);
                            insertStmt.setInt(2, streak);
                            insertStmt.setTimestamp(3, quizStartTime);
                            insertStmt.setBoolean(4, answeredToday);
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException | DatabaseException e) {
        	throw new DAOException(e);
        }
    }


}
