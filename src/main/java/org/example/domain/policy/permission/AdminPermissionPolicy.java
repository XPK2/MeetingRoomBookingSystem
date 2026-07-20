package org.example.domain.policy.permission;

import org.example.domain.model.Booking;
import org.example.domain.model.User;

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
