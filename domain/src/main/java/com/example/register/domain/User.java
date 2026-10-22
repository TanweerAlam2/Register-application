package com.example.register.domain;

import java.time.LocalDateTime;

public record User(long id, String fullName, String email, String passwordHash, LocalDateTime createdAt) {
    public User(String fullName, String email, String passwordHash) {
        this(0L, fullName, email, passwordHash, LocalDateTime.now());
    }
}