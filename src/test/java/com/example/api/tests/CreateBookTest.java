package com.example.api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

@Epic("Library Service")
@Story("Создание новой книги")
public class CreateBookTest extends BaseTest {

    @Test
    @DisplayName("Сохранение новой книги")
    @Description("Тест для проверки успешного сохранения новой книги")
    public void testSaveNewBook() {
        String bookTitle = "Детство";
        int authorId = 653;

        given()
                .spec(requestSpecification)
                .body("{\"book_title\": \"" + bookTitle + "\", \"author\": {\"authorId\": " + authorId + "}}")
                .when()
                .post("/books/save")
                .then()
                .statusCode(200)
                .body("message", equalTo("Книга успешно сохранена"))
                .body("bookId", equalTo(4734));
    }
}