package com.imd.web.swaptales.model;

import java.util.Date;

import com.imd.web.swaptales.enums.StatusRental;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rental extends TransactionHistory{
	
	private StatusRental status;

	private Date date_return;

	private Date date_rental;
}
