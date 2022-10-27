package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsDemo_LoginPage extends PageClass {

    @FindBy(id = "user-name")
    private WebElement txtUserName;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public SwagLabsDemo_LoginPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
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
