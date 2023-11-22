package com.imd.web.swaptales.model;

import java.time.LocalDate;
import java.util.Date;

import com.imd.web.swaptales.enums.StatusLoan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends TransactionHistory{

	@Column
	private StatusLoan status;

	@Column
	private LocalDate dateReturn;

	@Column
	private LocalDate expectedReturnDate;

	@Column
	private LocalDate dateLoan;
}
