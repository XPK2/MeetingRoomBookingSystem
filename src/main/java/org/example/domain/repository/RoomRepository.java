package org.example.domain.repository;

import org.example.domain.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends Repository<UUID, Room> {
    Optional<Room> findByName(String name);

    List<Room> findByActiveTrueAndCapacityGreaterThanEqual(int minimumCapacity);
}
