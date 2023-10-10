package com.imd.web.swaptales.service;

import java.util.List;
import java.util.Optional;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;

public interface ReviewService {

     Review create(Review review);
    
     List<Review> getAllReviews();
    

     List<Review> getReviewsByUser(User user);
    
     Review getReviewsById(Long id);
}
