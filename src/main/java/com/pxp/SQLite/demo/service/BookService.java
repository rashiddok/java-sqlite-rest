package com.pxp.SQLite.demo.service;


import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    @Transactional
    public List<Book> getBooks(){ return this.bookRepository.findAll();}

    @Transactional
    public Book addBook(Book book){
        this.bookRepository.save(book);
        return book;
    }

    @Transactional
    public Book updateBook(Book book){
        if(this.bookRepository.findById(book.getId()).isPresent()){
            Book bookToUpdate = this.bookRepository.findById(book.getId()).get();
            bookToUpdate.setValues(book);
            System.out.println(book.getLink());
            bookToUpdate.setLink(book.getLink());
            bookRepository.save(bookToUpdate);
            return  bookToUpdate;
        };
        return null;
    }

    @Transactional
    public Optional<Book> getBook(Integer id){return this.bookRepository.findById(id);};

    @Transactional
    public void deleteBook(Integer id){
        if(this.bookRepository.findById(id).isPresent()){
            Book bookToDelete = this.bookRepository.findById(id).get();
            this.bookRepository.delete(bookToDelete);
        }
    };


}
