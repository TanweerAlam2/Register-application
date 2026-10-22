package com.example.register.domain;

public record RegistrationResult(boolean successful, String message, long userId) {
    public static RegistrationResult success(long userId) {
        return new RegistrationResult(true, "Registration completed successfully.", userId);
    }
    public static RegistrationResult failure(String message) {
        return new RegistrationResult(false, message, 0L);
    }
}