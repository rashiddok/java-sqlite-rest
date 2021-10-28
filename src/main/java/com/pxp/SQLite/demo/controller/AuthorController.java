package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.dto.BookAuthor;
import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.service.AuthorService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public List<Author> getAuthors(){return this.authorService.getAuthors();}

    @RequestMapping(value = "author/add", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){return this.authorService.addAuthor(author);}

    @RequestMapping(value = "author/book", method = RequestMethod.POST)
    public Author addAuthorBook(@RequestBody BookAuthor book){return this.authorService.addAuthorBook(book);}

    @RequestMapping(value = "author/{id}/books", method = RequestMethod.GET)
    public Set<Book> getAuthor(@PathVariable @NotNull Integer id){return this.authorService.getAuthor(id).get().getBooks();}
}
