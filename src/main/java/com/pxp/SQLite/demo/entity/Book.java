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

    private String issuedBy;

    private String cover;

    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
        this.cover = book.cover;
        this.issuedBy = book.issuedBy;
        this.pages = book.pages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", description=" + description +
                '}';
    }

}
