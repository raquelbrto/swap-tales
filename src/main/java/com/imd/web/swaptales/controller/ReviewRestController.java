package com.imd.web.swaptales.controller;

import java.util.List;

import com.imd.web.swaptales.dto.ReviewDTO;
import com.imd.web.swaptales.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<Review>> getAllReviews() {
		try{
			List<Review> reviews = reviewService.getAllReviews();
			return ResponseEntity.ok(reviews);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}

    }

	@GetMapping("/{id}")
		public ResponseEntity<ReviewDTO> getReviewsById(@PathVariable Long id) {
		try{
			Review review = reviewService.getReviewsById(id);
			return ResponseEntity.ok(new ReviewDTO(review));
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<ReviewDTO>> findByUserId(@PathVariable("id")  Long user_id) {
		try{
			List<ReviewDTO>  reviews = reviewService.findByUserId(user_id);
			return ResponseEntity.ok(reviews);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}