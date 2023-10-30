package com.imd.web.swaptales.model;

import java.util.Date;

import com.imd.web.swaptales.enums.StatusRental;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rental extends TransactionHistory{

	@Column
	private StatusRental status;

	@Column
	private Date dateReturn;

	@Column
	private Date dateRental;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "user_owner_id")
	private User bookOwner;

	@ManyToOne
	@JoinColumn(name = "user_borrower_id")
	private User borrower;


}
