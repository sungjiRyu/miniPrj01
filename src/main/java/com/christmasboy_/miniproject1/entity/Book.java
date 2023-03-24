package com.christmasboy_.miniproject1.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_info")
@NoArgsConstructor
@Getter @Setter
public class Book {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bi_seq")
    private Integer seq;

    @Column(name = "bi_cate_seq")
    private Integer cateSeq;

    @Column(name = "bi_img_seq")
    private Integer imgSeq;

    @Column(name = "bi_d_img_seq")
    private Integer dImgSeq;

    @Column(name = "bi_wi_seq")
    private Integer wiSeq;

    @Column(name = "bi_title")
    private String title;

    @Column(name = "bi_price")
    private Integer price;

    @Column(name = "bi_publisher")
    private String publisher;
    
    @Column(name = "bi_publish_dt")
    private LocalDate publishDt;

    @Column(name = "bi_de_price")
    private Integer deliveryPrice;

    @Column(name = "bi_content_title")
    private String contentTitle;

    @Column(name = "bi_content_text", columnDefinition = "TEXT")
    private String contentText;
}
