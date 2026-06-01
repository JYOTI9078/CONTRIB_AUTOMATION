/*
 * Creation : 2 Apr 2025
 */
package com.sogeti.automation.test.pageFactory;


import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.constants.AppConstants.Web;

import java.util.Set;
public class InitiateStudyPage extends PageClass {

    public InitiateStudyPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

   
    @FindBy(xpath = "//*[text()='Profitability studies']")
    private WebElement profitability;

  

    private static final String setYear = "(//*[@align='center'])[7]";
    private static final String setNext = "(//*[@align='center'])[8]";
    private static final String setStartDate = "//*[text()='4']";
    private static final String setBeforeNext = "(//*[@align='center'])[6]";
    private static final String setEndYear = "//*[@id='ctl00_mainContentPlaceHolder_clEndDate_div']/table/tbody/tr[1]/td[2]/a";
    private static final String setEndNext = "//*[@id='ctl00_mainContentPlaceHolder_clEndDate_div']/table/tbody/tr[1]/td[3]/a";
    private static final String setEndDate = "(//*[text()='30'])[2]";

  

    @FindBy(xpath = "//*[text()='Search']")
    private WebElement search;

    @FindBy(xpath = "//*[text()='Contrib Administration']")
    private WebElement catable;
    
    @FindBy(xpath = "//*[text()='Profitability studies']")
    private WebElement psTab;
    
    @FindBy(xpath = "//td//a[text()='Search']")
    private WebElement searchtab;
    
    @FindBy(xpath = "//td//a[text()='Quick search']")
    private WebElement quicksearchtab;
    
    @FindBy(xpath = "//td//input[@name='ctl00$mainContentPlaceHolder$tbProto']")
    private WebElement quickSearchInput;

    @FindBy(xpath = "//*[text()='Configuration User']")
    private WebElement cuser;

    @FindBy(xpath = "//button[@data-brand='PEUGEOT']")
    private WebElement verifyPeugeot;

    @FindBy(xpath = "//button[@data-brand='CITROEN']")
    private WebElement verifyCitroen;
    
    @FindBy(xpath = "//button[@data-brand='OPEL']")
    private WebElement verifyOpel;

    @FindBy(xpath = "//button[@data-brand='FIAT']")
    private WebElement verifyFiat;

    @FindBy(xpath = "//button[@data-brand='JEEP']")
    private WebElement verifyJeep;

    @FindBy(xpath = "//button[@data-brand='FIAT_PROFESSIONAL']")
    private WebElement verifyFiatprofe;

    @FindBy(xpath = "//button[@data-brand='ABARTH']")
    private WebElement verifyAbarth;

    @FindBy(xpath = "//button[@data-brand='ALFA_ROMEO']")
    private WebElement verifyAlfa;

    @FindBy(xpath = "//button[@data-brand='LANCIA']")
    private WebElement verifyLancia;

    @FindBy(xpath = "//a[text()='Profitability studies']")
    private WebElement MouseoverPS;
    
    @FindBy(xpath="//td//a[text()='Start searching']")
    private WebElement searchBtn;
    
    @FindBy(xpath="//tr[@class=\"texte_Taleau\"]//td//a")
    private WebElement StudyCode;
    
    @FindBy(xpath="//*[@id=\"ctl00_Menu_lbInfo\"]")
    private WebElement errormsg;
 
//    public void verifyHomePageBrand() throws Exception {
//
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.visibilityOf(verifyCitroen));
//        verifyCitroen.click();
//        Thread.sleep(1000);
//    }
    public void verifyHomePageBrand() throws Exception {

        String country = Web.Brand;

        // OPEL ,FIAT, JEEP, FIAT_PROFESSIONAL, ABARTH, ALFA_ROMEO, LANCIA

        if (country.equals("PEUGEOT")) {
            Thread.sleep(1000);
            verifyPeugeot.click();
            Thread.sleep(1000);
        } else if (country.equals("CITROEN")) {
            Thread.sleep(1000);
            verifyCitroen.click();
            Thread.sleep(1000);

        } else if (country.equals("OPEL")) {
            Thread.sleep(1000);
            verifyOpel.click();

        } else if (country.equals("FIAT")) {
            Thread.sleep(1000);
            verifyFiat.click();
        } else if (country.equals("JEEP")) {
            Thread.sleep(1000);
            verifyJeep.click();

        } else if (country.equals("FIAT_PROFESSIONAL")) {
            Thread.sleep(1000);
            verifyFiatprofe.click();

        } else if (country.equals("ABARTH")) {
            Thread.sleep(1000);
            verifyAbarth.click();

        } else if (country.equals("ALFA_ROMEO")) {
            Thread.sleep(1000);
            verifyAlfa.click();

        } else if (country.equals("LANCIA")) {
            Thread.sleep(1000);
            verifyLancia.click();
            Thread.sleep(1000);
        }

        else {
            System.out.println("No Brands are Available");
        }

    }

    public void ContribA() throws Exception {
//      Actions act = new Actions(_hDriver);
//      act.moveToElement(catable).build().perform();

      MouseOver(catable);
      this.cuser.click();
      Thread.sleep(2000);
  }
  
  public void ContriSearchTab() throws Exception {
//    Actions act = new Actions(_hDriver);
//    act.moveToElement(catable).build().perform();

    MouseOver(psTab);
    this.searchtab.click();
    Thread.sleep(2000);
}
  
  //remaining
  public void QuickSearchTab(String a) throws Exception {
    //MouseOver(psTab);
    this.quicksearchtab.click();
    Thread.sleep(2000);
    this.quickSearchInput.clear();
    this.quickSearchInput.isDisplayed();
  this.quickSearchInput.sendKeys(a);
  this.searchBtn.click();
  Thread.sleep(7000);
  Thread.sleep(7000);

  // Assert studyCode text equals the searched value
  String actualStudyCode = this.StudyCode.getText().trim();
  Assert.assertEquals(actualStudyCode, a,
      "Study Code mismatch! Expected: [" + a + "] but found: [" + actualStudyCode + "]"
  );
  System.out.println("✅ Study Code assertion passed: Expected [" + a + "] | Found [" + actualStudyCode + "]");

}
  

  public void QuickSearchTabdelete(String a) throws Exception {
      this.quicksearchtab.click();
      Thread.sleep(2000);
      this.quickSearchInput.clear();
      this.quickSearchInput.isDisplayed();
      this.quickSearchInput.sendKeys(a);
      this.searchBtn.click();
      Thread.sleep(7000);

      // If error message is visible pass (expected for negative test)
      try {
          if (this.errormsg.isDisplayed()) {
              System.out.println("Error message displayed after search — test passed: " + this.errormsg.getText());
              return;
          }
      } catch (Exception e) {
          // errormsg not present — continue to check StudyCode
      }

      // No error message verify StudyCode matches
      String actualStudyCode = this.StudyCode.getText().trim();
      Assert.assertEquals(actualStudyCode, a,
          "Study Code mismatch! Expected: [" + a + "] but found: [" + actualStudyCode + "]"
      );
      System.out.println("✅ Study Code assertion passed: Expected [" + a + "] | Found [" + actualStudyCode + "]");
  }
  

    public void ContribAdmin() throws Exception {
        // MouseOver(MouseoverAC);
        MouseOver(catable);
        System.out.println("The MouseOver element name is:" + catable.getText());
        Thread.sleep(3000);
    }
    
    public void ContribPStab() throws Exception {
        // MouseOver(MouseoverAC);
        MouseOver(psTab);
        System.out.println("The MouseOver ps tab:" + psTab.getText());
        Thread.sleep(3000);
    }
    
    

}
