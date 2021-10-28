package com.pxp.SQLite.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name="author_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
