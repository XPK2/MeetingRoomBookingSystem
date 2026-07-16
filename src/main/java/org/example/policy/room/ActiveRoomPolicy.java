package org.example.policy.room;

import org.example.model.Room;

public interface ActiveRoomPolicy {
    void validate(Room room);
}
