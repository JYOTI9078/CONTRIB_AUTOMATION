/*
 * Creation : 2 Apr 2025
 */
package com.sogeti.automation.test.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class LoginPage1 extends PageClass {

    public LoginPage1(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$ddlLanguage']")
    private WebElement dropd;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_litlnkBtnValidate']")
    private WebElement validate;

    @FindBy(xpath = "//*[text()='Profitability studies']")
    private WebElement profitability;

    public void DropdownMethod() throws Exception {
//        WebElement drop = _hDriver.
        this.dropd.click();

        Select sel = new Select(dropd);

        sel.selectByValue("en");

        System.out.println("The selected language is:" + sel.getFirstSelectedOption().getText());
        Thread.sleep(2000);

    }

    public void ValidationMethod() throws Exception {

        this.validate.click();
        Thread.sleep(2000);
    }

    public void MouseOver() throws Exception {

        Actions act = new Actions(_hDriver);
        act.moveToElement(profitability).build().perform();
        System.out.println("The Mouse element name is:" + profitability.getText());
        Thread.sleep(3000);

    }

}
