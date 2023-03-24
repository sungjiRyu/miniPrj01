package com.christmasboy_.miniproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.christmasboy_.miniproject1.entity.DetailImage;

public interface DetailImageRepository extends JpaRepository<DetailImage, Integer> {
    
}
