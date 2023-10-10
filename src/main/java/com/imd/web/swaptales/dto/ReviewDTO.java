package com.imd.web.swaptales.dto;

import com.imd.web.swaptales.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ReviewDTO{
    private Long id;
    private double stars;
    private int likes_count;
    private String text;
    private String reviewDate;
    private Long user;
    private Long book;


    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.stars = review.getStars();
        this.likes_count = review.getLikes_count();
        this.text = review.getText();
        this.reviewDate = review.getReviewDate();
        this.user = review.getUser().getId();
        this.book = review.getBook().getId();
    }
}
