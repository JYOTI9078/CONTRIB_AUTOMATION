package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.AndroidNativeDemo_FileApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class AndroidNativeDemoTestSteps extends TestClass {

    TestContext testContext;
    AndroidNativeDemo_FileApp androidNativeDemoFileApp;

    public AndroidNativeDemoTestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        androidNativeDemoFileApp = testContext.getMobilePageObjectManager().getAndroidNativeDemo_FileApp();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }


    @Given("user opens the File App")
    public void userOpensTheFileApp() throws InterruptedException {
        Assert.assertTrue(androidNativeDemoFileApp.appLoad(), "Application is not loaded");
    }

    @Then("file page displays the number of files")
    public void filePageDisplaysTheNumberOfFiles() {
        String message = androidNativeDemoFileApp.checkNumberOfFile();
        log.info(message);
    }
}
