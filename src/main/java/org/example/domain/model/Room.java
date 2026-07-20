package org.example.domain.model;

import java.util.UUID;

public class Room {
    private UUID id;
    private String name;
    private int capacity;
    private boolean active;

    public Room(UUID id, String name, int capacity, boolean active) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Room capacity must be be more than 0");
        }

        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Room capacity must be be more than 0");
        }

        this.capacity = capacity;
    }

    public boolean getActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", active=" + active +
                '}';
    }
}
