package com.pxp.SQLite.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name="author_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName="id")
    )
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
