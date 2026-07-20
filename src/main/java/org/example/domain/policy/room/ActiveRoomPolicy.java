package org.example.domain.policy.room;

import org.example.domain.model.Room;

public interface ActiveRoomPolicy {
    void validate(Room room);
}
