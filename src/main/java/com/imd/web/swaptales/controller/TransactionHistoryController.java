package com.imd.web.swaptales.controller;

import com.imd.web.swaptales.dto.LoanDTO;
import com.imd.web.swaptales.dto.ExchangeDTO;
import com.imd.web.swaptales.dto.SaleDTO;
import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.Sale;
import com.imd.web.swaptales.service.ExchangeService;
import com.imd.web.swaptales.service.LoanService;
import com.imd.web.swaptales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionHistoryController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private SaleService saleService;

    @PostMapping("/loan")
    public ResponseEntity<?> createLoan(@RequestBody LoanDTO loanDTO){
        try{
            Loan loan = loanService.createLoan(loanDTO.getEntity());
            return ResponseEntity.ok(loan);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/loan/all-borrowed/{idUser}")
    public ResponseEntity<?> getAllBorrowedByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Loan> result = loanService.findAllBorrowedByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/loan/all-loaned/{idUser}")
    public ResponseEntity<?> getAllLoanedByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Loan> result = loanService.findAllLoanedByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/loan/user-pendent/{idUser}")
    public ResponseEntity<?> getAllBorrowedPendentsByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Loan> result = loanService.findAllBorrowedPendentsByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/loan/accept/{id}")
    public ResponseEntity<?> acceptLoan(@PathVariable("id") Long id){
        try{
            Loan result = loanService.acceptLoan(id);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/loan/finish/{id}")
    public ResponseEntity<?> finishLoan(@PathVariable("id") Long id){
        try{
            Loan result = loanService.finishLoan(id);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/exchange")
    public ResponseEntity<?> createExchange(@RequestBody ExchangeDTO exchangeDTO){
        try{
            Exchange exchange = exchangeService.createExchange(exchangeDTO.getEntity());
            return ResponseEntity.ok(exchange);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/exchange/user/{idUser}")
    public ResponseEntity<?> getAllExchangesByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Exchange> result = exchangeService.getAllExchangesByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping("/exchange/user-pendent/{idUser}")
    public ResponseEntity<?> getAllExchangesPendentByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Exchange> result = exchangeService.getAllExchangesPendentByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/exchange/accept/{id}")
    public ResponseEntity<?> acceptExchange(@PathVariable("id") Long id){
        try{
            Exchange result = exchangeService.acceptExchange(id);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/sale")
    public ResponseEntity<?> createSale(@RequestBody SaleDTO saleDTO){
        try{
            Sale sale = saleService.createSale(saleDTO.getEntity());
            return ResponseEntity.ok(sale);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/sale/all-sold/{idUser}")
    public ResponseEntity<?> getAllSoldByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Sale> result = saleService.findAllSoldByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/sale/all-purchased/{idUser}")
    public ResponseEntity<?> getAllPurchasedByIdUser(@PathVariable("idUser") Long idUser){
        try{
            List<Sale> result = saleService.findAllPurchasedByIdUser(idUser);
            return ResponseEntity.ok(result);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
