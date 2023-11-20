package com.imd.web.swaptales.dto;

import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private Long id;
    private Double price;
    private Date dateLoan;
    private Date dateReturn;
    private Date expectedReturnDate;
    private StatusLoan status;
    private Long bookId;
    private Long userId;

    public Loan getEntity(){
        Loan loan = new Loan();
        loan.setId(id);
        loan.setPrice(price);
        loan.setDateLoan(dateLoan);
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
