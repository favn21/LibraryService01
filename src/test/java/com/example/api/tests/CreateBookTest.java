package com.example.api.tests;

import com.example.api.models.request.CreateBookRequest;
import com.example.api.models.response.CreateBookResponse;
import com.example.api.db.Author;
import com.example.api.service.RequestBuilder;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Library Service Tests")
@Story("Create Book")
public class CreateBookTest extends BaseTest {
    private final static String URL = "http://localhost:8080";

    @Test
    @DisplayName("Create Book - Success")
    public void testCreateBook() {
        RequestBuilder.instalSpecification(RequestBuilder.requestSpec(URL), RequestBuilder.responseSpecOK200());

        Author author = new Author();
        author.setId(2L);

        CreateBookRequest request = new CreateBookRequest("Два гусара", author);

        CreateBookResponse response = given()
                .body(request)
                .when()
                .post("/library/books/save")
                .then().log().all()
                .extract().as(CreateBookResponse.class);

        assertNotNull(response);
        assertNotNull(response.getBookId());
    }
}