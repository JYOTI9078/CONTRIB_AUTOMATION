package com.sogeti.automation.framework.basetest;

import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.driver.GlobalDriver;
import com.sogeti.automation.framework.driver.TestListener;
import com.sogeti.automation.framework.utils.ExcelReader;
import com.sogeti.automation.framework.utils.Logging;
import com.sogeti.automation.framework.utils.PropertyReader;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.lang.reflect.Method;

@Listeners({TestListener.class})
public class TestClass {
//    protected ExcelReader data;
    protected GlobalDriver gDriver;
    protected WebDriver driver;
    protected String testEnvironment;
    protected String testURL;
//    protected String sheetName;
    protected Logging log = new Logging(this.getClass().getName());

    public TestClass() throws Exception {
        PropertyReader prop = new PropertyReader();
        String envName = System.getProperty("envName");
        prop.valueMap("Configs" + File.separator + envName + ".properties");
//        log.info("Reading execution parameters from " + envName + ".properties");
        ThreadContext.pop();
        ThreadContext.push(envName + ".properties");
        testEnvironment = PropertyReader.getFieldValue("TestEnvironment");
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriver setupEnvironment(String browser) {
        this.testURL = AppConstants.UI_BASE_URL;
        gDriver = new GlobalDriver();
        driver = gDriver.init(browser);
//        driver.manage().timeouts().getImplicitWaitTimeout().plusSeconds(FrameworkConstants.LargeWait);
        driver.get(testURL);

        return driver;
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        Thread thread = new Thread();
        thread.setName(method.getName());
        long th = thread.getId();
        ThreadContext.put("TestCase name ", thread.getName());
        ThreadContext.put("ThreadID", "ID-" + th);
        this.log.startTestCase(thread.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result, Method method) {
        Thread thread = new Thread();
        thread.setName(method.getName());
        this.log.info(result.toString());
        this.log.endTestCase(thread.getName());
    }

    @BeforeClass
    public void beforeClass() {
        Thread thread = new Thread();
        thread.setName(this.getClass().getSimpleName());
        long th = thread.getId();
        ThreadContext.put("TestCaseName", thread.getName());
        ThreadContext.put("ThreadID", "ID-" + th);
        this.log.info("BEFORE CLASS: " + thread.getName());
    }
}
