package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    SelfHealingDriver healingDriver;
    PageClass pageClass;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;
    SelfHealDemoPage selfHealDemoPage;

    public PageObjectManager(SelfHealingDriver driver) {
        this.healingDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageClass getCommonPage() {
        return((pageClass == null) ? pageClass = new PageClass(healingDriver) : pageClass);
    }

    public SwagLabsDemo_LoginPage getSwagLabsDemo_LoginPage() {
        return (swagLabsDemoLoginPage == null) ? swagLabsDemoLoginPage = new SwagLabsDemo_LoginPage(healingDriver) : swagLabsDemoLoginPage;
    }

    public SwagLabsDemo_ProductsPage getSwagLabsDemo_ProductsPage() {
        return (swagLabsDemo_productsPage == null) ? swagLabsDemo_productsPage = new SwagLabsDemo_ProductsPage(healingDriver) : swagLabsDemo_productsPage;
    }

    public SelfHealDemoPage getSelfHealDemoPage() {
        return (selfHealDemoPage == null) ? selfHealDemoPage = new SelfHealDemoPage(healingDriver) : selfHealDemoPage;
    }
}
