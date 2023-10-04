package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.ownerUser.id = :userId")
    List<Book> findByUserId(@Param("userId") Long userId);
}