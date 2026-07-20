package org.example;

import org.example.domain.model.*;
import org.example.domain.policy.booking.BookingTimePolicy;
import org.example.domain.policy.booking.DefaultBookingTimePolicy;
import org.example.domain.policy.permission.PermissionPolicy;
import org.example.domain.policy.permission.PermissionPolicyFactory;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(UUID.randomUUID(), "a@gmail.com", "Nguyen Van A", UserRole.ADMIN);
        User user2 = new User(UUID.randomUUID(), "b@gmail.com", "Nguyen Van B", UserRole.USER);
        User user3 = new User(UUID.randomUUID(), "c@gmail.com", "Nguyen Van C", UserRole.USER);

        Room room1 = new Room(UUID.randomUUID(), "Room 1", 5, true);
        Room room2 = new Room(UUID.randomUUID(), "Room 2", 10, false);
        Room room3 = new Room(UUID.randomUUID(), "Room 3", 15, true);

        Booking booking1 = new Booking(UUID.randomUUID(), user1, room1, "Hop noi bo 1", new TimeRange(LocalDateTime.of(2026, 7, 16, 16, 30), LocalDateTime.of(2026, 7, 16, 17, 30)), BookingStatus.APPROVED);
        Booking booking2 = new Booking(UUID.randomUUID(), user2, room2, "Hop noi bo 2", new TimeRange(LocalDateTime.of(2026, 7, 15, 15, 0), LocalDateTime.of(2026, 7, 15, 16, 30)), BookingStatus.PENDING);
        Booking booking3 = new Booking(UUID.randomUUID(), user3, room3, "Hop noi bo 3", new TimeRange(LocalDateTime.of(2026, 7, 15, 8, 0), LocalDateTime.of(2026, 7, 15, 9, 0)), BookingStatus.APPROVED);
        Booking booking4 = new Booking(UUID.randomUUID(), user1, room1, "Hop noi bo 4", new TimeRange(LocalDateTime.of(2026, 7, 15, 10, 30), LocalDateTime.of(2026, 7, 15, 11, 30)), BookingStatus.CANCELLED);
        Booking booking5 = new Booking(UUID.randomUUID(), user2, room2, "Hop noi bo 5", new TimeRange(LocalDateTime.of(2026, 7, 15, 10, 30), LocalDateTime.of(2026, 7, 15, 11, 30)), BookingStatus.CANCELLED);


        // Day 1
//        System.out.println(user1);
//        System.out.println(user2);
//        System.out.println(user3);
//
//        System.out.println(room1);
//        System.out.println(room2);
//        System.out.println(room3);
//
//        System.out.println(booking1);
//        System.out.println(booking2);
//        System.out.println(booking3);
//        System.out.println(booking4);
//        System.out.println(booking5);


        // Day 2

//        User user1 = new User(1, "a@gmail.com", "Nguyen Van A", UserRole.ADMIN);
//        System.out.println("Create user 1 successfully will all valid inputs" + user1);

//        User user2 = new User(2, null, "Nguyen Van A", UserRole.ADMIN);

//        User user3 = new User(3, "a@gmail.com", "Nguyen Van A", UserRole.ADMIN);
//        user3.setEmail(null);

//        Room room1 = new Room(1, "Room 1", 0, true);

//        Room room2 = new Room(2, "Room 2", 5, true);
//        room2.setCapacity(-1);

//        Room room3 = new Room(3, "Room 3", 5, true);
//        room3.deactivate();
//        System.out.println(room3.getActive());

//        Room room4 = new Room(4, "Room 4", 5, false);
//        room4.activate();
//        System.out.println(room4.getActive());

//        Booking booking1 = new Booking(1, 1, 1, "Hop noi bo 1", new TimeRange(null, LocalDateTime.of(2026, 7, 15, 11, 30)), BookingStatus.APPROVED);

//        Booking booking2 = new Booking(2, 1, 1, "Hop noi bo 2", new TimeRange(LocalDateTime.of(2026, 7, 15, 10, 30), null), BookingStatus.APPROVED);

//        Booking booking3 = new Booking(3, 1, 1, "Hop noi bo 3", new TimeRange(LocalDateTime.of(2026, 7, 15, 10, 30), LocalDateTime.of(2026, 7, 15, 9, 30)), BookingStatus.APPROVED);

//        Booking booking4 = new Booking(4, 1, 1, "Hop noi bo 4", new TimeRange(LocalDateTime.of(2026, 7, 15, 10, 30), LocalDateTime.of(2026, 7, 15, 11, 30)), BookingStatus.CANCELLED);
//        booking4.setStatus(BookingStatus.APPROVED);


        PermissionPolicyFactory policyFactory = new PermissionPolicyFactory();
        PermissionPolicy permissionPolicy = policyFactory.getPolicy(user1);
        
        if (permissionPolicy.canCancelBooking(user1, booking1)) {
            System.out.println("Cancel booking 1");
        }
        else {
            System.out.println("Cannot cancel booking 1");
        }

        permissionPolicy = policyFactory.getPolicy(user2);

        if (permissionPolicy.canCancelBooking(user2, booking2)) {
            System.out.println("Cancel booking 2");
        }
        else {
            System.out.println("Cannot cancel booking 2");
        }

        BookingTimePolicy bookingTimePolicy = new DefaultBookingTimePolicy();

        bookingTimePolicy.validate(user1, booking1);
        System.out.println("Booking time policy apply successfully");
    }
}