package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Category;
import com.pxp.SQLite.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional
    public List<Category> getCategories(){ return this.categoryRepository.findAll();}

    @Transactional
    public void addCategory(Category category){
        this.categoryRepository.save(category);
    }
}
