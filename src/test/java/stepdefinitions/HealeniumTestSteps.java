package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.HealeniumDemoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class HealeniumTestSteps extends TestClass {

    TestContext testContext;
    HealeniumDemoPage healeniumDemoPage;

    public HealeniumTestSteps(TestContext context) throws Exception {
        this.testContext = context;
        healeniumDemoPage = testContext.getPageObjectManager().getHealeniumDemoPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("^user in on Credit-Card application page$")
    public void verifyPageLoad() {
        Assert.assertEquals(healeniumDemoPage.getPageTitle(),"credit-card-step",
                "Page Title does not match the expected value.");
    }

    @When("^user enters his details - (.*), (.*), (.*) and (.*)$")
    public void enterDetails(String firstName, String surname, String mobile, String email) {
        healeniumDemoPage.enterFirstName(firstName)
                .enterLastName(surname)
                .enterMobile(mobile)
                .enterEmail(email)
                .clickSubmit();
    }
}
