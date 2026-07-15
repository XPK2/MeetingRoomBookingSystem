package org.example;

import org.example.model.Booking;
import org.example.model.Room;
import org.example.model.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "a@gmail.com", "Nguyen Van A", "ADMIN");
        User user2 = new User(2, "b@gmail.com", "Nguyen Van B", "USER");
        User user3 = new User(3, "c@gmail.com", "Nguyen Van C", "USER");

        Room room1 = new Room(1, "Room 1", 5, true);
        Room room2 = new Room(2, "Room 2", 10, false);
        Room room3 = new Room(3, "Room 3", 15, true);

        Booking booking1 = new Booking(1, 1, 1, "Hop noi bo 1", "10:30", "11:30", "APPROVED");
        Booking booking2 = new Booking(1, 2, 2, "Hop noi bo 2", "15:00", "16:30", "PENDING");
        Booking booking3 = new Booking(1, 3, 3, "Hop noi bo 3", "08:00", "09:00", "APPROVED");
        Booking booking4 = new Booking(1, 1, 1, "Hop noi bo 4", "10:30", "11:30", "CANCELLED");
        Booking booking5 = new Booking(1, 2, 2, "Hop noi bo 5", "10:30", "11:30", "CANCELLED");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);

        System.out.println(booking1);
        System.out.println(booking2);
        System.out.println(booking3);
        System.out.println(booking4);
        System.out.println(booking5);
    }
}