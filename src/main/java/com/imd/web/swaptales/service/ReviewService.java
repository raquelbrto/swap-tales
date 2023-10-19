package com.imd.web.swaptales.service;

import java.util.List;
import java.util.Optional;

import com.imd.web.swaptales.dto.ReviewDTO;
import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;

public interface ReviewService {

     Review create(Review review);

     List<Review> getAllReviews();


    List<ReviewDTO> findByUserId(Long user_id);
    
     Review getReviewsById(Long id);

    void delete(Long id);
    Review update(Long id, ReviewDTO reviewDTO);
}
