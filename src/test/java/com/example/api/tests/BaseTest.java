package com.example.api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/library/books";
    }
}

