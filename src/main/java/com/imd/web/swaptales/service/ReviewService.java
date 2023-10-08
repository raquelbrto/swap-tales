package com.imd.web.swaptales.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;
import com.imd.web.swaptales.repository.ReviewRepository;

public interface ReviewService {

    public Review create(Review review);
    
    public List<Review> getAllReviews();
    

     List<Review> getReviewsByUser(User user);
    
    public Optional<Review> getReviewsById(Long id);
}
