package com.example.register.service;

import com.example.register.domain.*;
import com.example.register.repository.UserRepository;
import java.util.regex.Pattern;

public class RegistrationService {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegistrationResult register(RegistrationRequest request) {
        String fullName = request.fullName() == null ? "" : request.fullName().trim();
        String email = request.email() == null ? "" : request.email().trim().toLowerCase();
        String password = request.password() == null ? "" : request.password();

        if (fullName.length() < 2) return RegistrationResult.failure("Full name must contain at least 2 characters.");
        if (!EMAIL_PATTERN.matcher(email).matches()) return RegistrationResult.failure("Enter a valid email address.");
        if (password.length() < 8) return RegistrationResult.failure("Password must contain at least 8 characters.");
        if (userRepository.existsByEmail(email)) return RegistrationResult.failure("An account already exists for this email.");

        User saved = userRepository.save(new User(fullName, email, PasswordHasher.hash(password)));
        return RegistrationResult.success(saved.id());
    }
}