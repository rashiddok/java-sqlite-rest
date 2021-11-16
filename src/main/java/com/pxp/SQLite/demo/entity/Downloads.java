package com.pxp.SQLite.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Downloads {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int book;

    private int downloads;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Downloads{" +
                "id=" + id +
                ", book='" + book + '\'' +
                ", downloads=" + downloads +
                '}';
    }
}
