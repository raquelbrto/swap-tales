package com.imd.web.swaptales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.Account;
import com.imd.web.swaptales.repository.ReviewRepository;

@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByUser(Account user) {
        return reviewRepository.findByUser(user);
    }
    
    public Optional<Review> getReviewsById(Long id) {
        return reviewRepository.findById(id);
    }
}
