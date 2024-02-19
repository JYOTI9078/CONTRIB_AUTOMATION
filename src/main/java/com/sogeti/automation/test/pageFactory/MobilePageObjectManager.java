package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.support.PageFactory;

public class MobilePageObjectManager {
     SelfHealingDriver aDriver;

    AndroidWebDemo_LoginPage androidWebDemoLoginPage;
    AndroidNativeDemo_FileApp androidNativeDemoFileApp;
    AndroidDemo_MainPage androidDemo_mainPage;
    EmpMgtDemo_LoginPage empLoginPage;
    EmpMgtDemo_AddEmpPage empAddPage;

    public MobilePageObjectManager(SelfHealingDriver aDriver) {
        this.aDriver = aDriver;
        PageFactory.initElements(aDriver, this);
    }

    public AndroidDemo_MainPage getAndroidDemo_MainPage() {
        return (androidDemo_mainPage == null) ? androidDemo_mainPage = new AndroidDemo_MainPage(aDriver) : androidDemo_mainPage;
    }


    public AndroidWebDemo_LoginPage getAndroidWebDemo_LoginPage() {
        return (androidWebDemoLoginPage == null) ? androidWebDemoLoginPage = new AndroidWebDemo_LoginPage(aDriver) : androidWebDemoLoginPage;
    }

    public AndroidNativeDemo_FileApp getAndroidNativeDemo_FileApp() {
        return (androidNativeDemoFileApp == null) ? androidNativeDemoFileApp = new AndroidNativeDemo_FileApp(aDriver) : androidNativeDemoFileApp;
    }

    public EmpMgtDemo_LoginPage getEmpMgtDemo_LoginPage() {
        return (empLoginPage == null) ? empLoginPage = new EmpMgtDemo_LoginPage(aDriver) : empLoginPage;
    }

    public EmpMgtDemo_AddEmpPage getEmpMgtDemo_AddEmpPage() {
        return (empAddPage == null) ? empAddPage = new EmpMgtDemo_AddEmpPage(aDriver) : empAddPage;
    }

}
