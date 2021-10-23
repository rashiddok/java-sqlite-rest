package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Category;
import com.pxp.SQLite.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public List<Category> getCategories(){return this.categoryService.getCategories();}

    @RequestMapping(value = "category/add", method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category){this.categoryService.addCategory(category);}
}
