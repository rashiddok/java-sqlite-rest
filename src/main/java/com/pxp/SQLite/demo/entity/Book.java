package com.pxp.SQLite.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    private int id;

    private String name;

    private String year;

    private String isbn;

    private String description;

    private int pages;


    public int getId(){
        return this.id;
    }
    public void setValues(Book book){
        this.description = book.description;
        this.name = book.name;
        this.year = book.year;
        this.isbn = book.isbn;
        this.pages = book.pages;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Author> users;

    public Set<Author> getUsers() {
        return users;
    }

    public void setUsers(Set<Author> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

}
