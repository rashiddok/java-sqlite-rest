package com.pxp.SQLite.demo.service;


import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void addAuthor(Author author){
        this.authorRepository.save(author);
    }

    @Transactional
    public List<Author> getAuthors(){return this.authorRepository.findAll();};
}
