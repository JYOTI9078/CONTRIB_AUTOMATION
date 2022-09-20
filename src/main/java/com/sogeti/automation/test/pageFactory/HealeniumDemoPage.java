package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HealeniumDemoPage extends PageClass{

    @FindBy(xpath = "//input[@type='text'][@placeholder='Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@type='text'][@placeholder='You Surname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@type='tel'][@placeholder='You Phone']")
    private WebElement mobile;

    @FindBy(xpath = "//input[@type='text'][@placeholder='Your E-mail']")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//div[contains(@class,'successbox')]")
    private WebElement msgSuccess;

    @FindBy(xpath = "//p[contains(@class,'rule-error-req')]")
    private WebElement msgError;

    public HealeniumDemoPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MediumWait));
        PageFactory.initElements(driver, this);
    }

    public HealeniumDemoPage enterFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        log.info("Entered first name");
        return this;
    }

    public HealeniumDemoPage enterLastName(String surname) {
        this.lastName.clear();
        this.lastName.sendKeys(surname);
        log.info("Entered last name");
        return this;
    }

    public HealeniumDemoPage enterMobile(String mobile) {
        this.mobile.clear();
        this.mobile.sendKeys(mobile);
        log.info("Entered mobile number");
        return this;
    }

    public HealeniumDemoPage enterEmail(String emailId) {
        this.email.clear();
        this.email.sendKeys(emailId);
        log.info("Entered e-mail id");
        return this;
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
        log.info("Clicked on Submit button");
    }
}
