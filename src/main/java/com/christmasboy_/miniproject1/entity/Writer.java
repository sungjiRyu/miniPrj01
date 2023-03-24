package com.christmasboy_.miniproject1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "writer_info")
@Getter @Setter
public class Writer {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wi_seq")
    private Integer seq;
    
    @Column(name = "wi_name")
    private String name;
    
    @Column(name = "wi_intro", columnDefinition = "TEXT")
    private String intro;
}
