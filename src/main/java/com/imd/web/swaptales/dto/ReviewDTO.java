package com.imd.web.swaptales.dto;

import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;
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
    private Long author_review;
    private Long book;


    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.stars = review.getStars();
        this.likes_count = review.getLikes_count();
        this.text = review.getText();
        this.reviewDate = review.getReviewDate();
        this.author_review = review.getAuthor_review().getId();
        this.book = review.getBook().getId();;
    }
}
