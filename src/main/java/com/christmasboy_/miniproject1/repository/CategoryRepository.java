package com.christmasboy_.miniproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christmasboy_.miniproject1.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
