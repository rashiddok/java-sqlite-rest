package com.pxp.SQLite.demo.service;


import com.pxp.SQLite.demo.dto.BookAuthor;
import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.repository.AuthorRepository;
import com.pxp.SQLite.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public Author addAuthor(Author author){
        this.authorRepository.save(author);
        return author;
    }

    @Transactional
    public List<Author> getAuthors(){return this.authorRepository.findAll();};

    @Transactional
    public Optional<Author> getAuthor(Integer id){return this.authorRepository.findById(id);};

    @Transactional
    public Author addAuthorBook(BookAuthor book){
        Book bookToAdd = this.bookRepository.findById(book.getBookId()).get();
        Author author = this.authorRepository.findById(book.getAuthorId()).get();
        author.getBooks().add(bookToAdd);
        authorRepository.save(author);
        return author;
    }
}
