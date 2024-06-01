package com.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String BASE_URI = "http://localhost:8080";
    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getAllBooksByAuthor(int authorId) {
        return RestAssured.given()
                .spec(requestSpec)
                .queryParam("id", authorId)
                .when()
                .get("/authors/{id}/books", authorId);
    }

    public Response saveNewBook(String bookTitle, int authorId) {
        return RestAssured.given()
                .spec(requestSpec)
                .body("{\"book_title\": \"" + bookTitle + "\", \"author\": {\"authorId\": " + authorId + "}}")
                .when()
                .post("/books/save");
    }
}
