package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.enums.StatusExchange;
import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.repository.BookRepository;
import com.imd.web.swaptales.repository.LoanRepository;
import com.imd.web.swaptales.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Loan> findAllBorrowedByIdUser(Long idUser) {
        return loanRepository.findAllBorrowedByIdUser(idUser);
    }

    @Override
    public List<Loan> findAllLoanedByIdUser(Long idUser) {
        return loanRepository.findAllLoanedByIdUser(idUser);
    }

    @Override
    public Loan createLoan(Loan loan) {
        LocalDate dateLoan = loan.getDateLoan();
        int countDaysLoan =  bookRepository.findById(loan.getBook().getId()).get().getCountDaysLoan();
        LocalDate expectedReturnDate = dateLoan.plusDays(countDaysLoan);
        loan.setExpectedReturnDate(expectedReturnDate);
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> getLoanById(Long idLoan) {
        return loanRepository.findById(idLoan);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Loan loan) {
        loanRepository.delete(loan);
    }

    @Override
    public Loan finishLoan(Long id) {

        Loan loan = loanRepository.findById(id).get();

        loan.setDateReturn(LocalDate.now());
        if(loan.getDateReturn().compareTo(loan.getExpectedReturnDate()) > 0){
            loan.setStatus(StatusLoan.ATRASO);
        }else{
            loan.setStatus(StatusLoan.ENTREGOU_SEM_ATRASO);
        }
        
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> findAllBorrowedPendentsByIdUser(Long idUser){
        return loanRepository.findAllBorrowedByIdUserAndByStatus(idUser, StatusLoan.PENDENTE);
    }

    @Override
    public Loan acceptLoan(Long id){
        Loan loan = loanRepository.findById(id).get();
        loan.setStatus(StatusLoan.APROVADO);
        return loanRepository.save(loan);
    }
}
