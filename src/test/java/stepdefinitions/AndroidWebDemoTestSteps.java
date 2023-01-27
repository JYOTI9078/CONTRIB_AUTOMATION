package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.AndroidWebDemo_LoginPage;
import com.sogeti.automation.test.pageFactory.EmpMgtDemo_AddEmpPage;
import com.sogeti.automation.test.pageFactory.EmpMgtDemo_LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

import java.util.List;

public class AndroidWebDemoTestSteps extends TestClass {

    TestContext testContext;
    AndroidWebDemo_LoginPage androidWebDemoLoginPage;

    public AndroidWebDemoTestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        androidWebDemoLoginPage = testContext.getPageObjectManager().getAndroidWebDemo_LoginPage();
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
