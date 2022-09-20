package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.test.pageFactory.PageClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;

public class CommonSteps extends TestClass {
    TestContext testContext;
    PageClass pageClass;

    public CommonSteps(TestContext context) throws Exception {
        this.testContext = context;
        if (AppConstants.INTERFACE_TYPE.equalsIgnoreCase("Web"))
            pageClass = testContext.getPageObjectManager().getCommonPage();

        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Before
    public void testSetup(Scenario name) {
        log.info("Scenario Name: " + name.getName());
    }

    @After
    public void tearDown(Scenario name) {
        if (pageClass != null)
            testContext.getDriver().quit();

        log.info("Execution status is: " + name.getStatus());
    }


    @AfterStep
    public void addScreenshot(Scenario name) {
        if (pageClass != null && testContext.getDriver() != null)
            pageClass.takeScreenshot(name);
    }

}
