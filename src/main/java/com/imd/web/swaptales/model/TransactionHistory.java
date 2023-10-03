package com.imd.web.swaptales.model;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class TransactionHistory extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

	@Column
	private Date dateTransaction;
}
