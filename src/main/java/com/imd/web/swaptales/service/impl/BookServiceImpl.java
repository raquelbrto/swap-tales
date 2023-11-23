package com.imd.web.swaptales.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.imd.web.swaptales.enums.AvailabilityStatus;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.repository.BookRepository;
import com.imd.web.swaptales.repository.UserRepository;
import com.imd.web.swaptales.service.BookService;
import com.imd.web.swaptales.util.exception.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Book register(Book book) throws BusinessRuleException {
        this.validation(book);

        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.getById(id);

        return book;
    }

    @Override
    public List<Book> getBooksByUser(Long userId) {
        return bookRepository.findByUserId(userId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(Long id) throws BusinessRuleException {
        if(bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
        }else{
            throw new BusinessRuleException("Erro: Livro não encontrado");
        }
    }

    @Override
    public Book update(Book book) throws BusinessRuleException {

        Optional<Book> bookOptional = bookRepository.findById(book.getId());

        if(bookOptional.isPresent()){

            Book bookBD = bookOptional.get();
            if(book.getConditionBook() != null){
                bookBD.setConditionBook(book.getConditionBook());
            }

            if(book.getTitle() != null && book.getTitle() != null){
                bookBD.setTitle(book.getTitle());
            }

            if(book.getAuthor() != null && book.getAuthor() != ""){
                bookBD.setAuthor(book.getAuthor());
            }
            if(book.getDescription() != null && book.getDescription() != ""){
                bookBD.setDescription(book.getDescription());
            }
            if(book.getEdition() != null){
                bookBD.setEdition(book.getEdition());
            }
            if(book.getPublishingCompany() != null){
                bookBD.setPublishingCompany(book.getPublishingCompany());
            }

            return bookRepository.save(bookBD);

        }else{
            throw new BusinessRuleException("Erro: Livro não encontrado");
        }
    }

    @Override
    public void validation(Book book) throws BusinessRuleException {
        if(book.getAuthor() == null || book.getAuthor() == ""){
            throw new BusinessRuleException("Erro: Não pode existir um livro sem um autor!");
        }

        if(book.getTitle() == null || book.getTitle() == ""){
            throw new BusinessRuleException("Erro: Não pode existir um livro sem titulo!");
        }

        if(book.getEdition() == null){
            throw new BusinessRuleException("Erro: Não pode existir um livro sem o número da edição!");
        }

        if(book.getOwnerUser() != null && book.getOwnerUser().getId() != null){
            if(!userRepository.existsById(book.getOwnerUser().getId())){
                throw new BusinessRuleException("Erro: O dono desse livro não foi encontrado no sistema!");
            }
        }else{
            throw new BusinessRuleException("Erro: Não pode existir um livro sem um dono!");
        }
    }

    @Override
    public List<Book> getAllBocksToLoan() {
        return bookRepository.findByAvailabilityStatus(AvailabilityStatus.FOR_LOAN);
    }

    @Override
    public List<Book> getAllBocksToSale() {
        return bookRepository.findByAvailabilityStatus(AvailabilityStatus.FOR_SALE);
    }

    @Override
    public List<Book> getAllBoocksToTrade() {
        return bookRepository.findByAvailabilityStatus(AvailabilityStatus.FOR_TRADE);
    }

    @Override
    public List<Book> listTopBooks(){
        return bookRepository.listTopBooks();
    }

}
