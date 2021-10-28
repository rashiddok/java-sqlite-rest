package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.dto.BookAuthor;
import com.pxp.SQLite.demo.dto.BookCategory;
import com.pxp.SQLite.demo.entity.Author;
import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.entity.Category;
import com.pxp.SQLite.demo.repository.BookRepository;
import com.pxp.SQLite.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;


    @Transactional
    public List<Category> getCategories(){ return this.categoryRepository.findAll();}

    @Transactional
    public Category addCategory(Category category){
        this.categoryRepository.save(category);
        return category;
    }

    @Transactional
    public Optional<Category> getCategory(Integer id){return this.categoryRepository.findById(id);};

    @Transactional
    public Category addCategoryBook(BookCategory book){
        Book bookToAdd = this.bookRepository.findById(book.getBookId()).get();
        Category category = this.categoryRepository.findById(book.getCategoryId()).get();
        category.getBooks().add(bookToAdd);
        categoryRepository.save(category);
        return category;
    }
}
