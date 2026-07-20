package org.example.infrastructure.persistence;

import org.example.domain.model.Booking;
import org.example.domain.repository.BookingRepository;

import java.util.*;

public class InMemoryBookingRepository implements BookingRepository {
    private final Map<UUID, Booking> bookings = new HashMap<>();

    @Override
    public Booking save(Booking entity) {
        return bookings.put(entity.getId(), entity);
    }

    @Override
    public Optional<Booking> findById(UUID uuid) {
        return Optional.ofNullable(bookings.get(uuid));
    }

    @Override
    public List<Booking> findAll() {
        return List.copyOf(bookings.values());
    }

    @Override
    public boolean deleteById(UUID uuid) {
        Optional<Booking> booking = Optional.ofNullable(bookings.get(uuid));

        return bookings.remove(uuid, booking);
    }
}
