package com.imd.web.swaptales.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.imd.web.swaptales.dto.ReviewDTO;
import com.imd.web.swaptales.util.exception.NotFoundException;
import org.antlr.v4.runtime.misc.NotNull;
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
    public List<ReviewDTO> findByUserId(Long user_id) {

        return  reviewRepository.findByUserId(user_id)
                .stream()
                .map(review -> new ReviewDTO(review.getId(), review.getStars(), review.getLikes_count(),review.getText(),review.getReviewDate(), review.getAuthor_review().getId(), review.getBook().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Review getReviewsById(Long id) {
        Review review = reviewRepository.getById(id);
        return review;
    }

    @Override
    public void delete(@NotNull Long id) {
        reviewRepository.delete(reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id)));
    }

    @Override
    public Review update(Long id, ReviewDTO reviewDTO) {
        return reviewRepository.findById(id)
                .map(reviewUp ->{
                    reviewUp.setStars(reviewDTO.getStars());
                    reviewUp.setLikes_count(reviewDTO.getLikes_count());
                    reviewUp.setText(reviewDTO.getText());
                    return reviewRepository.save(reviewUp);
                })
                .orElseThrow(() -> new NotFoundException(id));
    }
}
