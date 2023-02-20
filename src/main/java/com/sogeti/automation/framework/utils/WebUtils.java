package com.sogeti.automation.framework.utils;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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

    protected void refreshPage() {
        this._hDriver.navigate().refresh();
    }

    public String getPageTitle() {
        return _hDriver.getTitle();
    }

    protected void scrollIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) _hDriver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
        } catch (Exception e) {
            log.error("Unable to scroll into view of the element\n" + e.getMessage());
        }
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

    protected void closeWindow() {
        try {
            this._hDriver.close();
            log.info("Current window closed successfully.");
        } catch (Exception e) {
            log.error("Current window could not be closed.\n" + e.getMessage());
        }
    }

    protected void launchUrlInNewTab(String url) {
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

    protected void switchToNewTab() {
        ArrayList<String> tabList = new ArrayList<>(_hDriver.getWindowHandles());
        _hDriver.switchTo().window(tabList.get(1));
    }

    protected WebElement getWebLocator(String elementToken, String replacement) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected WebElement getWebLocator(String elementToken, int index) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", String.valueOf(index));
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected WebElement getWebLocator(String elementToken, String replacement, int row) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        elementToken = elementToken + "[" + row + "]";
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected WebElement getWebLocator(String elementToken, String replacement1, String replacement2) {
        elementToken = elementToken.replaceAll("\\&\\{.+\\}", replacement2);
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement1);
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElement(By.xpath(elementToken));
    }

    protected List<WebElement> getWebLocatorList(String elementToken, String replacement) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElements(By.xpath(elementToken));
    }

    protected List<WebElement> getWebLocatorList(String elementToken, String replacement, int row) {
        elementToken = elementToken.replaceAll("\\$\\{.+\\}", replacement);
        elementToken = elementToken + "[" + row + "]";
        scrollIntoView(_hDriver.findElement(By.xpath(elementToken)));

        return _hDriver.findElements(By.xpath(elementToken));
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoView(element);

        return element;
    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoView(element);
        return element;
    }

    protected List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected boolean waitForElementToBeInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected boolean waitForElementToBeInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean isElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)) != null;
    }

    protected boolean isElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
    }

    protected void selectByText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (NoSuchElementException ne) {
            log.error("Element not found\n" + ne.getMessage());
        } catch (Exception e) {
            log.error("Error in selecting value from dropdown of webelement\n" + e.getMessage());
        }
    }

    protected void selectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (IndexOutOfBoundsException ie) {
            log.error("Index is out of bounds\n" + ie.getMessage());
        } catch (NoSuchElementException ne) {
            log.error("Element not found\n" + ne.getMessage());
        } catch (Exception e) {
            log.error("Error in selecting value from dropdown of webelement\n" + e.getMessage());
        }
    }

    protected void selectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (NoSuchElementException ne) {
            log.error("Element not found\n" + ne.getMessage());
        } catch (Exception e) {
            log.error("Error in selecting value from dropdown of webelement\n" + e.getMessage());
        }
    }

    protected void switchToFrame(String frameIdOrName) {
        FluentWait<SelfHealingDriver> fluentWait = new FluentWait<>(_hDriver);
        try {
            fluentWait.withTimeout(Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT))
                    .pollingEvery(Duration.ofSeconds(FrameworkConstants.MINIMUM_WAIT))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
        } catch (Exception e) {
            log.error("Unable to switch to frame\n" + e.getMessage());
        }
    }

    protected void switchToFrame(int frameIndex) {
        FluentWait<SelfHealingDriver> fluentWait = new FluentWait<>(_hDriver);
        try {
            fluentWait.withTimeout(Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT))
                    .pollingEvery(Duration.ofSeconds(FrameworkConstants.MINIMUM_WAIT))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
        } catch (Exception e) {
            log.error("Unable to switch to frame\n" + e.getMessage());
        }

    }

    protected void switchToDefaultContent() {
        try {
            _hDriver.switchTo().defaultContent();
        } catch (Exception e) {
            log.error("Unable to switch to default content\n" + e.getMessage());
        }
    }

    protected void switchToParentWindow(String parentHandle) {
        try {
            _hDriver.switchTo().window(parentHandle);
        } catch (Exception e) {
            log.error("Unable to switch to parent window\n" + e.getMessage());
        }
    }

    protected void switchToChildWindow() {
        try {
            String parentHandle = _hDriver.getWindowHandle();

            for (String winHandle : _hDriver.getWindowHandles()) {
                _hDriver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            log.error("Unable to switch to child window\n" + e.getMessage());
        }
    }

    protected void closeAllChildWindows(String parentHandle) {
        _hDriver.switchTo().window(parentHandle);
        try {
            for (String winHandle : _hDriver.getWindowHandles())
                _hDriver.switchTo().window(winHandle).close();
        } catch (Exception e) {
            log.error("Unable to close child window\n" + e.getMessage());
        }
    }

    protected boolean waitForChildElementToBeVisible(WebElement element, By childLocator) {
        boolean status = false;
        FluentWait<SelfHealingDriver> fluentWait = new FluentWait<>(_hDriver);

        try {
            fluentWait.withTimeout(Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT))
                    .pollingEvery(Duration.ofSeconds(FrameworkConstants.MINIMUM_WAIT))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
            status = true;
        } catch (Exception e) {
            log.error("Failed to locate element\n" + e.getMessage());
        }

        return status;
    }
}
