package com.fssa.freshstocks.model;

import java.sql.Timestamp;

public class CourseProgressData {
    private double totalProgress;
    private Timestamp latestModifiedAt;

    public CourseProgressData(double totalProgress, Timestamp latestModifiedAt) {
        this.totalProgress = totalProgress;
        this.latestModifiedAt = latestModifiedAt;
    }

    public double getTotalProgress() {
        return totalProgress;
    }

    public Timestamp getLatestModifiedAt() {
        return latestModifiedAt;
    }
}

