package com.example.api.tests;

import com.example.api.models.response.GetBooksByAuthorResponse.Book;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Library Service")
@Story("Получение книг по автору")
public class GetBooksByAuthorTest extends BaseTest {

    @Test
    @DisplayName("Тест получения книг по автору (JSON)")
    @Description("Проверка успешного получения книг по автору в формате JSON")
    public void testGetBooksByAuthorJSON() {
        Long authorId = 1L;

        List<Book> books = given()
                .spec(requestSpec)
                .queryParam("authorId", authorId)
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList(".", Book.class);

        assert books.size() > 0;
        assert books.get(0).getAuthor().getId() == authorId;
    }

    @Test
    @DisplayName("Тест получения книг по автору (XML)")
    @Description("Проверка успешного получения книг по автору в формате XML")
    public void testGetBooksByAuthorXML() {
        Long authorId = 1L;

        List<Book> books = given()
                .spec(requestSpec)
                .contentType("application/xml")
                .queryParam("authorId", authorId)
                .when()
                .get("/books/xml")
                .then()
                .statusCode(200)
                .extract()
                .xmlPath()
                .getList(".", Book.class);

        assert books.size() > 0;
        assert books.get(0).getAuthor().getId() == authorId;
    }
}
