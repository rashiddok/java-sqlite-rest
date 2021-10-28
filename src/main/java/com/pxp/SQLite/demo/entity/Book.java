package com.pxp.SQLite.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String year;

    private String isbn;

    private String description;

    private int pages;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Category> categories;


    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIsbn(){
        return this.isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getYear(){
        return this.year;
    }
    public void setYear(String year){
        this.year = year;
    }

    public int getPages(){
        return this.pages;
    }
    public void setPages(int pages){
        this.pages = pages;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setValues(Book book){
        this.description = book.description;
        this.name = book.name;
        this.year = book.year;
        this.isbn = book.isbn;
        this.pages = book.pages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", description=" + description +
                '}';
    }

}
