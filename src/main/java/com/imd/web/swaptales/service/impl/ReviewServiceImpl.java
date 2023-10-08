package com.imd.web.swaptales.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.repository.ReviewRepository;
import com.imd.web.swaptales.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }
    
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByUser(User user) {
        return reviewRepository.findByUser(user);
    }
    
    @Override
    public Optional<Review> getReviewsById(Long id) {
        return reviewRepository.findById(id);
    }
}
