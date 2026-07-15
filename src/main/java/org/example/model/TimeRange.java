package org.example.model;

import java.time.LocalDateTime;

public record TimeRange(LocalDateTime startTime, LocalDateTime endTime) {
    public TimeRange {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start time and end time must not be null");
        }
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }
}
