package com.imd.web.swaptales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.web.swaptales.model.Review;
import com.imd.web.swaptales.model.Account;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> findByUser(Account user);
}
