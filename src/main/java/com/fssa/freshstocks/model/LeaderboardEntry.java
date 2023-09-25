package com.fssa.freshstocks.model;

public class LeaderboardEntry {
    private String name;
    private String gender;
    private int streak;
    private String quizEndTime;
    private String image;

    // Constructor
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
