package com.fssa.freshstocks.model;

public class LeaderboardEntry {
    private String name;
    private String gender;
    private int streak;
    private String quizEndTime;
    private String image;

    /**
     * Constructs a LeaderboardEntry object with the specified name, streak, gender, quiz end time, and User Profile image URL.
     *
     * @param name The name of the leaderboard entry.
     * @param streak The streak count of the user.
     * @param gender The gender of the user.
     * @param quizEndTime The end time of the quiz associated with the user.
     * @param image The URL of the user's profile image.
     */
    public LeaderboardEntry(String name, int streak, String gender, String quizEndTime, String image) {
        this.name = name;
        this.streak = streak;
        this.gender = gender;
        this.quizEndTime = quizEndTime;
        this.image = image;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQuizEndTime() {
		return quizEndTime;
	}

	public void setQuizEndTime(String quizEndTime) {
		this.quizEndTime = quizEndTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
        this.name = name;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }
}
