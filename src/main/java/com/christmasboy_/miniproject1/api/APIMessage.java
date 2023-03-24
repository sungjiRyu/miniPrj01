package com.christmasboy_.miniproject1.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIMessage {
    private Boolean status;
    private String message;
    private Object data;
    
    public APIMessage(Boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    
}
