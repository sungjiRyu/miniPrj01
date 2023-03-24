package com.christmasboy_.miniproject1.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.christmasboy_.miniproject1.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findPageAllByCateSeq(Integer cateSeq, Pageable pageable);
    Page<Book> findAll(Pageable pageable);
    @Query(value = "select b from Book b where b.title like %:keyword%")
    Page<Book> searchBookByTitle(@Param("keyword") String keyword, Pageable pageable);
}
