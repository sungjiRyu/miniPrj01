package com.christmasboy_.miniproject1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "category_info")
@Getter
public class Category {
    
    
    @Column(name = "cate_seq")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    
    @Column(name = "cate_name")
    private String name;
    
}
