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

public class EmpMgtDemo_LoginPage extends PageClass {

    @FindBy(id = "et_username_field")
    private WebElement txtUserName;

    @FindBy(id = "et_password_field")
    private WebElement txtPassword;

    @FindBy(id = "btn_login")
    private WebElement btnLogin;

    public EmpMgtDemo_LoginPage(SelfHealingDriver _hdriver) {
        super(_hdriver);
        wait = new WebDriverWait(_hdriver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(_hdriver, this);
    }

    public Boolean isMainPageVisible() {
        boolean flag = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(txtUserName));
             flag = true;
        } catch (NoSuchElementException ne) {
            return false;
        } catch (Exception e) {
            log.error("Failed to check title of main page.\n" + e);
            return false;
        }
        return flag;
    }

    public void login(String userName , String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(txtUserName));
            txtUserName.clear();
            txtUserName.sendKeys(userName);
            log.info("Entered username");
        } catch (Exception e) {
            log.error("Failed to enter username.\n" + e);
        }

        try {
            txtPassword.clear();
            txtPassword.sendKeys(password);
            log.info("Entered password");
        } catch (Exception e) {
            log.error("Failed to enter password.\n" + e);
        }

        try {
            btnLogin.click();
        } catch (Exception e) {
            log.error("Failed to click Login button.\n" + e);
        }
    }
}
