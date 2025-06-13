package com.handymanServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handymanServices.entity.Booking;
import com.handymanServices.repository.BookingRepository;

@RestController
@RequestMapping("/api/admin/bookings")
@CrossOrigin("*")
public class AdminBookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping
    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking b) {
        b.setId(id);
        return bookingRepo.save(b);
    }
}

