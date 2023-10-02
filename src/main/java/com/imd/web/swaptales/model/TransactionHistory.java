package com.imd.web.swaptales.model;

import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public abstract class TransactionHistory {
	
	private long id;
	
	private Date date_due;
	
	private Date date_rental;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Account account;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
	
	
}
