package com.christmasboy_.miniproject1.view;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_info_view")
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity implements Serializable {
    // bi_seq	bi_cate_seq	bi_img_seq	bi_d_img_seq	bi_wi_seq	wi_name	bi_title	bi_price	bi_publisher	bi_publish_dt	bi_de_price	bi_content_title	bi_content_text
    @Id
    @Column(name = "bi_seq") 
    private Integer seq;

    @Column(name = "bi_cate_seq") private Integer cateseq;
    @Column(name = "bi_wi_seq") private Integer wiseq;
    @Column(name = "wi_name") private String writername;
    @Column(name = "bi_title") private String title;
    @Column(name = "bi_price") private Integer price;
    @Column(name = "bi_publisher") private String publisher;
    @Column(name = "bi_publish_dt") private LocalDate publishdt;
    @Column(name = "bi_de_price") private Integer deliveryprice;
    @Column(name = "bi_content_title") private String contenttitle;
    @Column(name = "bi_content_text") private String contenttext;
    @Column(name = "bi_img_seq") private Integer imgseq;
    @Column(name = "bi_d_img_seq") private Integer dimgseq;
}
