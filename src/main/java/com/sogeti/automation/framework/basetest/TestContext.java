package com.sogeti.automation.framework.basetest;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.test.pageFactory.PageObjectManager;

import java.io.IOException;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private TestClass testClass;
    private SelfHealingDriver healingDriver;
    String browser = null;

    public TestContext() throws IOException {
        this.testClass = new TestClass();
        if (AppConstants.INTERFACE_TYPE.equalsIgnoreCase("Web")) {
                this.healingDriver = testClass.setupEnvironment(browser);
                pageObjectManager = new PageObjectManager(healingDriver);
        }
    }

    public SelfHealingDriver getDriver() {
        return healingDriver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
