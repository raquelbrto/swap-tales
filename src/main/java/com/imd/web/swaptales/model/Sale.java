package com.imd.web.swaptales.model;

import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.enums.StatusSale;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale extends TransactionHistory{

    @Column
    private StatusSale status;

    @Column
    private Double price;
}
