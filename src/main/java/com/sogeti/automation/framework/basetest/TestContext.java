package com.sogeti.automation.framework.basetest;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.test.pageFactory.MobilePageObjectManager;
import com.sogeti.automation.test.pageFactory.PageObjectManager;

public class TestContext {
    private PageObjectManager pageObjectManager;
    private MobilePageObjectManager mobilePageObjectManager;
    private final TestClass testClass;
    private SelfHealingDriver healingDriver;
    String browser = null;
    String url = null;

    public TestContext() throws Exception {
        this.testClass = new TestClass();
        if (AppConstants.INTERFACE_TYPE.equalsIgnoreCase("Web")) {
            this.healingDriver = testClass.setupEnvironment(browser);
            pageObjectManager = new PageObjectManager(healingDriver);
        }
        else if (AppConstants.INTERFACE_TYPE.equalsIgnoreCase("Mobile")) {

            this.healingDriver = testClass.setup_Environment(url);
            mobilePageObjectManager = new MobilePageObjectManager(healingDriver);
        }
    }

    public SelfHealingDriver getDriver() {
        return healingDriver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public MobilePageObjectManager getMobilePageObjectManager() {
        return mobilePageObjectManager;
    }
}
