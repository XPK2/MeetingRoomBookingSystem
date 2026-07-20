package org.example.domain.policy.permission;

import org.example.domain.model.Booking;
import org.example.domain.model.User;

public interface PermissionPolicy {
    boolean canCreateRoom(User user);
    boolean canUpdateRoom(User user);
    boolean canCancelBooking(User user, Booking booking);
}
