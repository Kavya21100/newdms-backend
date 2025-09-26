package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.SignupRequest;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignupRequest req) {
        String username = req.getUsername().trim();
        if (userRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        String encoded = passwordEncoder.encode(req.getPassword());
        // enforce uppercase role values
        String role = req.getRole() == null ? "CUSTOMER" : req.getRole().toUpperCase();
        User user = new User(username, encoded, role);
        userRepo.save(user);
    }

    public LoginResponse login(LoginRequest req) {
        Optional<User> uOpt = userRepo.findByUsername(req.getUsername());
        if (uOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        User user = uOpt.get();
        boolean matches = passwordEncoder.matches(req.getPassword(), user.getPassword());
        if (!matches) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return new LoginResponse(user.getUsername(), user.getRole(), "Login successful");
    }
}
