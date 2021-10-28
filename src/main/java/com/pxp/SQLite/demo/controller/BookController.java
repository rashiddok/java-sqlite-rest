package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.service.BookService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks(){ return this.bookService.getBooks();}

    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable @NotNull Integer id){return this.bookService.getBook(id).get();}

    @RequestMapping(value = "book/{id}/delete", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable @NotNull Integer id){this.bookService.deleteBook(id);}

    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){return this.bookService.addBook(book);}

    @RequestMapping(value = "book/update", method = RequestMethod.POST)
    public Book updateBook(@RequestBody Book book){return this.bookService.updateBook(book);}
}
