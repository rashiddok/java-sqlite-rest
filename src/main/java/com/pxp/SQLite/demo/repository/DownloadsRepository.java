package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.Downloads;
import com.pxp.SQLite.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadsRepository extends JpaRepository<Downloads, Integer> {
    @Query("select max(s.id) from Downloads s")
    Integer findMaxId();
}
