package com.example.apitestingframework.utils;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import com.example.apitestingframework.config.ApiConfig; // Correct import

import static com.example.apitestingframework.config.ApiConfig.*;

public class RequestUtils {

    public static RequestSpecification givenWithApiKey() {
        return RestAssured.given().header("API-Key", API_KEY);
    }

    public static RequestSpecification givenWithBearerToken() {
        return RestAssured.given().auth().oauth2(BEARER_TOKEN);
    }

    public static RequestSpecification givenWithBasicAuth() {
        return RestAssured.given().auth().preemptive().basic(USERNAME, PASSWORD);
    }

    public static RequestSpecification givenWithOAuth2() {
        // Add OAuth2 implementation as needed
        return RestAssured.given(); // Placeholder
    }

    public static RequestSpecification givenWithSessionCookies() {
        Cookies cookies = ApiConfig.getSessionCookies();
        if (cookies != null) {
            return RestAssured.given().cookies(cookies);
        } else {
            throw new RuntimeException("Session cookies are not set. Please log in first.");
        }
    }
}
