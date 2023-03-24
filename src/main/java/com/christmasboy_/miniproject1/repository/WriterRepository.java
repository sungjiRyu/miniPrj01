package com.christmasboy_.miniproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christmasboy_.miniproject1.entity.Writer;

public interface WriterRepository extends JpaRepository<Writer, Integer> {
    
}
