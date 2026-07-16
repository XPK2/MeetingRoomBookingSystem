package org.example.policy.permission;

import org.example.model.Booking;
import org.example.model.User;

public class AdminPermissionPolicy implements PermissionPolicy {

    @Override
    public boolean canCreateRoom(User user) {
        return true;
    }

    @Override
    public boolean canUpdateRoom(User user) {
        return true;
    }

    @Override
    public boolean canCancelBooking(User user, Booking booking) {
        return true;
    }
}
