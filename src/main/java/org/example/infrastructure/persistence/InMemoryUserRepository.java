package org.example.infrastructure.persistence;

import org.example.domain.model.User;
import org.example.domain.repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private final Map<UUID, User> users = new HashMap<>();
    private final Map<String, UUID> emails = new HashMap<>();

    @Override
    public User save(User entity) {
        User user = users.put(entity.getId(), entity);

        if (emails.containsKey(entity.getEmail())) {
            throw new RuntimeException("Duplicated email");
        }

        emails.put(entity.getEmail(), entity.getId());

        return user;
    }

    @Override
    public Optional<User> findById(UUID uuid) {
        return Optional.ofNullable(users.get(uuid));
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(users.values());
    }

    @Override
    public boolean deleteById(UUID uuid) {
        Optional<User> user = Optional.ofNullable(users.get(uuid));

        return users.remove(uuid, user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        UUID uuid = emails.get(email);

        if (uuid == null) {
            throw new RuntimeException("No ID corresponding to the given email found");
        }

        return Optional.ofNullable(users.get(uuid));
    }
}
