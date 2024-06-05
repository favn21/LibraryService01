package com.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CreateBookResponse {
    private long bookId;
    private Integer errorCode;
    private String errorMessage;
    private String errorDetails;

    public CreateBookResponse(long bookId) {
        this.bookId = bookId;
    }

    public long getBookId() {
        return bookId;
    }
}

