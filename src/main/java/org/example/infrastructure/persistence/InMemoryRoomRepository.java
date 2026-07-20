package org.example.infrastructure.persistence;

import org.example.domain.model.Room;
import org.example.domain.repository.RoomRepository;

import java.util.*;

public class InMemoryRoomRepository implements RoomRepository {
    private final Map<UUID, Room> rooms = new HashMap<>();
    private final Map<String, UUID> names = new HashMap<>();

    @Override
    public Room save(Room entity) {
        Room room = rooms.put(entity.getId(), entity);
        names.put(entity.getName(), entity.getId());

        return room;
    }

    @Override
    public Optional<Room> findById(UUID uuid) {
        return Optional.ofNullable(rooms.get(uuid));
    }

    @Override
    public List<Room> findAll() {
        return List.copyOf(rooms.values());
    }

    @Override
    public boolean deleteById(UUID uuid) {
        Optional<Room> room = Optional.ofNullable(rooms.get(uuid));

        return rooms.remove(uuid, room);
    }

    public Optional<Room> findByName(String name) {
        UUID uuid = names.get(name);

        if (uuid == null) {
            throw new RuntimeException("No ID corresponding to the given name found");
        }

        return Optional.ofNullable(rooms.get(uuid));
    }

    @Override
    public List<Room> findByActiveTrueAndCapacityGreaterThanEqual(int minimumCapacity) {
        List<Room> roomList = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getActive() && room.getCapacity() >= minimumCapacity) {
                roomList.add(room);
            }
        }

        return roomList;
    }
}
