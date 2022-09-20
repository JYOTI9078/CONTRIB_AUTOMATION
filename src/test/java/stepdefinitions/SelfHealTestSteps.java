package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.SelfHealDemoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class SelfHealTestSteps extends TestClass {

    TestContext testContext;
    SelfHealDemoPage selfHealDemoPage;

    public SelfHealTestSteps(TestContext context) throws Exception {
        this.testContext = context;
        selfHealDemoPage = testContext.getPageObjectManager().getSelfHealDemoPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("^user in on Credit-Card application page$")
    public void verifyPageLoad() {
        Assert.assertEquals(selfHealDemoPage.getPageTitle(),"credit-card-step",
                "Page Title does not match the expected value.");
    }

    @When("^user enters his details - (.*), (.*), (.*) and (.*)$")
    public void enterDetails(String firstName, String surname, String mobile, String email) {
        selfHealDemoPage.enterFirstName(firstName)
                .enterLastName(surname)
                .enterMobile(mobile)
                .enterEmail(email)
                .clickSubmit();
    }
}
