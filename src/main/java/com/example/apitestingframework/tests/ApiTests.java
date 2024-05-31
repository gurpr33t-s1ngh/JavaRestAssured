package com.example.apitestingframework.tests;

import com.example.apitestingframework.auth.AuthUtils;
import com.example.apitestingframework.requests.ApiRequests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("API Testing")
public class ApiTests {

//    @BeforeAll
//    public static void setup() {
//        AuthUtils.loginAndSaveSessionCookies();
//    }

    @Test
    @Story("GET Endpoint")
    @Description("Test the GET request for the specified endpoint")
    public void testGetRequest() {
        Response response = ApiRequests.getRequest("/api/users?page=2");
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @Story("POST Endpoint")
    @Description("Test the POST request for the specified endpoint")
    public void testPostRequest() {
        String requestBody = "{ \"key\": \"value\" }";
        Response response = ApiRequests.postRequest("/endpoint", requestBody);
        assertEquals(201, response.getStatusCode());
    }

    @Test
    @Story("PUT Endpoint")
    @Description("Test the PUT request for the specified endpoint")
    public void testPutRequest() {
        String requestBody = "{ \"key\": \"updatedValue\" }";
        Response response = ApiRequests.putRequest("/endpoint", requestBody);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @Story("PATCH Endpoint")
    @Description("Test the PATCH request for the specified endpoint")
    public void testPatchRequest() {
        String requestBody = "{ \"key\": \"patchedValue\" }";
        Response response = ApiRequests.patchRequest("/endpoint", requestBody);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    @Story("DELETE Endpoint")
    @Description("Test the DELETE request for the specified endpoint")
    public void testDeleteRequest() {
        Response response = ApiRequests.deleteRequest("/endpoint");
        assertEquals(204, response.getStatusCode());
    }
}
