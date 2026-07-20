package org.example.domain.repository;

import org.example.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Repository<UUID, User> {
    Optional<User> findByEmail(String email);
}
