package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.model.Loan;
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
    public Loan finishLoan(Loan loan) {
        loan.setDateReturn(LocalDate.now());
        if(loan.getDateReturn().compareTo(loan.getExpectedReturnDate()) > 0){
            loan.setStatus(StatusLoan.ATRASO);
        }else{
            loan.setStatus(StatusLoan.ENTREGOU_SEM_ATRASO);
        }
        
        return loanRepository.save(loan);
    }
}
