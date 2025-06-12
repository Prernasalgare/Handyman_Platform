package com.handymanServices.service;

import com.handymanServices.dto.*;
import com.handymanServices.entity.*;
import com.handymanServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<?> register(RegisterRequest req) {
        if (req.getRole() == Role.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Admin registration is not allowed.");
        }

        if (userRepo.existsByUsername(req.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }

        User user = new User(req.getName(), req.getEmail(), req.getPhone(), req.getUsername(), req.getPassword(), req.getRole());
        userRepo.save(user);

        return ResponseEntity.ok("Registered successfully!");
    }

    public ResponseEntity<?> login(LoginRequest req) {
        Optional<User> userOpt = userRepo.findByUsername(req.getUsername());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }

        User user = userOpt.get();
        if (!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }

        return ResponseEntity.ok(new UserResponse(user.getId(), user.getUsername(), user.getRole().name()));
    }
}
