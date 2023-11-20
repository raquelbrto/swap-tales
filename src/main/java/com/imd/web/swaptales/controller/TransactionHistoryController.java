package com.imd.web.swaptales.controller;

import com.imd.web.swaptales.dto.LoanDTO;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.service.LoanService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionHistoryController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/loan")
    public ResponseEntity<?> createLoan(LoanDTO loanDTO){
        try{
            Loan loan = loanService.createLoan(loanDTO.getEntity());
            return ResponseEntity.ok(loan);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/loan/all-borrowed/{idUser}")
    public ResponseEntity<?> getAllBorrowedByIdUser(@PathParam("idUser") Long idUser){
        try{
            List<Loan> result = loanService.findAllBorrowedByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/loan/all-loaned/{idUser}")
    public ResponseEntity<?> getAllLoanedByIdUser(@PathParam("idUser") Long idUser){
        try{
            List<Loan> result = loanService.findAllLoanedByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
