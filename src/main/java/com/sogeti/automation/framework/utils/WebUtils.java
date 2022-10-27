package com.sogeti.automation.framework.utils;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUtils {

    protected SelfHealingDriver _hDriver;
    protected WebDriverWait wait;

    protected Logging log = new Logging(this.getClass().getName());

    public WebUtils(SelfHealingDriver driver) {
        this._hDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
        PageFactory.initElements(driver, this);
    }

    public void refreshPage() {
        this._hDriver.navigate().refresh();
    }

    public String getPageTitle() {
        return _hDriver.getTitle();
    }

    public void takeScreenshot(Scenario name) {
        final byte[] screenshot;

        try {
            screenshot = ((TakesScreenshot) _hDriver.getDelegate()).getScreenshotAs(OutputType.BYTES);
            name.attach(screenshot, "image/png", name.getName());
        } catch (Exception e) {
            log.error("Could not capture screenshot.\n" + e.getMessage());
        }
    }

    public void takeScreenshotForFailedTestCases(Scenario name) {
        final byte[] screenshot;

        if (name.isFailed()) {
            try {
                screenshot = ((TakesScreenshot) _hDriver.getDelegate()).getScreenshotAs(OutputType.BYTES);
                name.attach(screenshot, "image/png", name.getName());
            } catch (Exception e) {
                log.error("Could not capture screenshot.\n" + e.getMessage());
            }
        }
    }

    public void closeWindow() {
        try {
            this._hDriver.close();
            log.info("Current window closed successfully.");
        } catch (Exception e) {
            log.error("Current window could not be closed.\n" + e.getMessage());
        }
    }

    public void launchUrlInNewTab(String url) {
        try {
            String link = "window.open('" + url + "');";
            ((JavascriptExecutor) _hDriver).executeScript(link);
            log.info("Open new tab by pressing Ctrl+T");
        } catch (NoSuchWindowException ns) {
            log.error("No window exist.\n" + ns.getMessage());
        } catch (Exception e) {
            log.error("Error occurred while opening new tab.\n" + e.getMessage());
        }
    }

    protected WebElement getWebLocator(String elementToken, String replacement) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected WebElement getWebLocator(String elementToken, String replacement, int row) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        elementToken = elementToken + "[" + row + "]";

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected List<WebElement> getWebLocatorList(String elementToken, String replacement) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);

        return _hDriver.findElements(By.xpath(elementToken));
    }

    protected List<WebElement> getWebLocatorList(String elementToken, String replacement, int row) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        elementToken = elementToken + "[" + row + "]";

        return _hDriver.findElements(By.xpath(elementToken));
    }
}
