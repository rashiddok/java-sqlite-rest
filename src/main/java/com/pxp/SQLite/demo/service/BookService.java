package com.pxp.SQLite.demo.service;


import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    @Transactional
    public List<Book> getBooks(){ return this.bookRepository.findAll();}

    @Transactional
    public void addBook(Book book){
        this.bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book){
        if(this.bookRepository.findById(book.getId()).isPresent()){
            Book bookToUpdate = this.bookRepository.findById(book.getId()).get();
            bookToUpdate.setValues(book);
            bookRepository.save(bookToUpdate);
        };
    }

    @Transactional
    public void deleteBook(Book book){
        if(this.bookRepository.findById(book.getId()).isPresent()){
            Book bookToDelete = this.bookRepository.findById(book.getId()).get();
            this.bookRepository.delete((bookToDelete));
        }
    }


}
