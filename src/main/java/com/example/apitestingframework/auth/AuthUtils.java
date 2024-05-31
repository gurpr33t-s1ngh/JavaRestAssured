package com.example.apitestingframework.auth;

import com.example.apitestingframework.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.example.apitestingframework.config.ApiConfig.*;

import static com.example.apitestingframework.utils.RequestUtils.*;

public class AuthUtils {
    public static RequestSpecification withApiKey() {
        return givenWithApiKey();
    }

    public static RequestSpecification withBearerToken() {
        return givenWithBearerToken();
    }

    public static RequestSpecification withBasicAuth() {
        return givenWithBasicAuth();
    }

    public static RequestSpecification withOAuth2() {
        return givenWithOAuth2();
    }

    public static void loginAndSaveSessionCookies() {
        RequestSpecification request = RestAssured.given()
                .auth().preemptive().basic(ApiConfig.USERNAME, ApiConfig.PASSWORD);

        Response response = request.post(BASE_URL + "/login");

        if (response.getStatusCode() == 200) {
            Cookies cookies = response.detailedCookies();
            ApiConfig.setSessionCookies(cookies);
        } else {
            throw new RuntimeException("Failed to login, status code: " + response.getStatusCode());
        }
    }
}
