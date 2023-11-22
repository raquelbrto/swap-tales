package com.imd.web.swaptales.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.imd.web.swaptales.enums.StatusSale;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Sale;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateTransaction;
    private StatusSale status;
    private Long bookId;
    private Double price;
    private Long userId;

    public Sale getEntity(){
        Sale sale = new Sale();
        sale.setPrice(price);
        sale.setStatus(status);

        Book book = new Book();
        book.setId(bookId);
        sale.setBook(book);

        User user = new User();
        user.setId(userId);
        sale.setUser(user);

        return sale;
    }
}
