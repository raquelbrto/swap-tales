package com.imd.web.swaptales.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO{
    private Long id;
    private Double stars;
    private Integer likesCount;
    private String text;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate reviewDate;
    private Long idAuthorReview;
    private Long idBook;


    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.stars = review.getStars();
        this.likesCount = review.getLikesCount();
        this.text = review.getText();
        this.reviewDate = review.getReviewDate();
        this.idAuthorReview = review.getAuthorReview().getId();
        this.idBook = review.getBook().getId();
    }

    public Review getEntity(){
        Review review = new Review();
        review.setReviewDate(reviewDate);
        review.setId(id);
        review.setStars(stars);
        review.setText(text);
        review.setLikesCount(likesCount);

        Book book = new Book();
        book.setId(idBook);
        review.setBook(book);

        User user = new User();
        user.setId(idAuthorReview);
        review.setAuthorReview(user);

        return review;
    }
}
