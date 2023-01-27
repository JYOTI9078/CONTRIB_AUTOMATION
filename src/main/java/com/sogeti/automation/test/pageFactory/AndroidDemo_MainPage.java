package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidDemo_MainPage extends PageClass {

    @FindBy(className = "android.widget.TextView")
    private WebElement mainPage;

    public AndroidDemo_MainPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public Boolean isMainPageTitleVisible() {
        boolean flag = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(mainPage));
            if(mainPage.getText().equalsIgnoreCase("API Demos"))
                  flag = true;
        } catch (NoSuchElementException ne) {
            return false;
        } catch (Exception e) {
            log.error("Failed to check title of main page.\n" + e);
            return false;
        }
        return flag;
    }
}
