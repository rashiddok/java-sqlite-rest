package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.entity.Category;
import com.pxp.SQLite.demo.entity.Downloads;
import com.pxp.SQLite.demo.service.CategoryService;
import com.pxp.SQLite.demo.service.DownloadsService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DownloadsController {
    @Autowired
    private DownloadsService downloadsService;

    @RequestMapping(value = "downloads", method = RequestMethod.GET)
    public List<Downloads> getCategories(){return this.downloadsService.getDownloads();}

    @RequestMapping(value = "downloads/{id}/add", method = RequestMethod.GET)
    public void addDownloads(@PathVariable @NotNull Integer id){this.downloadsService.addDownloads(id);}
}
