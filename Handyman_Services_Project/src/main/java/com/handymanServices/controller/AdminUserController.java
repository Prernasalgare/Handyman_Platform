package com.handymanServices.controller;

import com.handymanServices.entity.User;
import com.handymanServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class AdminUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        userRepository.save(user);
        return ResponseEntity.ok("User updated successfully.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if (user.getRole().name().equals("ADMIN")) {
            return ResponseEntity.badRequest().body("Cannot delete ADMIN user.");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted.");
    }
} 

