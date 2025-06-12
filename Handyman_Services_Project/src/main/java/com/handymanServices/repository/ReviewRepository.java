package com.handymanServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.handymanServices.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findTop5ByOrderByIdDesc();
}
