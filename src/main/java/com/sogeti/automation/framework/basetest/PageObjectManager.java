package com.sogeti.automation.framework.basetest;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver gDriver;

    public PageObjectManager(WebDriver driver) {
        this.gDriver = driver;
    }
}
