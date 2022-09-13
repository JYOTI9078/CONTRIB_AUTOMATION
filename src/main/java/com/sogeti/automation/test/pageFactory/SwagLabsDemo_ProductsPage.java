package com.sogeti.automation.test.pageFactory;

import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsDemo_ProductsPage extends PageClass {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement lblProductsTitle;

    private String productName = "//div[text()='${labelName}']";
    private String productPrice = "//div[text()='${labelName}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";

    public SwagLabsDemo_ProductsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MediumWait));
        PageFactory.initElements(driver, this);
    }

    public Boolean isProductsTitleVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(lblProductsTitle));
            return true;
        } catch (NoSuchElementException ne) {
            return false;
        } catch (Exception e) {
            log.error("Failed to check title of Products page.\n" + e);
            return false;
        }
    }

    public String getProductName(String product) {
        try {
            return getWebLocator(productName, product).getText();
        } catch (Exception e) {
            log.error("Product '" + product + "' not found.");
            return e.getMessage();
        }
    }

    public String getProductPrice(String product) {
        try {
            return getWebLocator(productPrice, product).getText();
        } catch (Exception e) {
            log.error("Product '" + product + "' not found.\n" + e);
            return e.getMessage();
        }
    }
}
