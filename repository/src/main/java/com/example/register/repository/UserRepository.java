package com.example.register.repository;

import com.example.register.domain.User;
import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findByEmail(String email);
}