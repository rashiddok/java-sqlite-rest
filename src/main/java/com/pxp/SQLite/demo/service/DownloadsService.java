package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Book;
import com.pxp.SQLite.demo.entity.Downloads;
import com.pxp.SQLite.demo.repository.BookRepository;
import com.pxp.SQLite.demo.repository.DownloadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
public class DownloadsService {

    @Autowired
    private DownloadsRepository downloadsRepository;

    @Transactional
    public List<Downloads> getDownloads(){ return this.downloadsRepository.findAll();}

    @Transactional() Downloads findByBook(int id){
        Iterator<Downloads> iterator = this.downloadsRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Downloads customer = iterator.next();
            if (customer.getBook() == id) {
                return customer;
            }
        }
        return null;
    }

    @Transactional
    public void addDownloads(int bookId){
        System.out.println(this.downloadsRepository.findMaxId() + 1);
        Downloads books = this.findByBook(bookId);
        if(books == null){
            Downloads download = new Downloads();
            download.setId(1);
            download.setDownloads(1);
            download.setBook(bookId);
            this.downloadsRepository.save(download);
            return;
        }
        else {
            Downloads b = books;
            b.setDownloads(b.getDownloads() + 1);
            this.downloadsRepository.save(b);
            return;
        }
    }
}
