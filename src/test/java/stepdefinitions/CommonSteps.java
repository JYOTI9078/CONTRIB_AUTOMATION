package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonSteps extends TestClass {
    TestContext testContext;
    public CommonSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
    }

    @Before
    public void testSetup(Scenario name) {
        log.info("The Test Scenario id: " + name.getName());
    }

    @After
    public void tearDown(Scenario name) {
        testContext.getDriver().quit();
        log.info("Execution status is: " + name.getStatus());
    }
}
