package com.sogeti.automation.framework.utils;

import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.AppConstants.Api;
import com.sogeti.automation.framework.constants.AppConstants.Api.AuthenticationType;
import com.sogeti.automation.framework.constants.AppConstants.Api.GrantType;
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
    private RequestSpecification request;


    public APIUtils() {
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
        request = this.headerSetup();
        log = new Logging(this.getClass().getName());
    }

    public APIUtils(AuthenticationType authType) {
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
        log = new Logging(this.getClass().getName());

        switch (authType) {
            case BASIC:
                request = this.headerSetupBasic(Api.API_USERNAME, Api.API_PASSWORD);
                break;
            case DIGEST:
                request = this.headerSetupDigest(Api.API_USERNAME, Api.API_PASSWORD);
                break;
            case TOKEN:
                request = this.headerSetup(Api.API_BEARER_TOKEN);
                break;
            default:
                log.error("INVALID API AUTHENTICATION TYPE");
                break;
        }

    }

    public APIUtils(AuthenticationType authType, GrantType grantType) {
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
        log = new Logging(this.getClass().getName());

        if (authType == AuthenticationType.OAUTH2) {
            switch (grantType) {
                case CLIENT_CREDENTIALS:
                    request = this.headerSetup(getAccessTokenWithClientCredentials());
                    break;
                case AUTHORIZATION_CODE:
                    request = this.headerSetup(getAccessTokenWithAuthorizationCode());
                    break;
                case PASSWORD:
                    request = this.headerSetup(getAccessTokenWithPassword());
                    break;
                default:
                    log.error("INVALID GRANT TYPE PASSED FOR API AUTHENTICATION");
                    break;
            }
        } else {
            log.error("INVALID API AUTHENTICATION TYPE");
        }
    }

    /**
     * @Description: This method is used to return a Bearer-token for API calls
     * by using the token configuration details in the properties file.
     */
    private String getAccessTokenWithClientCredentials() {
        String accessToken = null;
        String tokenType = null;

        log.info("Trying to generate API Access token...");
        Response response = given().auth().preemptive()
                .basic(AppConstants.Api.API_USERNAME, AppConstants.Api.API_PASSWORD)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", AppConstants.Api.API_GRANT_TYPE)
                .formParam("scope", AppConstants.Api.API_SCOPE)
                .when()
                .post(AppConstants.Api.API_ACCESS_TOKEN_URL);

        log.info("Access token generated successfully.");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        accessToken = jsonObject.getString("access_token");
        tokenType = jsonObject.getString("token_type");

        return (tokenType + " " + accessToken);
    }

    /**
     * @Description: This method is used to return a Bearer-token for API calls
     * by using the token configuration details in the properties file.
     */
    private String getAccessTokenWithPassword() {
        String accessToken = null;
        String tokenType = null;

        log.info("Trying to generate API Access token...");
        Response response = given().auth().preemptive()
                .basic(Api.API_CLIENT_ID, Api.API_CLIENT_SECRET)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", Api.API_GRANT_TYPE)
                .formParam("scope", Api.API_SCOPE)
                .formParam("username", Api.API_USERNAME)
                .formParam("password", Api.API_PASSWORD)
                .when()
                .post(AppConstants.Api.API_ACCESS_TOKEN_URL);

        log.info("Access token generated successfully.");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        accessToken = jsonObject.getString("access_token");
        tokenType = jsonObject.getString("token_type");

        return (tokenType + " " + accessToken);
    }

    /**
     * @Description: This method is used to return a Bearer-token for API calls
     * by using the token configuration details in the properties file.
     */
    private String getAccessTokenWithAuthorizationCode() {
        String accessToken = null;
        String tokenType = null;

        log.info("Trying to generate API Access token...");
        Response response = given()
                .header("Authorization", Api.API_CLIENT_ID, Api.API_CLIENT_SECRET)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", Api.API_GRANT_TYPE)
                .formParam("redirect_uri",Api.API_REDIRECT_URL)
                .formParam("response_type", Api.API_RESPONSE_TYPE)
                .formParam("code", Api.API_AUTHORIZATION_CODE)
                .formParam("client_id", Api.API_CLIENT_ID)
                .formParam("client_secret", Api.API_CLIENT_SECRET)
                .when()
                .post(AppConstants.Api.API_ACCESS_TOKEN_URL);

        log.info("Access token generated successfully.");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        accessToken = jsonObject.getString("access_token");
        tokenType = jsonObject.getString("token_type");

        return (tokenType + " " + accessToken);
    }

    /**
     * @Description: This is the common header setup to be used in all API calls with no authentication
     */
    private RequestSpecification headerSetup() {
        log.info("Setting up API call header (without authorization)...");
        return given().header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .when();
    }

    /**
     * @Description: This is the common header setup to be used in all API calls with Bearer or OAuth2.0
     * authentication
     */
    private RequestSpecification headerSetup(String accessToken) {
        log.info("Setting up API call header with Bearer token authorization...");
        return given().header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.ANY)
                .header("Authorization", "Bearer " + accessToken)
                .when();
    }

    /**
     * @Description: This is the common header setup to be used in all API calls with Basic authentication
     */
    private RequestSpecification headerSetupBasic(String userName, String password) {
        log.info("Setting up API call header with Basic Authentication...");
        return given()
                .header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.ANY)
                .auth()
                .preemptive()
                .basic(userName, password)
                .when();
    }

    /**
     * @Description: This is the common header setup to be used in all API calls with Basic authentication
     */
    private RequestSpecification headerSetupDigest(String userName, String password) {
        log.info("Setting up API call header with Digest authorization...");
        return given().header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .auth()
                .digest(userName, password)
                .when();
    }

    /**
     * @param url      = BASE_URI + endpoint
     * @param queryParams = Map of all the query parameters for the API call
     * @return Rest-Assured Response
     * @Description: This method will make a GET call and return the response data
     */
    public Response executeGET(String url, Map<String, Object> queryParams) {
        Response response = null;

        log.info("Executing GET API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryParams != null)
                queryParams.forEach((key, value) -> when[0].queryParam(key, value));

            response = when[0].get(url);
            response.then().extract().response();
            log.info("GET API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to execute API\n", e);
        }

    }

    /**
     * @param url          = BASE_URI + endpoint
     * @param requestBody = the request body in JSON format
     * @param queryMap     = Map of all the query parameters for the API call
     * @return Rest-Assured response
     * @Description: This method will make a POST call with request body and query parameters
     * and return the response message
     */
    public Response executePOST(String url, String requestBody, Map<String, Object> queryMap) {
        Response response = null;

        log.info("Executing POST API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryMap != null)
                queryMap.forEach((key, value) -> when[0] = when[0].queryParam(key, value));

            response = when[0].body(requestBody).post(url);
            response.then().extract().response();
            log.info("POST API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to get data from API", e);
        }
    }

    /**
     * @param url          = BASE_URI + endpoint
     * @param requestBody = the request body in JSON format
     * @param queryMap     = Map of all the query parameters for the API call
     * @return Rest-Assured response
     * @Description: This method will make a PUT call with request body and query parameters
     * and return the response message
     */
    public Response executePUT(String url, String requestBody, Map<String, Object> queryMap) {
        Response response = null;

        log.info("Executing PUT API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryMap != null)
                queryMap.forEach((key, value) -> when[0] = when[0].queryParam(key, value));

            response = when[0].body(requestBody).put(url);
            response.then().extract().response();
            log.info("PUT API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to execute API\n", e);
        }
    }

    /**
     * @param url          = BASE_URI + endpoint
     * @param requestBody = the request body in JSON format
     * @param queryMap     = Map of all the query parameters for the API call
     * @return Rest-Assured response
     * @Description: This method will make a PATCH call with request body and query parameters
     * and return the response message
     */
    public Response executePATCH(String url, String requestBody, Map<String, Object> queryMap) {
        Response response = null;

        log.info("Executing PATCH API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryMap != null)
                queryMap.forEach((key, value) -> when[0] = when[0].queryParam(key, value));

            response = when[0].body(requestBody).patch(url);
            response.then().extract().response();
            log.info("PATCH API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to execute API\n", e);
        }
    }

    /**
     * @param url          = BASE_URI + endpoint
     * @param queryMap     = Map of all the query parameters for the API call
     * @return Rest-Assured response
     * @Description: This method will make a DELETE call with request body and query parameters
     * and return the response message
     */
    public Response executeDELETE(String url, Map<String, Object> queryMap) {
        Response response = null;

        log.info("Executing DELETE API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryMap != null)
                queryMap.forEach((key, value) -> when[0] = when[0].queryParam(key, value));

            response = when[0].delete(url);
            response.then().extract().response();
            log.info("DELETE API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to execute API\n", e);
        }
    }

    /**
     * @param url          = BASE_URI + endpoint
     * @param requestBody = the request body in JSON format
     * @param queryMap     = Map of all the query parameters for the API call
     * @return Rest-Assured response
     * @Description: This method will make a DELETE call with request body and query parameters
     * and return the response message
     */
    public Response executeDELETE(String url, String requestBody, Map<String, Object> queryMap) {
        Response response = null;

        log.info("Executing DELETE API call for " + url);
        RequestSpecification[] when = {request};
        try {
            if (queryMap != null)
                queryMap.forEach((key, value) -> when[0] = when[0].queryParam(key, value));

            response = when[0].body(requestBody).delete(url);
            response.then().extract().response();
            log.info("DELETE API call executed successfully.");

            return response;
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new RuntimeException("Failed to execute API\n", e);
        }
    }

}
