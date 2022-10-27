package com.sogeti.automation.framework.basetest;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.driver.GlobalDriver;
import com.sogeti.automation.framework.driver.TestListener;
import com.sogeti.automation.framework.utils.Logging;
import com.sogeti.automation.framework.utils.PropertyReader;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

@Listeners({TestListener.class})
public class TestClass {
//    protected ExcelReader data;
    protected GlobalDriver gDriver;
    protected SelfHealingDriver healingDriver;
    protected String testEnvironment;
    protected String testURL;
//    protected String sheetName;
    protected Logging log = new Logging(this.getClass().getName());

    public TestClass() throws IOException {
        PropertyReader prop = new PropertyReader();
        String envName = System.getProperty("envName");
        prop.valueMap("Configs" + File.separator + envName + ".properties");
        ThreadContext.pop();
        ThreadContext.push(envName + ".properties");
        testEnvironment = PropertyReader.getFieldValue("TestEnvironment");
    }

    public SelfHealingDriver getDriver() {
        return this.healingDriver;
    }

    public SelfHealingDriver setupEnvironment(String browser) {
        this.testURL = AppConstants.Web.UI_BASE_URL;
        gDriver = new GlobalDriver();
        this.log.info("Initializing self healing driver");
        healingDriver = gDriver.init(browser);
        healingDriver.get(testURL);

        return healingDriver;
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
