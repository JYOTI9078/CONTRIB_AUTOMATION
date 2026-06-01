/*
 * Creation : 27 Mar 2025
 */
package stepdefinitions;

import org.apache.logging.log4j.ThreadContext;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.LoginPage1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestClass {
    TestContext testContext;
    LoginPage1 loginPage1;

    public LoginSteps(TestContext context) throws Exception {
        this.testContext = context;
        loginPage1 = testContext.getPageObjectManager().getLoginPage1();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("The user is on login page")
    public void the_user_is_on_login_page() throws Exception {
        Thread.sleep(3000);

        System.out.println("Inside Login page");
        // Assert.assertEquals(loginPage1.getPageTitle(), "");
    }

    @When("User enter valid userID")
    public void user_enter_valid_userID() {

        // driver.get("https://SG02410:Ajaypal1@contrib.peugeot.preprod.inetpsa.com/");
        // System.out.println("Username && Password");
        System.out.println("Username");
    }

    @Then("User should redirect to the home page")
    public void user_should_redirect_to_the_home_page() {

//        if (driver == null) {
//            System.out.println("driver is not initilized");
//        }
//        String a = driver.getCurrentUrl();
//        System.out.println("The current url is:" + a);
        System.out.println("Landed in home page");
    }

    @Then("user select the language")
    public void user_select_the_language() throws Exception {

        loginPage1.DropdownMethod();

    }

    @Then("user click on validate")
    public void user_click_on_validate() throws Exception {
        loginPage1.ValidationMethod();
    }

    @Then("user should able to see pa study")
    public void user_should_able_to_see_pa_study() throws Exception {

        loginPage1.MouseOver();
    }

}
