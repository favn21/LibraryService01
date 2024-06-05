package com.example.api.models.request;

import com.example.api.db.Author;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CreateBookRequest {
    private String bookTitle;
    private Author author;

    public CreateBookRequest(String bookTitle, Author author) {
        this.bookTitle = bookTitle;
        this.author = author;
    }
}
