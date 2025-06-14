package com.handymanServices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handymanServices.entity.Handyman1;
import com.handymanServices.entity.Review;
import com.handymanServices.repository.Handyman1Repository;
import com.handymanServices.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private Handyman1Repository handymanRepo;

    public Review saveReviewAndUpdateRating(Review review) {
        Optional<Handyman1> optional = handymanRepo.findByNameIgnoreCase(review.getHandymanName());

        if (optional.isPresent()) {
            Handyman1 handyman = optional.get();

            int newCount = handyman.getReviewsCount() + 1;
            double newRating = ((handyman.getRating() * handyman.getReviewsCount()) + review.getRating()) / newCount;

            handyman.setRating(newRating);
            handyman.setReviewsCount(newCount);
            handymanRepo.save(handyman);

            return reviewRepo.save(review);
        } else {
            throw new RuntimeException("Handyman not found");
        }
    }

    public List<Review> getLatestReviews() {
        return reviewRepo.findTop5ByOrderByIdDesc();
    }

    public List<Handyman1> getAllHandymen() {
        return handymanRepo.findAll();
    }
    
    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }
    
    public Review updateReview(Long id, Review updatedReview) {
        Review existing = reviewRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setUserName(updatedReview.getUserName());
            existing.setHandymanName(updatedReview.getHandymanName());
            existing.setRating(updatedReview.getRating());
            existing.setReview(updatedReview.getReview());

            // Update other fields as needed
            return reviewRepo.save(existing);
        }
        return null;
    }
    
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).orElse(null);
    }

    
    
}
    
