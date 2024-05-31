package com.example.apitestingframework.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static com.example.apitestingframework.utils.RequestUtils.*;
import io.restassured.specification.RequestSpecification;

public class ApiRequests {

    private static final String BASE_URL = "https://reqres.in";
    public static Response getRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();
        return request.get(BASE_URL + endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        return givenWithApiKey().body(body).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Object body) {
        return givenWithApiKey().body(body).when().put(endpoint);
    }

    public static Response patchRequest(String endpoint, Object body) {
        return givenWithApiKey().body(body).when().patch(endpoint);
    }

    public static Response deleteRequest(String endpoint) {
        return givenWithApiKey().when().delete(endpoint);
    }
}
