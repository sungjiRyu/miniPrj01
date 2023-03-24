package com.christmasboy_.miniproject1.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, Integer> {
    Page<BookEntity> findPageAllByCateseq(Integer cateSeq, Pageable pageable);
    Page<BookEntity> findAll(Pageable pageable);
    @Query(value = "select b from BookEntity b where b.title like %:keyword%")
    Page<BookEntity> searchBookByTitle(@Param("keyword") String keyword, Pageable pageable);
}
