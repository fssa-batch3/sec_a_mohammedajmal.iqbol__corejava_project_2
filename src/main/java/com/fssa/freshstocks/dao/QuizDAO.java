package com.fssa.freshstocks.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.LeaderboardEntry;
import com.fssa.freshstocks.utils.ConnectionUtil;
import com.fssa.freshstocks.utils.exception.DatabaseException;

public class QuizDAO {
	
	/**
	 * Inserts or updates user quiz data.
	 *
	 * @param userId The unique identifier of the user.
	 * @param streak The user's streak count in quizzes.
	 * @param quizStartTime The timestamp indicating the start time of the quiz.
	 * @param answeredToday A boolean indicating if the user has answered today's quiz.
	 * @throws DAOException If an error occurs during the insertion or update process.
	 */
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
    
     
    
    /**
     * Retrieves leaderboard data by performing an inner join query.
     *
     * @return A list of LeaderboardEntry objects containing leaderboard information.
     * @throws DAOException If an error occurs during the retrieval process.
     */
    public List<LeaderboardEntry> getLeaderboardDatas() throws DAOException {
        List<LeaderboardEntry> leaderboardData = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement statement = conn.prepareStatement(
                        "SELECT u.username, u.avatar_url, uqi.quiz_start_time, uqi.streak_count , u.gender " +
                        "FROM freshstocks u " +
                        "INNER JOIN user_quiz_info uqi ON u.user_id = uqi.user_id " +
                        "ORDER BY uqi.streak_count DESC")) {
        	
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String quizEndTime = resultSet.getString("quiz_start_time");
                String profileImg = resultSet.getString("avatar_url");
                String gender = resultSet.getString("gender");
                int streak = resultSet.getInt("streak_count");
                leaderboardData.add(new LeaderboardEntry(username, streak, gender,quizEndTime,profileImg));
            }
        } catch (SQLException | DatabaseException e) {
            throw new DAOException(e);
        }

        return leaderboardData;
    }


}
