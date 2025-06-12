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
}
