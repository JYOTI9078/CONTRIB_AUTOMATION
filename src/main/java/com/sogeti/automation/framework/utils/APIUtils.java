package com.sogeti.automation.framework.utils;

import com.sogeti.automation.framework.constants.AppConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtils {
    private Logging log;
    //    public Response response;
    private String body;

    public APIUtils() {
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    private String getAccessToken() {
        String accessToken = null;
        String tokenType = null;

        log.info("Trying to generate API Bearer token...");
        Response response = given().auth().preemptive()
                .basic(AppConstants.Api.API_USERNAME, AppConstants.Api.API_PASSWORD)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", AppConstants.Api.API_GRANT_TYPE)
                .formParam("scope", AppConstants.Api.API_SCOPE)
                .when()
                .post(AppConstants.Api.API_ACCESS_TOKEN_URL);

        log.info("Bearer token generated successfully.");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        accessToken = jsonObject.getString("access_token");
        tokenType = jsonObject.getString("token_type");

        return (tokenType + " " + accessToken);
    }

    private RequestSpecification headerSetup() {
        log.info("Setting up API call header (without authorization)...");
        return given().header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .when();
    }

    private RequestSpecification headerSetup(String accessToken) {
        log.info("Setting up API call header without authorization...");
        return given().header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .header("Authorization", this.getAccessToken())
                .when();
    }

    public Response getAPIResponse(String url, Map<String, Object> queryParams) {
        Response response = null;

        log.info("Executing GET API call...");
        RequestSpecification request = this.headerSetup();
        RequestSpecification[] when = {request};
        try {
            if (queryParams != null)
                queryParams.forEach((key, value) -> when[0].queryParam(key, value));

            response = when[0].get(url);
            response.then().extract().response();

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get data from API", e);
        }

    }
}
