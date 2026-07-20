package org.example.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private UUID id;
    private User user;
    private Room room;
    private String title;
    private TimeRange timeRange;
    private BookingStatus status;

    public Booking(UUID id, User user, Room room, String title, TimeRange timeRange, BookingStatus bookingStatus) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.title = title;
        this.timeRange = timeRange;
        this.status = bookingStatus;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
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
                ", user=" + user +
                ", room=" + room +
                ", title='" + title + '\'' +
                ", timeRange=" + timeRange +
                ", status=" + status +
                '}';
    }
}