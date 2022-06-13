package com.sogeti.automation.test.pageFactory;

import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestPage extends PageClass {

    public TestPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MediumWait));
        PageFactory.initElements(driver, this);
    }
}
