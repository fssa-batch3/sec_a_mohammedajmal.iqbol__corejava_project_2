package com.fssa.freshstocks.model;

import java.sql.Timestamp;

public class CourseProgressData {
    private double totalProgress;
    private Timestamp latestModifiedAt;

    /**
     * Constructs a CourseProgressData object with the specified total progress and latest modified timestamp.
     *
     * @param totalProgress The total progress in the course.
     * @param latestModifiedAt The timestamp indicating the latest modification.
     */
    public CourseProgressData(double totalProgress, Timestamp latestModifiedAt) {
        this.totalProgress = totalProgress;
        this.latestModifiedAt = latestModifiedAt;
    }

    // Getters and Setters
    public double getTotalProgress() {
        return totalProgress;
    }

    public Timestamp getLatestModifiedAt() {
        return latestModifiedAt;
    }
}

