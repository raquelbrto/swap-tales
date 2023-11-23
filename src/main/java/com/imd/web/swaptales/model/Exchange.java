package com.imd.web.swaptales.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.imd.web.swaptales.enums.StatusExchange;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Exchange extends TransactionHistory{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_exchange_id")
    private Book bookExchange;

    @Column
    private StatusExchange status;
}
