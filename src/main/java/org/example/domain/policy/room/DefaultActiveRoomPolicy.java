package org.example.domain.policy.room;

import org.example.domain.model.Room;

public class DefaultActiveRoomPolicy implements ActiveRoomPolicy{
    @Override
    public void validate(Room room) {
        if (!room.getActive()) {
            throw new RuntimeException("Only active rooms can be booked\n");
        }
    }
}
