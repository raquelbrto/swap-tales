package com.imd.web.swaptales.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.imd.web.swaptales.enums.StatusExchange;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {
    private Long id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateTransaction;
    private StatusExchange status;
    private Long bookId;
    private Long bookExchangeId;
    private Long userId;

    public Exchange getEntity(){
        Exchange trade = new Exchange();

        trade.setId(id);
        trade.setDateTransaction(dateTransaction);
        trade.setStatus(status);

        Book book = new Book();
        book.setId(bookId);
        trade.setBook(book);

        Book bookExchange = new Book();
        bookExchange.setId(bookExchangeId);
        trade.setBookExchange(bookExchange);

        User user = new User();
        user.setId(userId);
        trade.setUser(user);

        return trade;
    }
}
