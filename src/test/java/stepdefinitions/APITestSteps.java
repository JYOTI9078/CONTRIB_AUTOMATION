package stepdefinitions;

import com.sogeti.automation.framework.constants.AppConstants.Api;
import com.sogeti.automation.framework.constants.AppConstants.Api.AuthenticationType;
import com.sogeti.automation.framework.utils.APIUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class APITestSteps {

    APIUtils apiUtils;
    Response apiResponse;
    SoftAssert softAssert = new SoftAssert();

    public APITestSteps() throws Exception {
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());

        apiUtils = new APIUtils(AuthenticationType.TOKEN);
    }

    @When("^user makes a GET User api call for (.*)$")
    public void getLatestBuildStatus(String userName) {
        String apiEndpoint = Api.API_BASE_URL + Api.GITHUB_USER_URL + userName;
        apiResponse = apiUtils.executeGET(apiEndpoint,null);

        // Assert that correct status code is returned.
        Assert.assertEquals(apiResponse.getStatusCode(), 200);

    }

    @Then("^verify response is returned for (.*)$")
    public void verifyUserApiResponse(String userName) {

        JsonPath jsonResponse = apiResponse.jsonPath();
        String userNameActual = jsonResponse.getString("login");
        String userUrlActual = jsonResponse.getString("html_url");

        //Assertion statements
        softAssert.assertEquals(userNameActual, userName, "Username returned does not match expected value. ");
        softAssert.assertEquals(userUrlActual, "https://github.com/" + userName,
                "User's Github URL does not match expected value. ");
        softAssert.assertAll();
    }

    @When("^user makes a POST api call to create a repository (.*)$")
    public void createNewRepository(String repoName) {
        String apiEndpoint = Api.API_BASE_URL + Api.GITHUB_USER_REPOS;

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", repoName);

        apiResponse = apiUtils.executePOST(apiEndpoint, requestParams.toString(), null);

        // Assert that correct status code is returned.
        Assert.assertEquals(apiResponse.getStatusCode(), 201);
    }

    @Then("^verify the repository (.*) is created successfully in (.*) profile$")
    public void verifyUserRepoCreation(String repoName, String userName) {
        JsonPath jsonResponse = apiResponse.jsonPath();
        String repoNameActual = jsonResponse.getString("name");
        String repoFullNameActual = jsonResponse.getString("full_name");
        String repoOwnerActual = jsonResponse.getString("owner.login");

        //Assertions
        softAssert.assertEquals(repoNameActual, repoName,
                "Created repository name does not match expected value. ");
        softAssert.assertEquals(repoFullNameActual, userName + "/" + repoName,
                "Created repository full name does not match expected value. ");
        softAssert.assertEquals(repoOwnerActual, userName,
                "Created repository owner does not match expected value. ");
        softAssert.assertAll();
    }

    @When("^user makes a DELETE api call to delete repository (.*) from (.*) profile$")
    public void deleteTestRepository(String repoName, String userName) {
        String apiEndpoint = Api.API_BASE_URL + Api.GITHUB_REPOS + userName + "/" + repoName;

        apiResponse = apiUtils.executeDELETE(apiEndpoint, null);
    }

    @Then("^verify the repository (.*) is deleted successfully from (.*) profile$")
    public void verifyRepoDeletion(String repoName, String userName) {
        // Assert that correct status code is returned.
        Assert.assertEquals(apiResponse.getStatusCode(), 204, "Could not delete repository. ");
    }
}
