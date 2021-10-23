package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public List<Author> getAuthors(){return this.authorService.getAuthors();}

    @RequestMapping(value = "author/add", method = RequestMethod.POST)
    public void addAuthor(@RequestBody Author author){this.authorService.addAuthor(author);}
}
