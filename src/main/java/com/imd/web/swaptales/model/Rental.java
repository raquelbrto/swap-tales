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
}
