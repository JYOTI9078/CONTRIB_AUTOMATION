package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.TestPage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class TestSteps extends TestClass {

    TestContext testContext;
    TestPage testPage;


    public TestSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
        testPage = testContext.getPageObjectManager().getTestPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("^user opens Konakart application in browser$")
    public void openGoogle() throws InterruptedException {
        Thread.sleep(5000);
    }
}
