package com.imd.web.swaptales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Review {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private double stars; 
	    
	    private int like;
	    
	    private String text; 
	    
	    @Column(name = "review_date")
	    private String reviewDate; 

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private Account user; 
	    
	    @ManyToOne
	    @JoinColumn(name = "book_id")
	    private Book book;

}
