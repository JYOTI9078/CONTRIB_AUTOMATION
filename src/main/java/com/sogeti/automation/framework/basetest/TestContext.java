package com.sogeti.automation.framework.basetest;

import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.test.pageFactory.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private TestClass testClass;
    private WebDriver driver;
    String browser = null;

    public TestContext() throws Exception {
        this.testClass = new TestClass();
        if (AppConstants.INTERFACE_TYPE.equalsIgnoreCase("Web")) {
            this.driver = testClass.setupEnvironment(browser);
            pageObjectManager = new PageObjectManager(driver);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
