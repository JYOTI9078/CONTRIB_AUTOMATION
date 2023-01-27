package com.sogeti.automation.test.pageFactory;

import android.util.Log;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidNativeDemo_FileApp extends PageClass {

    @FindBy(id = "header_title")
    private WebElement header;

    @FindBy(id = "message")
    private WebElement message;

    public AndroidNativeDemo_FileApp(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public boolean appLoad() throws InterruptedException {
        boolean flag = false;
        if(header.isDisplayed())
        {
            flag = true;
        }

        return flag;
    }

    public String checkNumberOfFile() {
        String mess = message.getText();
        return mess;

    }


}
