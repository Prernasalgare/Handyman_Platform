package com.handymanServices.controller;

import com.handymanServices.entity.Contact;
import com.handymanServices.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ResponseEntity<String> submitContactForm(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return ResponseEntity.ok("Contact form submitted successfully!");
    }
}
