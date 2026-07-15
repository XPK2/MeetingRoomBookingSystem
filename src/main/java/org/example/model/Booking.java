package org.example.model;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private int userId;
    private int roomId;
    private String title;
    private TimeRange timeRange;
    private BookingStatus status;

    public Booking(int id, int userId, int roomId, String title, TimeRange timeRange, BookingStatus bookingStatus) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.title = title;
        this.timeRange = timeRange;
        this.status = bookingStatus;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return timeRange.startTime();
    }

    public LocalDateTime getEndTime() {
        return timeRange.endTime();
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        if (this.status == BookingStatus.CANCELLED) {
            throw new IllegalArgumentException("Cancelled booking's status cannot not be reset");
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", title='" + title + '\'' +
                ", timeRange=" + timeRange +
                ", status=" + status +
                '}';
    }
}