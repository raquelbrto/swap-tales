package com.imd.web.swaptales.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private Long id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateLoan;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate dateReturn;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate expectedReturnDate;
    private StatusLoan status;
    private Long bookId;
    private Long userId;

    public Loan getEntity(){
        Loan loan = new Loan();
        loan.setId(id);
        loan.setDateLoan(dateLoan);
        loan.setDateTransaction(dateLoan);
        loan.setDateReturn(dateReturn);
        loan.setExpectedReturnDate(expectedReturnDate);
        loan.setStatus(status);

        Book book = new Book();
        book.setId(bookId);

        loan.setBook(book);

        User user = new User();
        user.setId(userId);
        loan.setUser(user);
        return loan;
    }
}
