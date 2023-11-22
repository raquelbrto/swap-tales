package com.imd.web.swaptales.model;

import com.imd.web.swaptales.enums.StatusExchange;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Exchange extends TransactionHistory{

    @ManyToOne
    @JoinColumn(name = "book_exchange_id")
    private Book bookExchange;

    @Column
    private StatusExchange status;
}
