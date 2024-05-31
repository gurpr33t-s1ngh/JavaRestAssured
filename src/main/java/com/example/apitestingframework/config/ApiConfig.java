package com.example.apitestingframework.config;

import io.restassured.http.Cookies;

public class ApiConfig {
    public static final String BASE_URL = "https://reqres.in";
    public static final String API_KEY = "your_api_key";
    public static final String BEARER_TOKEN = "your_bearer_token";
    public static final String USERNAME = "pqrschoolteacher1@yopmail.com";
    public static final String PASSWORD = "qwerty";
    private static Cookies sessionCookies;

    public static Cookies getSessionCookies() {
        return sessionCookies;
    }

    public static void setSessionCookies(Cookies cookies) {
        sessionCookies = cookies;
    }
}
