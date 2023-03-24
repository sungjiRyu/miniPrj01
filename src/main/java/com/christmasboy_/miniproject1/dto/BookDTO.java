package com.christmasboy_.miniproject1.dto;

import java.time.LocalDate;


import com.christmasboy_.miniproject1.entity.Book;
import com.christmasboy_.miniproject1.view.BookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer seq;
    private Integer cateSeq;
    private Integer wiSeq;
    private String writerName;
    private String title;
    private Integer price;
    private String publisher;
    private LocalDate publishDt;
    private Integer deliveryPrice;
    private String contentTitle;
    private String contentText;
    private String imageUri;
    private String detailImageUri;


    public static BookDTO fromEntity(Book b) { 

        

        return BookDTO.builder()
            .seq(b.getSeq())
            .cateSeq(b.getCateSeq())
            .wiSeq(b.getWiSeq())
            .title(b.getTitle())
            .price(b.getPrice())
            .publisher(b.getPublisher())
            .publishDt(b.getPublishDt())
            .deliveryPrice(b.getDeliveryPrice())
            .contentTitle(b.getContentTitle())
            .contentText(b.getContentText())
            .imageUri("/api/book/image/basic/" + b.getImgSeq())
            .detailImageUri(b.getDImgSeq() == null ? null : ("/api/book/image/detail/" + b.getDImgSeq()))
            .build();
    }

    public static BookDTO fromEntity(BookEntity b) { 

        

        return BookDTO.builder()
            .seq(b.getSeq())
            .cateSeq(b.getCateseq())
            .wiSeq(b.getWiseq())
            .writerName(b.getWritername())
            .title(b.getTitle())
            .price(b.getPrice())
            .publisher(b.getPublisher())
            .publishDt(b.getPublishdt())
            .deliveryPrice(b.getDeliveryprice())
            .contentTitle(b.getContenttitle())
            .contentText(b.getContenttext())
            .imageUri("/api/book/image/basic/" + b.getImgseq())
            .detailImageUri(b.getDimgseq() == null ? null : ("/api/book/image/detail/" + b.getDimgseq()))
            .build();
    }
}
