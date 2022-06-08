package com.sogeti.automation.test.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    WebDriver gDriver;

    public PageObjectManager(WebDriver driver) {
        this.gDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
