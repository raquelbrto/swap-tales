package com.imd.web.swaptales.service;

import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.User;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    List<Loan> findAllBorrowedByIdUser(Long idUser);

    List<Loan> findAllLoanedByIdUser(Long idUser);

    Loan createLoan(Loan loan);

    Optional<Loan> getLoanById(Long idLoan);

    Loan updateLoan(Loan loan);

    void deleteLoan(Loan loan);

    Loan finishLoan(Loan loan);
}
