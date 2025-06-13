package com.handymanServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.handymanServices.entity.Handyman1;
import com.handymanServices.entity.Review;
import com.handymanServices.service.ReviewService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5501") 
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/handymen")
    public List<Handyman1> getAllHandymen() {
        return reviewService.getAllHandymen();
    }

    @PostMapping("/reviews")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReviewAndUpdateRating(review);
    }

    @GetMapping("/reviews/latest")
    public List<Review> getLatestReviews() {
        return reviewService.getLatestReviews();
    }
    
 // DELETE Review by ID
    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
    
 // UPDATE a review
    @PutMapping("/reviews/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewService.updateReview(id, updatedReview);
    }
    
    @GetMapping("/reviews/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviews/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }


}
