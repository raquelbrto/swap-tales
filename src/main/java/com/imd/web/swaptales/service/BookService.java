package com.imd.web.swaptales.service;

import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.util.exception.BusinessRuleException;

import java.util.List;

public interface BookService {

    Book register(Book book) throws BusinessRuleException;

    Book getBookById(Long id);

    List<Book> getBooksByUser(Long userId);

    List<Book> getAllBooks();

    void deleteBookById(Long id) throws BusinessRuleException;

    Book update(Book book) throws BusinessRuleException;

    void validation(Book book) throws BusinessRuleException;
}