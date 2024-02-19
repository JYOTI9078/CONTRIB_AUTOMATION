package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.test.pageFactory.AndroidDemo_MainPage;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class AndroidAppTestSteps extends TestClass {

    TestContext testContext;

    AndroidDemo_MainPage androidDemo_mainPage;


    public AndroidAppTestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        androidDemo_mainPage = testContext.getMobilePageObjectManager().getAndroidDemo_MainPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("^user has installed the apk$")
    public void mainPageLoad() throws InterruptedException {
        androidDemo_mainPage.isMainPageTitleVisible();
        Thread.sleep(5000);
        Assert.assertTrue(androidDemo_mainPage.isMainPageTitleVisible(),"Main Page is loaded");
    }

}
