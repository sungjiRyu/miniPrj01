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
@Table(name = "d_img_info")
@Getter @Setter
public class DetailImage {
    
    @Column(name = "d_img_seq")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(name = "d_img_file_name")
    private String fileName;

}
