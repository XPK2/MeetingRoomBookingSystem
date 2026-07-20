package org.example.domain.policy.booking;

import org.example.domain.model.Booking;
import org.example.domain.model.User;

public interface BookingTimePolicy {
    void validate(User user, Booking booking);
}
