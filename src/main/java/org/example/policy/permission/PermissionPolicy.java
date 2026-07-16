package org.example.policy.permission;

import org.example.model.Booking;
import org.example.model.User;

public interface PermissionPolicy {
    boolean canCreateRoom(User user);
    boolean canUpdateRoom(User user);
    boolean canCancelBooking(User user, Booking booking);
}
