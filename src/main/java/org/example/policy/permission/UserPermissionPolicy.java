package org.example.policy.permission;

import org.example.model.Booking;
import org.example.model.User;

public class UserPermissionPolicy implements PermissionPolicy{
    @Override
    public boolean canCreateRoom(User user) {
        return false;
    }

    @Override
    public boolean canUpdateRoom(User user) {
        return false;
    }

    @Override
    public boolean canCancelBooking(User user, Booking booking) {
        return booking.getUserId() == user.getId();
    }
}
