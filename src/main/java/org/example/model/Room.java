package org.example.model;

public class Room {
    private int id;
    private String name;
    private int capacity;
    private boolean active;

    public Room(int id, String name, int capacity, boolean active) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.capacity = capacity;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
