package com.imd.web.swaptales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {

	private final ReviewService reviewService;	
	
	public ReviewRestController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@PostMapping(value = "/new")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Review create(@RequestBody Review review) {
		return reviewService.create(review);
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