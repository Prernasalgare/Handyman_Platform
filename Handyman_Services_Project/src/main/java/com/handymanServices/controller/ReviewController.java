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
}
