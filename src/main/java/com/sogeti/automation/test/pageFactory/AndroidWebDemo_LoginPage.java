package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidWebDemo_LoginPage extends PageClass {


    public AndroidWebDemo_LoginPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public void siteLoad() throws InterruptedException {
        _hDriver.get(AppConstants.Android.ANDROID_BASE_URL);
        Thread.sleep(10000);
    }

    public Boolean isMainPageVisible() {
        boolean flag = false;
        try {
            Thread.sleep(10000);
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
