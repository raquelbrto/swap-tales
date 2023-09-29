package com.imd.web.swaptales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	private final ReviewService reviewService;	
	
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping(value = "/list")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

	@GetMapping("/{id}")
	public Optional<Review> getReviewsById(@PathVariable Long id) {
	    return reviewService.getReviewsById(id);
	}	
}