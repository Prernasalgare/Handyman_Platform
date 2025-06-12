package com.handymanServices.controller;

import com.handymanServices.entity.Handyman;
import com.handymanServices.repository.HandymanRepository;
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
}
