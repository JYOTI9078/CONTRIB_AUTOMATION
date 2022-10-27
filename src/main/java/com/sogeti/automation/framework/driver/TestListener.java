package com.sogeti.automation.framework.driver;

import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.utils.Logging;
import com.sogeti.automation.framework.utils.PropertyReader;
import com.sogeti.automation.framework.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestListener implements ITestListener {
    protected Logging log = new Logging(this.getClass().getName());

    public Screenshot initSS(WebDriver d) {
        return new Screenshot(d);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        this.log.error(result.toString());
        if (AppConstants.Web.SCREENSHOT_ENABLE.equalsIgnoreCase("true")) {
            WebDriver driver = this.findWebDriverByReflection(result);
            if (driver != null) {
                try {
                    this.initSS(driver).setPathTakeScreenshot(result);
                } catch (IOException ie) {
                    this.log.error(ie.getMessage());
                }
            }
        }
    }

    public WebDriver findWebDriverByReflection(ITestResult result) {
        WebDriver driver = null;
        Class<?> c = result.getInstance().getClass();
        Method[] methods = c.getMethods();
        Method[] arr = methods;
        int len = methods.length;

        for (int i = 0; i < len; ++i) {
            Method eachMethod = arr[i];
            if (eachMethod.getReturnType() == WebDriver.class) {
                try {
                    driver = (WebDriver) eachMethod.invoke(result.getInstance());
                } catch (Exception e) {
                    this.log.error("COULD NOT FIND THE WEBDRIVER.");
                    return null;
                }
            }
        }

        return driver;
    }

    @Override
    public void onTestStart(ITestResult result) {
        this.log.info(result.toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.log.info(result.toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        this.log.warn(result.toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        this.log.warn(result.toString());
        if (AppConstants.Web.SCREENSHOT_ENABLE.equalsIgnoreCase("true")) {
            WebDriver driver = this.findWebDriverByReflection(result);
            if (driver != null) {
                try {
                    this.initSS(driver).setPathTakeScreenshot(result);
                } catch (IOException ie) {
                    this.log.error(ie.getMessage());
                }
            }
        }
    }

    @Override
    public void onStart(ITestContext context) {
        this.log.info(context.toString());
    }

    @Override
    public void onFinish(ITestContext context) {
        this.log.info(context.toString());
    }
}
