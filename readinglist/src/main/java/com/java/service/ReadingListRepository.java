package com.java.service;

import com.java.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Future
 */
public interface ReadingListRepository extends JpaRepository<Book,Long> {

    /**
     * 可以根据读者的用户名来查找阅读列表
     * @return
     */
    List<Book> findByReader(String reader);
}
