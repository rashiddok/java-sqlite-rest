package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks(){ return this.bookService.getBooks();}

    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book){this.bookService.addBook(book);}

    @RequestMapping(value = "book/update", method = RequestMethod.POST)
    public void updateBook(@RequestBody Book book){this.bookService.updateBook(book);}

    @RequestMapping(value = "book/delete", method = RequestMethod.POST)
    public void deleteBook(@RequestBody Book book){this.bookService.deleteBook(book);}
}
