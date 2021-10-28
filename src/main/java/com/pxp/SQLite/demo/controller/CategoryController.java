package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.dto.BookAuthor;
import com.pxp.SQLite.demo.dto.BookCategory;
import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.entity.Category;
import com.pxp.SQLite.demo.service.CategoryService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public List<Category> getCategories(){return this.categoryService.getCategories();}

    @RequestMapping(value = "category/add", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){ return this.categoryService.addCategory(category);}

    @RequestMapping(value = "category/book", method = RequestMethod.POST)
    public Category addCategoryBook(@RequestBody BookCategory book){return this.categoryService.addCategoryBook(book);}

    @RequestMapping(value = "category/{id}/books", method = RequestMethod.GET)
    public Set<Book> getCategoryBooks(@PathVariable @NotNull Integer id){return this.categoryService.getCategory(id).get().getBooks();}
}
