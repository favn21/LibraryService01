package com.example.api.tests;

import com.example.api.models.request.GetBooksByAuthorRequest;
import com.example.api.models.response.GetBooksByAuthorResponse;
import com.example.api.models.response.GetBooksByAuthorResponse.BookDetail;
import com.example.api.service.RequestBuilder;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

@Epic("Library Service Tests")
@Story("Get Books by Author")
public class GetBooksByAuthorTest extends BaseTest {
    private final static String URL = "http://localhost:8080";

    @Test
    @DisplayName("Get Books by Author - Success")
    public void testGetBooksByAuthor() {
        RequestBuilder.instalSpecification(RequestBuilder.requestSpec(URL), RequestBuilder.responseSpecOK200());

        GetBooksByAuthorRequest request = new GetBooksByAuthorRequest(2L);

        GetBooksByAuthorResponse response = given()
                .body(request)
                .when()
                .post("/library/authors/books")
                .then().log().all()
                .extract().as(GetBooksByAuthorResponse.class);

        assertNotNull(response);
        assertNotNull(response.getBooks());
    }

    @Test
    @DisplayName("Get Books by Author (XML) - Success")
    public void testGetBooksByAuthorXML() {
        RequestBuilder.instalSpecification(RequestBuilder.requestSpec(URL), RequestBuilder.responseSpecOK200());

        String requestBody = "<author><author_id>2</author_id></author>";

        GetBooksByAuthorResponse response = given()
                .contentType("application/xml")
                .body(requestBody)
                .when()
                .post("/library/authors/books")
                .then().log().all()
                .extract().as(GetBooksByAuthorResponse.class);

        assertNotNull(response);
        List<BookDetail> books = response.getBooks();
        assertNotNull(books);
        assertTrue(books.size() > 0);

        for (BookDetail book : books) {
            Long authorId = book.getAuthorId();
            assertNotNull(authorId);
            assertTrue(authorId.equals(2L));
        }
    }
}
