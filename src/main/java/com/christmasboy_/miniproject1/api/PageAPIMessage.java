package com.christmasboy_.miniproject1.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageAPIMessage {
    private Object data;
    private Integer totalPages;
    private Integer pageNumber;
}
