package com.handymanServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handymanServices.entity.Booking;
import com.handymanServices.repository.BookingRepository;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

 // CREATE
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    
 // READ ALL
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // READ BY ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setName(updatedBooking.getName());
            existingBooking.setEmail(updatedBooking.getEmail());
            existingBooking.setService(updatedBooking.getService());
            existingBooking.setDate(updatedBooking.getDate());
            return bookingRepository.save(existingBooking);
        }
        return null;
    }

    // DELETE
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
