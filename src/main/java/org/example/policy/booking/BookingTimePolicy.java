package org.example.policy.booking;

import org.example.model.Booking;
import org.example.model.User;

public interface BookingTimePolicy {
    void validate(User user, Booking booking);
}
