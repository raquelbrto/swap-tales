package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.enums.AvailabilityStatus;
import com.imd.web.swaptales.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.ownerUser.id = :userId")
    List<Book> findByUserId(@Param("userId") Long userId);

    List<Book> findByAvailabilityStatus(@Param("availabilityStatus")AvailabilityStatus availabilityStatus);

    @Query("SELECT b " +
            "FROM Book b " +
            "LEFT JOIN FETCH b.reviews r " +
            "ORDER BY (SELECT AVG(rr.stars) FROM Review rr WHERE rr.book = b) DESC, " +
            "         (SELECT COUNT(rrr) FROM Review rrr WHERE rrr.book = b) DESC, " +
            "         (SELECT MAX(rrrr.reviewDate) FROM Review rrrr WHERE rrrr.book = b) DESC")
    List<Book> listTopBooks();

    //Query("SELECT b FROM Book b ORDER BY b.reviews.size DESC")
    //List<Book> findAllOrderedByReviewCount();
}
