package com.imd.web.swaptales.controller;

import com.imd.web.swaptales.dto.BookDTO;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id){
        try{
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getBookByUserId(@PathVariable("id") Long userId){
        try{
            List<Book> books = bookService.getBooksByUser(userId);
            return ResponseEntity.ok(books);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id){
        try{
            bookService.deleteBookById(id);
            return ResponseEntity.ok("Sucesso: Livro excluido com sucesso!");
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        try{
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.ok(books);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registerBook(@RequestBody BookDTO bookDTO){
        try{
            Book book = bookService.register(bookDTO.getEntity());
            return ResponseEntity.ok(book);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO){
        try{
            Book book = bookService.update(bookDTO.getEntity());
            return ResponseEntity.ok(book);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/books-to-trade")
    public ResponseEntity<?> getAllBooksToTrade(){
        try{
            List<Book> books = bookService.getAllBoocksToTrade();
            return ResponseEntity.ok(books);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/books-to-sale")
    public ResponseEntity<?> getAllBooksToSale(){
        try{
            List<Book> books = bookService.getAllBocksToSale();
            return ResponseEntity.ok(books);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/books-to-loan")
    public ResponseEntity<?> getAllBooksToLoan(){
        try{
            List<Book> books = bookService.getAllBocksToLoan();
            return ResponseEntity.ok(books);
        }catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
