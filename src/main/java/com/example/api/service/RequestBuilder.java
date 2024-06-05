package com.example.api.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestBuilder {
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addFilter((requestSpec, responseSpec, ctx) -> {
                    requestSpec.header("Accept", "application/json");
                    return ctx.next(requestSpec, responseSpec);
                })
                .build();
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void instalSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
