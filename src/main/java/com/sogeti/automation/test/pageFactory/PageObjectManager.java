package com.sogeti.automation.test.pageFactory;

import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;

public class PageObjectManager {
    SelfHealingDriver healingDriver;
    PageClass pageClass;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;
    SelfHealDemoPage selfHealDemoPage;
    LoginPage1 loginPage1;
    PS_CreationPage pS_CreationPage;
    ContribApplicationMaintenancePage contribApplicationMaintenancePage;
    InitiateStudyPage initiateSPage;
//    PS_CreationOVPage pS_CreationOVPage;
//    PS_CreationOVPage pS_Creation2Page;

    public PageObjectManager(SelfHealingDriver driver) {
        this.healingDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageClass getCommonPage() {
        return ((pageClass == null) ? pageClass = new PageClass(healingDriver) : pageClass);
    }

    public SwagLabsDemo_LoginPage getSwagLabsDemo_LoginPage() {
        return (swagLabsDemoLoginPage == null) ? swagLabsDemoLoginPage = new SwagLabsDemo_LoginPage(healingDriver) : swagLabsDemoLoginPage;
    }

    public SwagLabsDemo_ProductsPage getSwagLabsDemo_ProductsPage() {
        return (swagLabsDemo_productsPage == null) ? swagLabsDemo_productsPage = new SwagLabsDemo_ProductsPage(healingDriver)
                : swagLabsDemo_productsPage;
    }

    public SelfHealDemoPage getSelfHealDemoPage() {
        return (selfHealDemoPage == null) ? selfHealDemoPage = new SelfHealDemoPage(healingDriver) : selfHealDemoPage;
    }

    public LoginPage1 getLoginPage1() {
        return (loginPage1 == null) ? loginPage1 = new LoginPage1(healingDriver) : loginPage1;

    }

    public PS_CreationPage getpS_CreationPage() {
        return (pS_CreationPage == null) ? pS_CreationPage = new PS_CreationPage(healingDriver) : pS_CreationPage;

    }
    public InitiateStudyPage getinitiateStudy() {
        return (initiateSPage == null) ? initiateSPage = new InitiateStudyPage(healingDriver) : initiateSPage;
 
    }
 

    // public PS_CreationOVPage getpS_CreationOVPage() {
    // return (pS_CreationOVPage == null) ? pS_CreationOVPage = new PS_CreationOVPage(healingDriver) : pS_CreationOVPage;

    // }

//    public PS_CreationOVPage getpS_CreationOVPage() {
//
//        return (pS_CreationOVPage == null) ? pS_CreationOVPage = new PS_CreationOVPage(healingDriver) : pS_CreationOVPage;
//    }

//    public PS_Creation2Page getpS_Creation2Page() {
//        return (pS_Creation2Page == null) ? pS_Creation2Page = new PS_Creation2Page(healingDriver) : pS_Creation2Page;
//
//    }

    public ContribApplicationMaintenancePage getcontribApplicationMaintenancePage() {
        return (contribApplicationMaintenancePage == null) ? contribApplicationMaintenancePage = new ContribApplicationMaintenancePage(healingDriver)
                : contribApplicationMaintenancePage;

    }

}