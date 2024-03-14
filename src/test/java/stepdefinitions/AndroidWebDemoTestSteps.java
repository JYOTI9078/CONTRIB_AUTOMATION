package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.AndroidWebDemo_LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.ThreadContext;

public class AndroidWebDemoTestSteps extends TestClass {

    TestContext testContext;
    AndroidWebDemo_LoginPage androidWebDemoLoginPage;

    public AndroidWebDemoTestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        androidWebDemoLoginPage = testContext.getMobilePageObjectManager().getAndroidWebDemo_LoginPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }



    @Given("user opens the HobbyClues site")
    public void userOpensTheHobbyCluesSite() throws InterruptedException {
        androidWebDemoLoginPage.siteLoad();
        Thread.sleep(10000);

    }

    @Then("HobbyClues site is launched")
    public void hobbycluesSiteIsLaunched() throws InterruptedException {
        androidWebDemoLoginPage.isMainPageVisible();
        Thread.sleep(10000);
    }
}
