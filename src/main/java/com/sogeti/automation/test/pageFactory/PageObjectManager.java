package com.sogeti.automation.test.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    WebDriver gDriver;
    PageClass pageClass;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;

    public PageObjectManager(WebDriver driver) {
        this.gDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageClass getCommonPage() {
        return(pageClass == null) ? pageClass = new PageClass(gDriver) : pageClass;
    }

    public SwagLabsDemo_LoginPage getSwagLabsDemo_LoginPage() {
        return (swagLabsDemoLoginPage == null) ? swagLabsDemoLoginPage = new SwagLabsDemo_LoginPage(gDriver) : swagLabsDemoLoginPage;
    }

    public SwagLabsDemo_ProductsPage getSwagLabsDemo_ProductsPage() {
        return (swagLabsDemo_productsPage == null) ? swagLabsDemo_productsPage = new SwagLabsDemo_ProductsPage(gDriver) : swagLabsDemo_productsPage;
    }
}
