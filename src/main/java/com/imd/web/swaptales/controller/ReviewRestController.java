package com.imd.web.swaptales.controller;

import java.util.List;

import com.imd.web.swaptales.dto.ReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {

	private final ReviewService reviewService;	
	
	public ReviewRestController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<Review> create(@RequestBody Review review) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(review));
	}

	@GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
		try{
			List<Review> reviews = reviewService.getAllReviews();
			return ResponseEntity.ok(reviews);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
    }

	@GetMapping("/{id}")
		public ResponseEntity<Review>getReviewsById(@PathVariable Long id) {
		try{
			Review review = reviewService.getReviewsById(id);
			return ResponseEntity.ok(review);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Review>>  findByUserId(@PathVariable("id")  Long user_id) {
		try{
			List<Review> reviews = reviewService.findByUserId(user_id);
			return ResponseEntity.ok(reviews);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long review_id){
		try {
			reviewService.delete(review_id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return  ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> update(@PathVariable("id") Long review_id, ReviewDTO reviewDTO) {
		try {
			return ResponseEntity.ok(reviewService.update(review_id, reviewDTO));
		}catch (Exception e) {
			return  ResponseEntity.badRequest().build();
		}
	}
}