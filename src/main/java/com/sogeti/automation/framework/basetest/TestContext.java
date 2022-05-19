package com.sogeti.automation.framework.basetest;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private TestClass testClass;
    private WebDriver gDriver;
    String browser = null;

    public TestContext() throws Exception {
        this.testClass = new TestClass();
    }

    public WebDriver getDriver() {
        return gDriver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
