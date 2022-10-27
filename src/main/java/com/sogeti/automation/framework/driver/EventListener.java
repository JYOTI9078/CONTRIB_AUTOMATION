package com.sogeti.automation.framework.driver;

import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.utils.Logging;
import com.sogeti.automation.framework.utils.Screenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;
import java.time.Duration;

public class EventListener extends AbstractWebDriverEventListener {
    Screenshot ss;
    private Logging log = new Logging(super.getClass().getSimpleName());

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.LARGE_WAIT));
        long tStart = System.currentTimeMillis();
        long maxWaitSeconds = FrameworkConstants.LARGE_WAIT;

        while (true) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                this.hold();
                break;
            } catch (WebDriverException var11) {
                long tElapsed = System.currentTimeMillis() - tStart;
                tElapsed /= FrameworkConstants.MAXIMUM_WAIT;
                log.warn("Waiting for ExpectedCondition (Element to be clickable): " + tElapsed
                        + " seconds elapsed out of " + maxWaitSeconds);
                if (tElapsed > maxWaitSeconds) { break; }
            }
        }

        this.log.info("Attempting to click: '" + element + "'");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        this.waitForAjax(driver, FrameworkConstants.MEDIUM_WAIT);
        this.log.info("Successful click on: '" + element + "'");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        this.waitForAjax(driver, FrameworkConstants.MEDIUM_WAIT);
        this.log.info("Attempting to locate: '" + by + "'");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        this.log.info("Located: '" + by + "'");
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        this.log.info("Attempting to execute script: '" + script + "' on driver '" + driver + "'");
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        this.log.info("Successful script execution: '" + script + "' on driver '" + driver + "'");
    }

    public void hold() {
        try {
            Thread.sleep(FrameworkConstants.MAXIMUM_WAIT);
        } catch (InterruptedException ie) {
            this.log.error(ie.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private int getAjaxCount(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            String res = js.executeScript("return jQuery.active").toString();
            this.log.info("." + res + ".");
            return Integer.parseInt(res);
        } catch (WebDriverException var4) {
            return js.executeScript("return document.readyState").equals("complete") ? 0 : 1;
        } catch (NumberFormatException nfe) {
            this.log.error(nfe.getMessage());
            return js.executeScript("return document.readyState").equals("complete") ? 0 : 1;
        }
    }

    void waitForAjax(WebDriver driver, int maxWaitInSecond) {
        long tStart = System.currentTimeMillis();
        long tElapsed;

        do {
            try {
                if (this.getAjaxCount(driver) == 0) {
                    break;
                }
                this.hold();
            } catch (WebDriverException var8) {
                do {
                    this.hold();
                    tElapsed = System.currentTimeMillis() - tStart;
                    tElapsed /= FrameworkConstants.MAXIMUM_WAIT;
                    this.log.warn("<<JS Error>> Waiting for max time: " + tElapsed + " seconds elapsed out of "
                            + maxWaitInSecond);
                } while (tElapsed <= (long) maxWaitInSecond);

                return;
            }

            tElapsed = System.currentTimeMillis() - tStart;
            tElapsed /= FrameworkConstants.MAXIMUM_WAIT;
            this.log.info("Waiting for ajax: " + tElapsed + " seconds elapsed out of " + maxWaitInSecond);
        } while (tElapsed <= (long) maxWaitInSecond);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        ITestResult testResult = Reporter.getCurrentTestResult();
        String ex = throwable.getClass().toString().trim().substring(6);
        this.log.error(ex);

        if (AppConstants.Web.SCREENSHOT_ENABLE.equalsIgnoreCase("true")) {
            this.ss = new Screenshot(driver);

            try {
                this.ss.setPathTakeScreenshot(testResult);
            } catch (IOException var6) {
                this.log.error("Unable to take screenshot.\n" + var6.getMessage());
            }
        }
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        waitForAjax(driver, FrameworkConstants.LARGE_WAIT);
        log.info("Attempting to locate: '" + element + "'");
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        log.info("Successful get text on: '" + element + "'");
    }
}
