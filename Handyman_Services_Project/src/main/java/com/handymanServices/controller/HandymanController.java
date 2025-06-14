package com.handymanServices.controller;

import com.handymanServices.entity.Handyman;
import com.handymanServices.repository.HandymanRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/handyman")
public class HandymanController {

    private final HandymanRepository handymanRepository;

    public HandymanController(HandymanRepository handymanRepository) {
        this.handymanRepository = handymanRepository;
    }

    @PostMapping
    public ResponseEntity<String> submitHandymanForm(@RequestBody Handyman handyman) {
        handymanRepository.save(handyman);
        return ResponseEntity.ok("Handyman application submitted successfully!");
    }
    @GetMapping
    public List<Handyman> getAll() {
        return handymanRepository.findAll();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Handyman> updateApplication(@PathVariable Long id, @RequestBody Handyman updated) {
        return handymanRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setPhone(updated.getPhone());
            existing.setSkills(updated.getSkills());
            existing.setAreas(updated.getAreas());
            return ResponseEntity.ok(handymanRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

   
    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveHandyman(@PathVariable Long id) {
        Optional<Handyman> optional = handymanRepository.findById(id);
        if (optional.isPresent()) {
            Handyman handyman = optional.get();
            handyman.setApproved(true);
            handymanRepository.save(handyman);
            return ResponseEntity.ok("Approved successfully");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	handymanRepository.deleteById(id);
    }
}
