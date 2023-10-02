package com.imd.web.swaptales.model;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public abstract class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Account account;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
	
	private Date date_transaction;
}
