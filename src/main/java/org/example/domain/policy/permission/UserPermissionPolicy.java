package org.example.domain.policy.permission;

import org.example.domain.model.Booking;
import org.example.domain.model.User;

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
        return booking.getUser().equals(user);
    }
}
