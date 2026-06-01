/*
 * Creation : 2 Apr 2025
 */
package com.sogeti.automation.test.pageFactory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.framework.constants.FrameworkConstants;

import io.netty.util.internal.ThreadLocalRandom;

public class PS_CreationPage extends PageClass {

    public PS_CreationPage(SelfHealingDriver _hDriver) {
        super(_hDriver);
        wait = new WebDriverWait(_hDriver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(_hDriver, this);
    }

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$ddlLanguage']")
    private WebElement dropd;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_litlnkBtnValidate']")
    private WebElement validate;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_imgAuto']")
    private WebElement Vehiclepic;

    @FindBy(xpath = "(//*[@class='texte_vignette'])[1]")
    private WebElement Text;

    @FindBy(xpath = "//*[text()='Profitability studies']")
    private WebElement profitability;

    @FindBy(xpath = "//*[text()='Creation']")
    private WebElement creation;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxCountry']")
    private WebElement country;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxCountry']/option")
    private List<WebElement> country1;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxClient']")
    private WebElement client;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxClient']/option")
    private List<WebElement> client1;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxClient']/option")
    private List<WebElement> client2;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$tbIdStatus']")
    private WebElement Statuss;

    @FindBy(xpath = "//a[contains(@href, 'clStartDate_Up_CallClick')]")
    private WebElement startingdate;// (//a[@href])[35]

    private static final String setYear = "(//*[@align='center'])[7]";
    private static final String setNext = "(//*[@align='center'])[8]";
    private static final String setStartDate = "//*[text()='4']";
    private static final String setBeforeNext = "(//*[@align='center'])[6]";

    @FindBy(xpath = "//a[contains(@href, 'clEndDate_Up_CallClick')]")
    private WebElement endingdate;// (//a[@href])[36]

    private static final String setEndYear = "(//*[@align='center'])[7]";
    private static final String setEndNext = "(//*[@align='center'])[8]";
    private static final String setEndDate = "(//*[text()='30'])[2]";

    @FindBy(xpath = "//input[@name='ctl00$mainContentPlaceHolder$clStartDate']")
    private WebElement ValidSdate;

    @FindBy(xpath = "//input[@name='ctl00$mainContentPlaceHolder$clEndDate']")
    private WebElement ValidEdate;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement Validation;

    @FindBy(xpath = "//select[@name='ctl00$mainContentPlaceHolder$lbxFamily']")
    private WebElement modelrange;

    @FindBy(xpath = "//select[@name='ctl00$mainContentPlaceHolder$lbxFamily']/option")
    private List<WebElement> modelrange1;

    // String range = "1PP5&DE";
    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxModelYear']/option")
    private List<WebElement> validateversion;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxModelYear']/option")
    private List<WebElement> validateversion1;

    // String value = "TODAY";

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnSearch']")
    private WebElement searchvalidation;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_htmlTabVersionList']")
    private WebElement table;

//    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$dtgVersion$ctl05$cbVersion']")
//    private WebElement selectcheckbox;

//    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_htmlTabVersionList']/tbody[1]//input[@type='checkbox']")
//    private WebElement ListCheckbox;

    @FindBy(xpath = "(//td[normalize-space(text()='')]/preceding-sibling::td//input[@type='checkbox'])[position() > 1]")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnViewBasket']")
    private WebElement addbasket;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgVersion_ctl03_lnkBtnEditOptions']")
    private WebElement Options;

    @FindBy(xpath = "//td[normalize-space(text())='']/preceding-sibling::td//input[@type='checkbox']")
    private List<WebElement> optionsCode;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement ValidateOptions;

    @FindBy(xpath = "//td[normalize-space(text())='']/preceding-sibling::td//input[@type='checkbox']")
    private List<WebElement> versionTexts;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnAddVersions']")
    private WebElement AddVersions;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$EditProtocol$ddlTypeFacturation']")
    private WebElement SelectOption;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$EditProtocol$ddlCanalB2B']")
    private WebElement SelectB2b;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$VersionDetail$tbVolume']")
    private WebElement volume;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnPasdeBonusIntCliVol2']")
    private WebElement Internbonus;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnPasdeBonusNatCliVol']")
    private WebElement Nationalbonus;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnPasdeBonusNatCliGam']")
    private WebElement rangebonus;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnPasdeBonusNatLouVol']")
    private WebElement lasear;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_chkSaveBrouillon']")
    private WebElement draft;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnSaveDbBak']")
    private WebElement savepfstudy;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocol_lbProtocol']")
    private WebElement PFstudynum;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_ddlType']")
    private WebElement SelectExport;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnExport']")

    private WebElement ClickExport;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnModifyProtocol']")
    private WebElement Modifybtn;
//    @FindBy(xpath = "//*[text()='Modify this profitability study']")
//    private WebElement Modifybtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnAddVersion']")
    private WebElement addversion;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocol_lbProtocol']")
    private WebElement pfs;
    String pfss;

    @FindBy(xpath = "//*[text()='Search']")
    private WebElement search;

    @FindBy(xpath = "//*[@id='ctl00_Menu_lbInfo']")
    private WebElement pftext;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnRechercheRapide']")
    private WebElement Quicks;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$tbProto']")
    private WebElement Pfsnumbers;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnSearchLaunch']")
    private WebElement Startsearch;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_dtgProtocols_ctl03_lnkBtnProtocolCode']")
    private WebElement storePfsNo;

    public static String pfsNumber;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgProtocols_ctl03_lnkBtnProtocolCode']")
    private WebElement Selectcode;

    @FindBy(xpath = "//*[text()='Reference table']")
    private WebElement rtable;

    @FindBy(xpath = "//*[text()='Subsidiary Data']")
    private WebElement sbdata;

//    @FindBy(xpath = "//select[@id='ctl00_mainContentPlaceHolder_ddlCountry']/option")
//    private List<WebElement> rcountry;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$ddlCountry']")
    private WebElement scountry;

    @FindBy(xpath = "//*[text()='Taux prévisionnels_GB']")
    private WebElement prate;

    @FindBy(xpath = "// *[@id='ctl00_mainContentPlaceHolder_tbRechercher']")
    private WebElement searchpr;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnRechercher']")
    private WebElement searchprc;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnAddRow']")
    private WebElement addlines;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement validatepr;

    @FindBy(xpath = "//*[text()='Network remuneration']")
    private WebElement nremuneration;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnNouveau']")
    private WebElement CnewLine;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlCountry']")
    private WebElement countrynrre;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlFamily']/option")
    private List<WebElement> rangenrr;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxEngine']/option")
    private List<WebElement> enginerrr;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbPrimePerformance']")
    private WebElement Percentage;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbMontantPrimePerformance']")
    private WebElement amount;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValider']")
    private WebElement Validatenr;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnRetour']")
    private WebElement back;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxCountry']/option")
    private List<WebElement> countrynr;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxFamily']/option")
    private List<WebElement> mrange;

    // @FindBy(xpath = "//*[@id=\"ctl00_mainContentPlaceHolder_lbxFamily\"]/option[2]")
    // private WebElement mrange1;

    @FindBy(xpath = "//*[@name='ctl00$mainContentPlaceHolder$lbxEngine']/option")
    private List<WebElement> enginenr;

//    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxEngine']")
//    private WebElement egn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValider']")
    private WebElement searchnr;

    @FindBy(xpath = "//*[text()='Network remaining margin ']")
    private WebElement networkmrgn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbMargeRestanteReseau']")
    private WebElement nwmargin;

    @FindBy(xpath = "//*[text()='Friction factor']")
    private WebElement ffactor;

    @FindBy(xpath = "//*[@id='ctl00_Menu_lbInfo']")
    private WebElement fstatus;

//    @FindBy(xpath = "//*[text()='budget RBCVper family']")
//    private WebElement RBCV;
//    
    @FindBy(xpath = "//*[@id=\"ctl00_Menu_MainMenun15\"]/td/table/tbody/tr/td/a")
    private WebElement RBCV;

    @FindBy(xpath = "//*[@class='texte_etiquette']")
    private WebElement RBCVTP;

    @FindBy(xpath = "//*[text()='International customer volume bonus']")
    private WebElement Ibonus;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbRechercher']")
    private WebElement Searchdata;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_dtgBonus_ctl02_tbText']")
    private WebElement compareDescription;

    @FindBy(id = "ctl00_mainContentPlaceHolder_dtgBonus_ctl02_hplink")
    private WebElement compareDescriptionRF;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnRechercher']")
    private WebElement searchib;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnAddRow']")
    private WebElement addnewlineib;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgBonus_ctl02_tbText']")
    private WebElement description;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgBonus_ctl02_tbMontant']")
    private WebElement ibamount;

    public static String finalData;
    public static String finalDescription;
    public static String finalAmount;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement validateib;

    @FindBy(xpath = "//*[text()='Leasers International Bonus on volume']")
    private WebElement Leasersbonus;

    // @FindBy(xpath="//*[@id='ctl00_mainContentPlaceHolder_lnkBtnAddRow']")

    @FindBy(xpath = "//*[text()='Contrib Administration']")
    private WebElement catable;

    @FindBy(xpath = "//a[contains(text(),'Configuration User')]") // *[text()='Config utilisateur']
    private WebElement cuser;// Maintenance

    @FindBy(xpath = "//*[text()='Contrib lock']")
    private WebElement cLock;

    @FindBy(xpath = "//*[text()='Translation']")
    private WebElement Translation;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlLanguage']")
    private WebElement slanguage;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkAddLanguage']")
    private WebElement addl;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_ddlLanguage']")
    private WebElement addlanguages;

    @FindBy(xpath = "//*[text()='Applications messages']")
    private WebElement Applicationm;

    @FindBy(xpath = "//*[text()='Purge']")
    private WebElement purgev;

    @FindBy(xpath = "//*[text()='Filing profitability study']")
    private WebElement filing;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxCountry']")
    private WebElement multicountry;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxActivity']")
    private WebElement multicriteriaa;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbProto']")
    private WebElement Pfssnumbers;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_lnkBtnRechercheRapide']")
    private WebElement qSearch;

    @FindBy(xpath = "(//td[@class='texte_etiquette'])[1]")
    private WebElement profitabilitystudy;

    @FindBy(xpath = "//tr[@class='texte_Taleau']/td[3]/a")
    private List<WebElement> codes;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnExport']")
    private WebElement exportCheck;

    @FindBy(xpath = "//span[@id='ctl00_mainContentPlaceHolder_EditProtocol_lbProtocol']")
    private WebElement pfstudyName;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnProceedSelectedProtocol']")
    private WebElement archive;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnProceed1SelectedProtocol']")
    private WebElement unarchive;

    @FindBy(xpath = "//*[text()='Profitability study removal']")
    private WebElement pfsremoval;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgProtocols_ctl03_dtgcb']")
    private WebElement checkboxpf;

    @FindBy(xpath = "//*[text()='Creation of manual version']")
    private WebElement ManualVersion;

//    @FindBy(xpath = "//*[text()=' budget RBCV per family integration']")
//    private WebElement IntegrationRBCV;
//    

    @FindBy(xpath = "//*[@id=\"ctl00_Menu_MainMenun26\"]/td/table/tbody/tr/td/a")
    private WebElement IntegrationRBCV;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnEqualVersions']")
    private WebElement similerversions;

    // @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnHistorybis']")
//    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnHistory']")
    @FindBy(xpath = "//*[text()='History']")
    private WebElement History;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement backbtn;

//    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnViewAllVersionsBis']")
//    private WebElement seeversions;

//    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnViewAllVersions']")
    @FindBy(xpath = "//*[text()='See versions']")
    private WebElement seeversions;

    @FindBy(xpath = "//*[@ID='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnCopy']")
    private WebElement copybtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnHistory']")
    private WebElement Modifyhistory;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnAddVersion']")
    private WebElement Modifyaddv;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnViewAllVersions']")
    private WebElement modifySeever;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgAllVersions_ctl02_lnkBtnVersion']")
    private WebElement clickvers;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnRefreshProtocol']")
    private WebElement Refreshbtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnValidate']")
    private WebElement validaterefresh;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_rbTauxPrevisonnel']")
    private WebElement estimaterateradiobtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_litRateChangeLink']")
    private WebElement estimaterate;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnCancel']")
    private WebElement cancelbtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnDuplicateData']")
    private WebElement copydata;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnDuplicateData']")
    private WebElement pastedata;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnRefresh']")
    private WebElement refreshversion;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnValidateRefresh']")
    private WebElement validaterefreshbtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnRecalculate']")
    private WebElement Recalculatever;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_VersionDetail_lnkBtnAddOptions']")
    private WebElement Addoptions;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnOtherAnnexeBonus']")
    private WebElement Subsidaryprice;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_lnkBtnAddRow']")
    private WebElement addingline;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgBonus']")
    private WebElement subdescription;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_dtgBonus_ctl04_tbAmount']")
    private WebElement subamount;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnModifyHeader']")
    private WebElement modifyhead;

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

    @FindBy(xpath = "//*[@id='identifierInput']")
    private WebElement username;

    @FindBy(xpath = "//li[@class='identifier-first__account-item identifier-first__account-select']")
    private WebElement userId;

    @FindBy(xpath = "//*[@id='signOnButton']")
    private WebElement next;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnHistorybis']")
    private WebElement historylbtn;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnViewAllVersionsBis']")
    private WebElement seeversion;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnCopy']")
    private WebElement copylnk;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement userNextBtn;

    @FindBy(xpath = "//*[text()='SG02410@inetpsa.com']")
    private WebElement accountselect;

    @FindBy(xpath = "//*[@id='userNameInput']")
    private WebElement userid;

    @FindBy(xpath = "//*[@id='passwordInput']")
    private WebElement password;

    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement signin;

    @FindBy(xpath = "//*[@id='idSIButton9']")
    private WebElement accept;

    @FindBy(xpath = "//a[text()='Administration Contrib']")
    private WebElement MouseoverAC;

    @FindBy(id = "ctl00_mainContentPlaceHolder_lnkBtnChoixBonusIntCliVol")
    private WebElement intBonusSearch;

    @FindBy(id = "ctl00_mainContentPlaceHolder_lnkBtnChoixBonusNatLouVol")
    private WebElement leaserintBonusSearch;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnCreateClient']")
    private WebElement ClientCreation;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_tbName']")
    private WebElement ClientfullName;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnCreate']")
    private WebElement Savenewclient;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lbxClient']")
    private WebElement clientname;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnDeleteClient']")
    private WebElement clientdelete;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnDelete']")
    private WebElement deleteCL;

    @FindBy(xpath = "//*[@id='ctl00_mainContentPlaceHolder_lnkBtnSupprVersions']")
    private WebElement deleteversion;

    @FindBy(xpath = "//*[text()='Cancel the modifications']")
    private WebElement modificationcancel;

    @FindBy(xpath = "//*[text()='Choice of the car families']")
    private WebElement choiceofcarfamily;

    @FindBy(xpath = "//a[@id='ctl00_mainContentPlaceHolder_lnkBtnValidate']")
    private WebElement carfamilyvalidate;

    @FindBy(id = "ctl00_mainContentPlaceHolder_imgBindClient")
    private WebElement yellowArrowButton;

    public void LoginPage() {
        String loginpage = _hDriver.getTitle();
        System.out.println("User is on home page" + loginpage);
    }

    public void verifyHomePageBrand1() throws Exception {

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(verifyPeugeot));
        verifyPeugeot.click();
        Thread.sleep(1000);
    }

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

    public void LoginWithUsername(String UserName) {
        try {
            if (this.username != null && this.username.isDisplayed()) {
                this.username.click();
                this.username.clear();
                this.username.sendKeys(UserName);
                next.click();
            } else if (userId != null && userId.isDisplayed()) {
                userId.click();
                // Skipping username steps as requested
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                        "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "User Clicked on UserId Successfully. " + "</span>");
            }
        } catch (Exception e) {
            System.out.println("LoginWithUsername: " + e.getMessage());
        }
    }

    public void SelectAccount() {
        try {
            Thread.sleep(1000);
            if (userEmail != null && userEmail.isDisplayed()) {
                userEmail.click();
                userEmail.sendKeys(Web.userEmailId);
            } else {
                System.out.println("userEmail WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                        "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "userEmail WebElement is not present. " + "</span>");

                return;
            }
            Thread.sleep(1000);
            if (userNextBtn != null && userNextBtn.isDisplayed()) {
                userNextBtn.click();
            } else {
                System.out.println("userNextBtn WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "<span style = 'font-family : Arial; font-size : 12px; color:green;'>"
                        + "userNext Button WebElement is not present. " + "</span>");

            }
        } catch (Exception e) {
            System.out.println("Exception in SelectAccount: " + e.getMessage());
        }
    }

    public void LoginWithMFAProcess(String UserID, String Password) {
        try {
            if (userid != null && userid.isDisplayed()) {
                userid.click();
                userid.clear();
                userid.sendKeys(UserID);
            } else {
                System.out.println("userid WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "<span style = 'font-family : Arial; font-size : 12px; color:green;'>"
                        + "user User Id WebElement is not present. " + "</span>");

                return;
            }
            Thread.sleep(1000);
            if (password != null && password.isDisplayed()) {
                password.click();
                password.clear();
                password.sendKeys(Password);
            } else {
                System.out.println("password WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "<span style = 'font-family : Arial; font-size : 12px; color:green;'>"
                        + "user Password WebElement is not present. " + "</span>");

            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception in LoginWithMFAProcess: " + e.getMessage());
        }
    }

    public void SignIn() {
        try {
            if (signin != null && signin.isDisplayed()) {
                signin.click();
            } else {
                System.out.println("signin WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "<span style = 'font-family : Arial; font-size : 12px; color:green;'>"
                        + "user Sign In WebElement is not present. " + "</span>");

            }
        } catch (Exception e) {
            System.out.println("Exception in SignIn: " + e.getMessage());
        }
    }

    public void UserAcceptance() {
        try {
            if (accept != null && accept.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(accept)).click();
            } else {
                System.out.println("accept WebElement is not present");
            }
        } catch (Exception e) {
            System.out.println("Exception in UserAcceptance: " + e.getMessage());
        }
    }

    public void Next() {
        try {
            if (next != null && next.isDisplayed()) {
                next.click();
            } else {
                System.out.println("next WebElement is not present");
                ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "<span style = 'font-family : Arial; font-size : 12px; color:green;'>"
                        + "user Next Button WebElement is not present. " + "</span>");

            }
        } catch (Exception e) {
            System.out.println("Exception in Next: " + e.getMessage());
        }
    }

//    public void SelectAccount() throws Exception {
//        Thread.sleep(1000);
//        // this.accountselect.click();
//        userEmail.click();
//        userEmail.sendKeys("SG02410@inetpsa.com");
//
//        Thread.sleep(1000);
//        userNextBtn.click();
//    }
//
//    public void LoginWithMFAProcess(String UserID, String Password) throws Exception {
//        this.userid.click();
//        this.userid.clear();
//        this.userid.sendKeys(UserID);
//        Thread.sleep(1000);
//        this.password.click();
//        this.password.clear();
//        this.password.sendKeys(Password);
//        Thread.sleep(1000);
//
//    }
//
//    public void SignIn() {
//        this.signin.click();
//    }
//
//    public void UserAcceptance() {S
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(accept)).click();
//
//        } catch (Exception e) {
//
//            log.error("Failed to click the validation : " + e.getMessage());
//        }
//
//    }
//
//    public void Next() throws IOException {
//        this.next.click();
//
//    }

    public void ContribAdmin() throws Exception {
        // MouseOver(MouseoverAC);//Maintenance
        MouseOver(catable);
        System.out.println("The MouseOver element name is:" + catable.getText());
        Thread.sleep(3000);
    }

    public void DropdownMethods(List<List<String>> SelectedLang) throws Exception {

        // wait.until(ExpectedConditions.elementToBeClickable(dropd)).click();

        String SelectLanguage = SelectedLang.get(1).get(0);
        wait.until(ExpectedConditions.visibilityOf(dropd));
        Select sel = new Select(dropd);

        sel.selectByValue(SelectLanguage);

        System.out.println("The selected language is:" + sel.getFirstSelectedOption().getText());

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Selected Language name is: " + SelectLanguage + "</span>");
        Thread.sleep(2000);

    }

    public void Validation() throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(validate)).click();

            // validate.click();

        } catch (Exception e) {

            log.error("Failed to click the validation : " + e.getMessage());
        }

    }

    public void GetUrl() {

        _hDriver.get("https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc001_01.aspx");
        _hDriver.get("https://contrib.citroen.preprod.inetpsa.com/Protocole/osc001_01.aspx");

    }

    public void VehiclePrasent() {

        wait.until(ExpectedConditions.visibilityOf(Vehiclepic));
        boolean vpic = Vehiclepic.isDisplayed();
//        log.info("The vehiclepic is there :" + Vehiclepic.isDisplayed());

        if (vpic) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,
                    "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Vehicle image is prasent" + "</span>");
        } else {

            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
                    "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Vehicle image is NOT prasent" + "</span>");
        }
    }

    public void TextPrasent() {

        log.info("The Text is: " + Text.getText());
        // log.info("The text is: " + Text.isDisplayed());

        if (Text.isDisplayed()) {
            System.out.println("The Text is prasent:" + Text);
        } else {
            System.out.println("The Text is not prasent");
        }

    }

    public void MouseOverPf() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(profitability).build().perform();

        Thread.sleep(3000);
        MouseOver(profitability);
        System.out.println("The MouseOver element name is:" + profitability.getText());
        Thread.sleep(3000);

    }

    public void GetUrlCC() throws Exception {

        _hDriver.get("https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_01.aspx?Mode=1");
        _hDriver.get("https://contrib.citroen.preprod.inetpsa.com/Protocole/osc002_01.aspx?Mode=1");
        _hDriver.manage().addCookie(new Cookie("lang", "en"));
        Thread.sleep(2000);

    }

//    public void SelectCountry(List<List<String>> countrys) throws Exception {
//
//        String selectedcountryvalue = countrys.get(1).get(0);
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(country));
//        Select cou = new Select(country);
//        Thread.sleep(2000);
//        cou.selectByValue(selectedcountryvalue);
//        log.info("The Selected country name is:" + cou.getFirstSelectedOption().getText());
//        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
//                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Country name is: " + selectedcountryvalue + "</span>");
//        Thread.sleep(2000);
//    }
//    
    public void SelectCountry(List<List<String>> countrys) throws Exception {

        String selectedcountryvalue = countrys.get(1).get(0);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(country));
        Select cou = new Select(country);
        Thread.sleep(2000);

        // ✅ ONLY THIS LINE CHANGED (select by index)
        cou.selectByIndex(Integer.parseInt(selectedcountryvalue));

        log.info("The Selected country name is:" + cou.getFirstSelectedOption().getText());
        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Country index is: " + selectedcountryvalue + "</span>");
        Thread.sleep(2000);
    }

//    public void SelectClient(List<List<String>> clients) throws Exception {
//
//        String clientsPrasent = clients.get(1).get(0);
//        Select cnt = new Select(client);
//        cnt.selectByValue(clientsPrasent);
//
//        log.info("The Selected client name is:" + cnt.getFirstSelectedOption().getText());
//
//        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
//                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "client name is: " + clientsPrasent + "</span>");
//        Thread.sleep(2000);
//    }
//    
    public void SelectClient() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(client1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(client1.get(0)));

            // If clickable, then click it
            client1.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: client element is visible but NOT clickable!");
        }
    }

    public PS_CreationPage SelectStatus(String scode) {

        try {
            Statuss.clear();
            wait.until(ExpectedConditions.elementToBeClickable(Statuss)).click();

            // Statuss.click();
            Statuss.sendKeys(scode);
            Thread.sleep(2000);
        } catch (Exception e) {

            log.error("The status code is not applicable:" + e);
        }
        return this;
    }

    public void SelectDate(List<List<String>> startdate) throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(startingdate)).click();
        // this.startingdate.click();
        Thread.sleep(2000);

        String monthyear = _hDriver.findElement(By.xpath(setYear)).getText();
        String smonthdate = startdate.get(1).get(0);
//        String smonthdate = "April 2025";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

        Date current = dateFormat.parse(monthyear);
        Date target = dateFormat.parse(smonthdate);

        while (!(monthyear.equals(smonthdate))) {

            if (target.before(current)) {
                _hDriver.findElement(By.xpath(setBeforeNext)).click();

            } else {

                _hDriver.findElement(By.xpath(setNext)).click();
            }
            Thread.sleep(2000);
            monthyear = _hDriver.findElement(By.xpath(setYear)).getText();

        }

        WebElement SDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(setStartDate)));
        String Stratdate = SDate.getText();
        log.info("The Starting Date is :" + Stratdate);
        SDate.click();
        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Select Date is :" + smonthdate + "</span>");

        Thread.sleep(2000);

    }

    public void SelectEndDate(List<List<String>> enddate) throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(endingdate)).click();
        // this.endingdate.click();

        Thread.sleep(2000);

        String monthYear = _hDriver.findElement(By.xpath(setEndYear)).getText();
        String emonthDate = enddate.get(1).get(0);
//        String emonthDate = "April 2025";

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

        Date current = dateFormat.parse(monthYear);
        Date target = dateFormat.parse(emonthDate);
        while (!(monthYear.equals(emonthDate))) {

            if (target.before(current)) {
                // Navigate the previous month
                _hDriver.findElement(By.xpath(setBeforeNext)).click();
            } else {
                // Navigate the next month
                _hDriver.findElement(By.xpath(setEndNext)).click();

                // log.info("The End Date is:" + monthYear);
            }

            monthYear = _hDriver.findElement(By.xpath(setEndYear)).getText();
            Thread.sleep(2000);

        }

        WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(setEndDate)));
        String cDate = selectDate.getText();
        System.out.println("The Date is : " + cDate);
        log.info("The selected end Date is: " + cDate);
        selectDate.click();

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Select end Date is :" + emonthDate + "</span>");

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);

    }

    public void VerifyStartDate(String ValidStartdate) {
        this.ValidSdate.click();
        this.ValidSdate.clear();
        this.ValidSdate.sendKeys(ValidStartdate);
    }

    public void VerifyEndDate(String ValidEnddate) {
        this.ValidEdate.click();
        this.ValidEdate.clear();
        this.ValidEdate.sendKeys(ValidEnddate);
    }

    public void Validationbtn() throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(Validation)).click();

            // this.Validation.click();

        } catch (Exception e) {
            log.error("The Validation is error:" + e);
        }
        Thread.sleep(2000);
    }

//    public void FamilyModelRange(List<List<String>> rangedetails) throws Exception {
//
//        String range = rangedetails.get(1).get(0);
//        Select fm = new Select(modelrange);
//        fm.selectByValue(range);
//
//        log.info("The Model Range name is:" + fm.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//
//    }
    public void FamilyModelRange() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(modelrange1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(modelrange1.get(0)));

            // If clickable, then click it
            modelrange1.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: modelrange1 element is visible but NOT clickable!");
        }

    }

//    public void ValidateDate(List<List<String>> valuedetails) throws Exception {
//
//        String value = valuedetails.get(1).get(0);
//        Select vd = new Select(validateversion);
//        vd.selectByValue(value);
//        Thread.sleep(2000);
//        log.info("The selected date of version is: " + vd.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//    }

    public void ValidateDate() throws Exception {
        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(validateversion1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(validateversion1.get(0)));

            // If clickable, then click it
            validateversion1.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: validateversion1 element is visible but NOT clickable!");
        }
    }

    public void SearchValidationBtn() throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchvalidation)).click();

            // searchvalidation.click();

        } catch (Exception e) {
            log.error("The Search validation was not clicked :" + e);
        }
        Thread.sleep(3000);
    }

    public boolean TablePrasent() {

        try {
            boolean isVisible = table.isDisplayed();

            System.out.println("Table is prasent: " + isVisible);
            return isVisible;
            // return table.isDisplayed();

        } catch (Exception e) {

            System.out.println("Table is NOT Prasent: ");
            return false;
        }
    }

//    public void VersionCheckBoxes(List<List<String>> checklist) throws Exception {
//
//        String Checkboxtext = checklist.get(1).get(0);
//        Thread.sleep(2000);
//        WebElement check = _hDriver
//                .findElement(By.xpath("//td[normalize-space(text())='" + Checkboxtext + "']/preceding-sibling::td//input[@type='checkbox']"));
//
//        if (!check.isSelected()) {
//            check.click();
//            Thread.sleep(2000);
//
//            System.out.println("The check box is click and prasent'" + Checkboxtext + "' is checked");
//
//        } else {
//            System.out.println("The check box is not click at prasent'" + Checkboxtext + "' is not checked");
//
//        }
//    }

    public void VersionCheckBoxes() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBoxes));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(checkBoxes.get(0)));
            wait.until(ExpectedConditions.elementToBeClickable(checkBoxes.get(1)));

            // If clickable, then click it
            checkBoxes.get(0).click();
            checkBoxes.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: checkBoxes element is visible but NOT clickable!");
        }

    }

    public void AddSearchBasket() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(addbasket)).click();

        // this.addbasket.click();

        Thread.sleep(2000);
    }

    public void OptionsValidate() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Options)).click();

            // Options.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.info("The click option is failed:" + e);
        }
    }

//    public void CheckBoxOptions() throws Exception {
//
//        String[] CheckOptions = { "0N9V" };
//
//        int checkBoxlist = CheckOptions.length;
//
//        System.out.println("The Length of the options is : " + checkBoxlist);
//        for (String CheckOption : CheckOptions) {
//            WebElement SelectCheckbx = _hDriver
//                    .findElement(By.xpath("//td[normalize-space(text())='" + CheckOption + "']/preceding-sibling::td//input[@type='checkbox']"));
//
//            if (!SelectCheckbx.isSelected())
//
//            {
//
//                wait.until(ExpectedConditions.elementToBeClickable(SelectCheckbx));
//                SelectCheckbx.click();
//                Thread.sleep(3000);
//            }
//
//        }
//
//    }

//    public void CheckBoxOptions(List<List<String>> checkoptionlist) throws Exception {
//
//        String Optioncode = checkoptionlist.get(1).get(0);
//        Thread.sleep(2000);
//        WebElement SelectCheckbx = _hDriver
//                .findElement(By.xpath("//td[normalize-space(text())='" + Optioncode + "']/preceding-sibling::td//input[@type='checkbox']"));
//
//        if (!SelectCheckbx.isSelected()) {
//            SelectCheckbx.click();
//            Thread.sleep(2000);
//
//            System.out.println("The check box is click and prasent'" + Optioncode + "' is checked");
//
//        } else {
//            System.out.println("The check box is not click at prasent'" + Optioncode + "' is not checked");
//
//        }
//    }
    public void CheckBoxOptions() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(optionsCode));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(optionsCode.get(0)));

            // If clickable, then click it
            optionsCode.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: optionsCode element is visible but NOT clickable!");
        }
    }

    public void ValidatedOptions() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(ValidateOptions)).click();

            // ValidateOptions.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            log.info("The validations is an error :" + e);
        }
    }

//    public void FoundVersionList(List<List<String>> vlist) throws Exception {
//
//        // String versionText = "1PP5A5MZIFBY2PE0";
//        String versionText = vlist.get(1).get(0);
//
//        WebElement versions = _hDriver
//                .findElement(By.xpath("//td[normalize-space(text())='" + versionText + "']/preceding-sibling::td//input[@type='checkbox']"));
//
//        if (!versions.isSelected()) {
//
//            versions.click();
//            Thread.sleep(3000);
//        }
//    }

    public void FoundVersionList() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(versionTexts));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(versionTexts.get(1)));

            // If clickable, then click it
            versionTexts.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: versionTexts element is visible but NOT clickable!");
        }
    }

    public void AddVersionsPS() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AddVersions)).click();
            // AddVersions.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            log.info("Failed the version add:" + e);
        }
    }

    public void SelectBrands() throws Exception {

        // List<List<String>> selectedoptions
        // String options = selectedoptions.get(1).get(0);

        String bovalue = "Brand";
        Select bo = new Select(SelectOption);
        bo.selectByValue(bovalue);
        System.out.println("The selected dropdown is: " + bo.getFirstSelectedOption().getText());

        Thread.sleep(3000);
    }

    public void B2BChannel() throws Exception {

        // List<List<String>> b2boptions
        // String B2B = b2boptions.get(1).get(0);
        String b2value = "1|FD|Key Accounts";
        Select b2 = new Select(SelectB2b);
        b2.selectByValue(b2value);
        System.out.println("The Selected Dropdown is :" + b2.getFirstSelectedOption().getText());
        Thread.sleep(2000);

    }

    public PS_CreationPage SendVolumenum(String volume) throws Exception {
        this.volume.sendKeys(volume);
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        return this;
    }

    public void InternationalBonus() throws Exception {
        try {
            this.Internbonus.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click: " + e);
        }
        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);

    }

    public void NationalBonus() {
        try {
            this.Nationalbonus.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click: " + e);
        }

    }

    public void RangeBonus() throws Exception {
        try {
            this.rangebonus.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click: " + e);
        }

        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,-800)");
        Thread.sleep(2000);

    }

    public void NoLasear() {
        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,600)");

        try {
            this.lasear.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click: " + e);
        }
    }

    public void SelectDraft() {

        try {
            draft.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click :" + e);
        }
    }

    public void SavePF() throws Exception {

        // wait.until(ExpectedConditions.elementToBeClickable(savepfstudy));
        // this.savepfstudy.click();
        // Thread.sleep(2000);

        if (savepfstudy.isDisplayed() && savepfstudy.isEnabled()) {
            savepfstudy.click();
            System.out.println("it has click:" + savepfstudy);
        } else {
            System.out.println("it was not clicked");
        }
        Thread.sleep(3000);

    }

    public void PFNumber() {

//        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
//        js.executeScript("window.scrollTo(0,0)");
        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,-800)");
        log.info("The Study number is: " + PFstudynum.getText());

    }

    public void SelectExportBtn(List<List<String>> exportbtn) throws Exception {

        Thread.sleep(4000);
        String SelExport = exportbtn.get(1).get(0);

        Select export = new Select(SelectExport);
        export.selectByValue(SelExport);
        log.info("The selected value is :" + export.getFirstSelectedOption().getText());
        Thread.sleep(4000);
    }

//    public void ClickExportBtn() throws Exception {
//
//        this.ClickExport.click();
//        Thread.sleep(2000);

//        Robot robot = new Robot();
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_ALT);
//        robot.keyPress(KeyEvent.VK_S);
//        robot.keyRelease(KeyEvent.VK_S);
//        robot.keyRelease(KeyEvent.VK_ALT);
//
//        Thread.sleep(5000);
//    }
    public void ClickExportBtn() throws Exception {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOf(ClickExport));
        this.ClickExport.click();
        Thread.sleep(5000);
//        Stirng fileName = 
//        String fullPath = downloadPath + fileName;
//        
//                File existingFile = new File(fullPath);
//                Thread.sleep(2000);
//                if (existingFile.exists()) {
//                    existingFile.delete();
//                }
        // Wait for the Save dialog to appear and send ALT+S to save
        Robot robot = new Robot();
        Thread.sleep(3000); // Wait for the popup to appear

        // Press ALT+S to trigger the "Save" action in the download dialog
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(5000); // Wait for the file to be saved

        // Runtime.getRuntime().exec("C:\\Users\\SD51978\\LITMUS01\\LITMUS01\\AutoIT\\Reportss.exe"); // full path to your AutoIt exe
        // Process p = Runtime.getRuntime().exec(autoItExePath);

        // 3️⃣ Wait for the AutoIt script to finish execution
        // p.waitFor();

        // 4️⃣ Optional: log
        System.out.println("Export completed and file saved via AutoIt.");

        Thread.sleep(3000);
    }

    public void ClickExportBtn1() throws Exception {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOf(ClickExport));
        this.ClickExport.click();
        Thread.sleep(5000);

        Runtime.getRuntime().exec("C:\\Users\\SG02410\\LITMUS01 (2)\\LITMUS01\\AutoIT\\Reportss.exe"); // full path to your AutoIt exe
        // Process p = Runtime.getRuntime().exec(autoItExePath);

        // 3️⃣ Wait for the AutoIt script to finish execution
        // p.waitFor();

        // 4️⃣ Optional: log
        System.out.println("Export completed and file saved via AutoIt.");

        Thread.sleep(3000);
    }

    public void ModificationBtn() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(Modifybtn));
            this.Modifybtn.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            log.error("Failed to click : " + e);
        }
    }

    public void AddVersionBtn() {

        try {
            // wait.until(ExpectedConditions.elementToBeClickable(addversion)).click();
            this.addversion.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed to click : " + e);
        }
    }

    /*
     * public void RangeModification() throws Exception {
     * 
     * Select fm = new Select(modelrange); // fm.selectByValue("1PP5&DE"); fm.selectByValue("1CLE&DE");
     * 
     * // fm.selectByValue("2GK9&DE");
     * 
     * log.info("The Model Range name is:" + fm.getFirstSelectedOption().getText()); Thread.sleep(2000);
     * 
     * }
     */

    public void ModificationVersion() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(validateversion));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(validateversion.get(0)));

            // If clickable, then click it
            validateversion.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: validateversion element is visible but NOT clickable!");
        }

//        Select vd = new Select(validateversion);
//        vd.selectByValue("TODAY");
//
//        log.info("The selected date of version is: " + vd.getFirstSelectedOption().getText());

        Thread.sleep(2000);

    }

    public void ClientCreation() throws Exception {
        // ClientCreation.click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ClientCreation)).click();

        } catch (Exception e) {

            log.error("Failed to click the creation: " + e);

        }

        Thread.sleep(3000);
    }

    public void NameOfClient(String ClientName) throws Exception {
        this.ClientfullName.click();
        this.ClientfullName.clear();
        Thread.sleep(2000);
        this.ClientfullName.sendKeys(ClientName);
    }

    public void CancelClientCreation() {
        this.cancelbtn.click();
    }

    public void SaveClient() throws Exception {

        // wait.until(ExpectedConditions.elementToBeClickable(savepfstudy));
        // this.savepfstudy.click();
        // Thread.sleep(2000);

        if (Savenewclient.isDisplayed() && Savenewclient.isEnabled()) {
            Savenewclient.click();
            System.out.println("it has click:" + Savenewclient);
        } else {
            System.out.println("it was not clicked");
        }
        Thread.sleep(5000);

    }

    // created client value matching
    public void getFilteredClientName() throws Exception {
        // Generate random value: alphabets + numbers (e.g., TESTAB1234) =====
        // Generate random name (alphabets + numbers)
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // 5 random alphabets
        for (int i = 0; i < 5; i++) {
            sb.append(letters.charAt(rnd.nextInt(letters.length())));
        }
        // 4 random digits
        for (int i = 0; i < 4; i++) {
            sb.append(digits.charAt(rnd.nextInt(digits.length())));
        }

        String randomValue = sb.toString();
        System.out.println("Generated Value: " + randomValue);

        // Send value to input box
        WebElement input = _hDriver.findElement(By.xpath("//input[@id='ctl00_mainContentPlaceHolder_tbName']"));
        input.clear();
        input.sendKeys(randomValue);

        if (Savenewclient.isDisplayed() && Savenewclient.isEnabled()) {
            Savenewclient.click();
            System.out.println("it has click:" + Savenewclient);
        } else {
            System.out.println("it was not clicked");
        }
        Thread.sleep(5000);

        // Wait for AJAX or updates
        Thread.sleep(1500);

        // Fetch all dropdown <option> elements
        List<WebElement> options = _hDriver.findElements(By.xpath("//select[@id='ctl00_mainContentPlaceHolder_lbxClient']/option"));

        // Check if any <option> matches the random value
        boolean found = options.stream().anyMatch(opt -> opt.getText().trim().equalsIgnoreCase(randomValue));

        if (found) {
            System.out.println("Dropdown contains: " + randomValue);
        } else {
            System.out.println("Dropdown does NOT contain: " + randomValue);
        }
    }

    public void CreationMethod() throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(creation)).click();

            // creation.click();

        } catch (Exception e) {

            log.error("Failed to click the creation: " + e);

        }

        Thread.sleep(3000);
    }

    public void DeleteClient() {
        this.clientdelete.click();

    }

    public void Delete() {
        if (deleteversion != null && deleteversion.isDisplayed()) {
            deleteversion.click();
            System.out.println("Delete button clicked.");
        } else {
            System.out.println("Delete button not found or not visible.");
        }
    }

    public void DeleteBtn() throws Exception {
        this.deleteCL.click();
        Thread.sleep(1000);
    }

    /*
     * public void AcceptDelete() throws Exception {
     * 
     * Alert alert = _hDriver.switchTo().alert(); String textAlert = alert.getText(); Thread.sleep(1000); System.out.println("The Text of alert is:" +
     * textAlert); alert.accept(); Thread.sleep(1000); }
     */

    public void AcceptDelete() {
        try {
            Alert alert = _hDriver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert already handled or not present.");
        }
    }

    /*
     * public void fatchDeleteTitle() { try { // Wait until header/info text is visible after delete
     * wait.until(ExpectedConditions.visibilityOf(pftext));
     * 
     * String actualMsg = pftext.getText().trim(); System.out.println("Delete result message: " + actualMsg);
     * 
     * // Adjust expected text as per your app message String expectedKeyword = "deleted";
     * 
     * if (actualMsg.toLowerCase().contains(expectedKeyword)) { ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,
     * "<span style='font-family: Arial; font-size: 12px; color:green;'>Client delete message verified: " + actualMsg + "</span>"); } else {
     * ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
     * "<span style='font-family: Arial; font-size: 12px; color:red;'>Delete message not matched. Actual: " + actualMsg + "</span>");
     * Assert.fail("Expected delete confirmation message, but got: " + actualMsg); }
     * 
     * } catch (TimeoutException e) { Assert.fail("Delete confirmation message not displayed in time."); } catch (Exception e) {
     * Assert.fail("Failed to verify delete message: " + e.getMessage()); } }
     */

    public void SelectCheckBoxes() throws Exception {
        String Checkboxtext = "308 5P P 12E MHEV";
        WebElement check = _hDriver
                .findElement(By.xpath("//td[normalize-space(text())='" + Checkboxtext + "']/preceding-sibling::td//input[@type='checkbox']"));

        if (!check.isSelected()) {
            check.click();
            Thread.sleep(2000);

            System.out.println("The check box is click and prasent'" + Checkboxtext + "' is checked");

        } else {
            System.out.println("The check box is not click at prasent'" + Checkboxtext + "' is not checked");

        }
    }

    /*
     * public void ModificationCheckBoxOptions() throws Exception {
     * 
     * String[] CheckOptions = { "0NWP" };
     * 
     * int checkBoxlist = CheckOptions.length;
     * 
     * System.out.println("The Length of the options is : " + checkBoxlist); for (String CheckOption : CheckOptions) { WebElement SelectCheckbx =
     * _hDriver .findElement(By.xpath("//td[normalize-space(text())='" + CheckOption + "']/preceding-sibling::td//input[@type='checkbox']"));
     * 
     * if (!SelectCheckbx.isSelected())
     * 
     * { wait.until(ExpectedConditions.elementToBeClickable(SelectCheckbx)); SelectCheckbx.click(); Thread.sleep(3000); }
     * 
     * }
     * 
     * }
     */

    public void ModificationValidatedOptions() {

        try {
            ValidateOptions.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            log.info("The validations is an error :" + e);
        }
    }

    public void ChoiceOfCarFamily() {
        try {
            choiceofcarfamily.click();
            Thread.sleep(2000);

        } catch (Exception e) {
            log.info("The validations is an error :" + e);
        }
    }

    public void CarfamilyValidate() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(carfamilyvalidate)).click();

            // validate.click();

        } catch (Exception e) {

            log.error("Failed to click the validation : " + e.getMessage());
        }

    }

    /*
     * public void ModificationFoundVersionList() throws Exception {
     * 
     * String versionText = "1PP5A5PJHWBYA0E0";
     * 
     * WebElement versions = _hDriver .findElement(By.xpath("//td[normalize-space(text())='" + versionText +
     * "']/preceding-sibling::td//input[@type='checkbox']"));
     * 
     * if (!versions.isSelected()) {
     * 
     * versions.click(); Thread.sleep(3000); } }
     */

    public void ModificationAddVersionsPS() {
        try {
            AddVersions.click();
            Thread.sleep(3000);
        } catch (Exception e) {
            log.info("Failed the version add:" + e);
        }
    }

    public PS_CreationPage ModificationSendVolumenum(String volumes) throws Exception {
        this.volume.sendKeys(volumes);
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        return this;
    }

    public void ModificationSavePF() throws Exception {

        // wait.until(ExpectedConditions.elementToBeClickable(savepfstudy));

        // Thread.sleep(2000);
//
//        if (savepfstudy.isDisplayed() && savepfstudy.isEnabled()) {
//            savepfstudy.click();
//            System.out.println("it has click:" + savepfstudy);
//        } else {
//            System.out.println("it was not clicked");
//        }

        this.savepfstudy.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = _hDriver.switchTo().alert();

        String textAlert = alert.getText();
        System.out.println("The Text of alert is:" + textAlert);
        alert.accept();
        // Thread.sleep(5000);

    }

    public void pfstudyNumber() {

//_hDriver.get("https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_18.aspx?IdBonusIntLouVol=0&MontantBonusIntLouVol=0&Version=1PP5A5MZIFBY2PE0&LibClientBonusLou=Pas+de+loueur&_IndexVersion=0");
        // log.info("The Study number is: " + pfs.getText());
        pfss = pfs.getText();
        log.info("The Study number is: " + pfss);
//        System.out.println(pfs);
    }

    public void SelectMouseover() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(profitability).build().perform();

        MouseOver(profitability);

        System.out.println("The Mouse element name is:" + profitability.getText());
        Thread.sleep(2000);

        this.search.click();

    }

    public void HistoryLnkBtn() {
        this.historylbtn.click();
    }

    public void SeeVersionLnkBtn() {
        this.seeversion.click();
    }

    public void CopyLnkBtn() {
        this.copylnk.click();

    }

    public void TextOfPfSearch() {

        String pageTitle = _hDriver.getTitle();
        log.info("The Title of page: " + pageTitle);

        log.info("The Page of text is: " + pftext.getText());
    }

    public void QuickSearch() throws Exception {

        try {
            Quicks.click();
        } catch (Exception e) {
            log.error("Failed to click : " + e);
        }
        Thread.sleep(2000);
    }

    public void PFSNum() throws Exception {
        this.Pfsnumbers.click();
//        pfss = pfs.getText();
//        log.info("The Study number is: " + pfss);

        this.Pfsnumbers.sendKeys(pfss);
        Thread.sleep(2000);

    }

    public void Startsearching() throws Exception {

        this.Startsearch.click();
        Thread.sleep(2000);
    }

    public void storePfsNumber() throws Exception {

        Thread.sleep(3000);
        pfsNumber = storePfsNo.getText();
        System.out.println("Profitability studies code" + pfsNumber);
        Thread.sleep(3000);
    }

    public void SelectCodes() throws Exception {

        try {
            Selectcode.click();
        } catch (Exception e) {
            log.error("Failed to click : " + e);
        }
        Thread.sleep(3000);
    }

    public void RTable() throws Exception {
//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();
        MouseOver(rtable);

        System.out.println("The Text of the mouseover element name is:" + rtable.getText());

        Thread.sleep(3000);
        this.sbdata.click();
        // wait.until(ExpectedConditions.elementToBeClickable(sbdata));
        Thread.sleep(2000);

    }

    public void SelectRTCountry(List<List<String>> rtcountrys) throws Exception {

        String RTCountry = rtcountrys.get(1).get(0);
        Select sb = new Select(scountry);
        sb.selectByVisibleText("Italie");

        log.info("The selected date of version is: " + sb.getFirstSelectedOption().getText());

        Thread.sleep(3000);
    }
//    public void SelectRTCountry(List<List<String>> rtcountrys) throws Exception {
//
//        int index = Integer.parseInt(rtcountrys.get(1).get(0));
//
//        List<WebElement> selects = driver.findElements(By.tagName("select"));
//
//        WebElement dropdown = selects.get(0); // or get(1) if second dropdown
//
//        Select sb = new Select(dropdown);
//
//        sb.selectByIndex(index);
//
//        log.info("Selected country: " + sb.getFirstSelectedOption().getText());
//
//        Thread.sleep(2000);
//    }
//    public void SelectRTCountryy() {
//        rcountry.get(1).click();
//        
//        
//        
//    }

    public void ProvisionalRates() throws Exception {
//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        MouseOver(rtable);
        Thread.sleep(2000);
        this.prate.click();
    }

    public void SearchPrrate() throws Exception {

        this.searchpr.clear();
        this.searchpr.click();
        Thread.sleep(2000);

        this.searchprc.click();
    }

    public void AddLine() throws Exception {

        try {
            addlines.click();
        } catch (Exception e) {
            log.error("Failed to click: " + e);

        }
        Thread.sleep(2000);
    }

    public void ValidatePrRate() throws Exception {

        try {
            validatepr.click();
        } catch (Exception e) {

            log.error("Failed to click :" + e);
        }
        Thread.sleep(3000);
    }

    public void NetWorkRm() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();
        MouseOver(rtable);
        this.nremuneration.click();
        Thread.sleep(3000);
    }

    public void CnewLine() {

        this.CnewLine.click();
    }

//    public void NRCountry() throws Exception {
//        // List<List<String>> nrcountrys
////        String countrynr = nrcountrys.get(1).get(0);
////        String modelrangenr = nrcountrys.get(1).get(1);
//        Select dropp = new Select(countrynrre);
//        dropp.selectByValue("DE");
//        log.info("The selected country name is :" + dropp.getFirstSelectedOption().getText());
//    }

//    public void MRangeee(List<List<String>> modelrange) throws Exception {
//        String NRmodelrange = modelrange.get(1).get(0);
//        Select md = new Select(rangenrr);
//        md.selectByValue(NRmodelrange);
//
//        log.info("The selected range name is: " + md.getFirstSelectedOption().getText());
//
//        Thread.sleep(3000);
//    }
    public void MRangeee() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(rangenrr));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(rangenrr.get(1)));

            // If clickable, then click it
            rangenrr.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: rangenr element is visible but NOT clickable!");
        }

    }
//        Select mdrop = new Select(rangenrr);
//        // mdrop.selectByValue("1PP5");
//        mdrop.selectByValue("1GK9");
//        log.info("The selected range name is :" + mdrop.getFirstSelectedOption().getText());
//        Thread.sleep(3000);
//    }

//    public void Engines(List<List<String>> rtengine) throws Exception {
//        String RTEngine = rtengine.get(1).get(0);
//        Select eng = new Select(enginerrr);
//        eng.selectByValue(RTEngine);
//        log.info("The selected Engine name is :" + eng.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//    }
    public void Engines() throws Exception {
        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(enginerrr));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(enginerrr.get(0)));

            // If clickable, then click it
            enginerrr.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: Engine element is visible but NOT clickable!");
        }
    }

    public PS_CreationPage AmtPer(String per, String amt) throws Exception {

        this.Percentage.clear();
        this.Percentage.click();
        this.Percentage.sendKeys(per);
        Thread.sleep(2000);
        this.amount.clear();
        this.amount.click();
        this.amount.sendKeys(amt);
        Thread.sleep(2000);
        return this;

    }

    public void ValidatedNrr() throws Exception {

        this.Validatenr.click();
        // it using navigate the url
        // _hDriver.navigate().to("https://contrib.peugeot.preprod.inetpsa.com/Reference/osc005_16.aspx");
        Thread.sleep(3000);
        System.out.println("The updated data status is :" + fstatus.getText());
    }

    public void Backbtn() {

        this.back.click();

    }

//    public void Selectcmrange(List<List<String>> nrcountrys) throws Exception {
//        String NRcountry = nrcountrys.get(1).get(0);
//        String modelrangenr = nrcountrys.get(1).get(1);
//        String RTEngine = nrcountrys.get(1).get(2);
//        Select droppd = new Select(countrynr);
//        droppd.selectByValue(NRcountry);
//        int size = droppd.getOptions().size();
//        System.out.println("The size of country is :" + size);
//
//        log.info("The selected country name is :" + droppd.getFirstSelectedOption().getText());
//
//        Select droppdb = new Select(mrange);
//        Thread.sleep(2000);
//        droppdb.selectByValue(modelrangenr);
//        // this.mrange1.click();
//        log.info("The selected country name is :" + droppdb.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(enginenr));
//
//        Select dropeng = new Select(enginenr);
//        dropeng.selectByValue(RTEngine);
//        log.info("The selected country name is :" + dropeng.getFirstSelectedOption().getText());
//
//        Thread.sleep(2000);
//    }

    public void Selectcmrange() throws Exception {
        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(countrynr));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(countrynr.get(1)));

            // If clickable, then click it
            countrynr.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: Engine element is visible but NOT clickable!");
        }

        Thread.sleep(5000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(mrange));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(mrange.get(1)));

            // If clickable, then click it
            mrange.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: Engine element is visible but NOT clickable!");
        }
        Thread.sleep(5000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(countrynr));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(enginenr.get(0)));

            // If clickable, then click it
            enginenr.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: Engine element is visible but NOT clickable!");
        }

    }
    // try {
//
//            // _hDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_lbxEngine']")));
//            Select droppdbt = new Select(box);
//            droppdbt.selectByValue(enginee);
//
//            log.info("The selected country name is :" + droppdbt.getFirstSelectedOption().getText());
//            box.click();
//        } catch (Exception e) {
//            log.error("It is failed to load: " + e);
//        }

    // }
//    public void SelectNRcountry(List<List<String>> nrcountry) throws Exception {
//        String NRCountry = nrcountry.get(1).get(0);
//        Select nc = new Select(countrynr);
//        nc.selectByValue(NRCountry);
//
//        log.info("The selected NR country is: " + nc.getFirstSelectedOption().getText());
//
//        Thread.sleep(2000);
//    }
//
//    public void SelectNRmodelrange(List<List<String>> nrfamilycode) throws Exception {
//        String Nmodelrange = nrfamilycode.get(1).get(0);
//        Select model = new Select(mrange);
//        Thread.sleep(2000);
//        model.selectByValue(Nmodelrange);
//
//        log.info("The selected NR family code is: " + model.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//    }
//
//    public void SelectNREngine(List<List<String>> nrengine) throws Exception {
//        String NREngine = nrengine.get(1).get(0);
//        Select ne = new Select(enginenr);
//        Thread.sleep(2000);
//        ne.selectByValue(NREngine);
//
//        log.info("The selected NR Engine is: " + ne.getFirstSelectedOption().getText());
//        Thread.sleep(2000);
//    }

    public void SearnchNrr() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchnr));
            // searchnr.click();

        } catch (Exception e) {
            log.error("Failed to click : " + e);
        }
    }

    public void Networkmargin() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        MouseOver(rtable);
        this.networkmrgn.click();
        Thread.sleep(3000);
    }

    public PS_CreationPage NMpage(String perc) throws Exception {

        this.nwmargin.clear();
        this.nwmargin.click();
        this.nwmargin.sendKeys(perc);

        Thread.sleep(2000);
        return this;

    }

    public void Frictionf() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        MouseOver(rtable);
        this.ffactor.click();
        Thread.sleep(3000);

//        System.out.println("The updated data status is :" + fstatus.getText());

    }

    public void RBCVFamily() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        MouseOver(rtable);
        this.RBCV.click();
        Thread.sleep(3000);

        if (RBCVTP.isDisplayed()) {
            log.info("The table is prasent");

        } else {
            log.info("The table is not prasent");
        }

    }

    public void InternationalB() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        MouseOver(rtable);
        Thread.sleep(2000);
        this.Ibonus.click();
        Thread.sleep(3000);
    }

//    public PS_CreationPage SearchDatavalue(String data) throws Exception {
//
//        this.Searchdata.clear();
//        this.Searchdata.click();
//        // this.Searchdata.sendKeys(data);
//        Thread.sleep(2000);
//
//        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
//        finalData = data + " " + randomNumber;
//
//        this.Searchdata.sendKeys(finalData);
//
//        System.out.println("Entered data: " + finalData);
//        return this;
//    }

    public void SearchIB() {

        this.searchib.click();

        String filteredText = compareDescriptionRF.getText();

        System.out.println("Filtered Text is:" + filteredText);

        // compare finalDiscription vs filteredText

        if (finalDescription.equals(filteredText)) {

            System.out.println("The data added correctly");

        } else {
            System.out.println("The Data is not added");
        }

    }

    public void searchReferenceIB() throws Exception {

        Thread.sleep(2000);
        this.searchib.click();

        String filteredText1 = compareDescription.getAttribute("value");

        System.out.println("Filtered Text is:" + filteredText1);

        // compare finalDiscription vs filteredText

        if (finalDescription.equals(filteredText1)) {

            System.out.println("The data added correctly");

        } else {
            System.out.println("The Data is not added");
        }
        Thread.sleep(2000);

    }

    public void Addnewlineib() {
        this.addnewlineib.click();
    }

    public void Ibdescription(String description) throws Exception {
//        this.description.click();
//        this.description.clear();
//        Thread.sleep(2000);
//        this.description.sendKeys(description);

        this.description.click();
        this.description.clear();
        Thread.sleep(2000);

        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
        finalDescription = description + " " + randomNumber;

        this.description.sendKeys(finalDescription);

        System.out.println("Entered description: " + finalDescription);
        Thread.sleep(2000);

    }

    public void Ibamounts(String amount) throws Exception {
        this.ibamount.click();
        this.ibamount.clear();
        Thread.sleep(2000);
        // this.ibamount.sendKeys(amount);
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
        finalAmount = amount + randomNumber;

        this.ibamount.sendKeys(finalAmount);

        System.out.println("Entered amount: " + finalAmount);

    }

    public void ValidateIB() throws Exception {

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(validateib));
        this.validateib.click();
        Thread.sleep(2000);

    }

    public void verifyInternationalSearch() throws Exception {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(intBonusSearch));
        intBonusSearch.click();
        Thread.sleep(3000);

    }

    public void verifyleaserInternationalSearch() throws Exception {

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(leaserintBonusSearch));
        leaserintBonusSearch.click();
        Thread.sleep(3000);
    }

    public void SearchDatavalue() throws Exception {

        this.Searchdata.clear();
        this.Searchdata.click();
        this.Searchdata.sendKeys(finalDescription);
        Thread.sleep(2000);

        Thread.sleep(2000);

    }

    public void Leasers() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(rtable).build().perform();

        Thread.sleep(2000);
        MouseOver(rtable);

        this.Leasersbonus.click();

        Thread.sleep(2000);

    }

    public void ContribA() throws Exception {
//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        this.cuser.click();

        Thread.sleep(2000);
    }

    public void ContribLock() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);

        this.cLock.click();
        Thread.sleep(2000);

    }

    public void TranslationCa() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        this.Translation.click();
        Thread.sleep(2000);
    }

//    public void Slang(List<List<String>> slang) throws Exception {
//
//        String lang = slang.get(1).get(0);
//        Select sl = new Select(slanguage);
//        sl.selectByValue(lang);
//        log.info("The Selected Language is :" + sl.getFirstSelectedOption().getText());
//
//        Thread.sleep(2000);
//
//        this.addl.click();
//        Thread.sleep(2000);
//    }
//
//    public void Slangs(List<List<String>> slangs) throws Exception {
//
//        String langs = slangs.get(1).get(0);
//        Select s2 = new Select(addlanguages);
//        s2.selectByValue(langs);
//        log.info("The Selected Language is :" + s2.getFirstSelectedOption().getText());
//
//        Thread.sleep(2000);
//    }

//    public void OnLine() {
//
//        this.onlineoption.click();
//    }

    public void ApplicationMessage() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        this.Applicationm.click();
        Thread.sleep(2000);
    }

    public void Purge() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);

        this.purgev.click();
        Thread.sleep(2000);
    }

//    public void PurgeVersions(List<List<String>> purgevv) throws Exception {
//
//        String CountryP = purgevv.get(1).get(0);
//        String ModelrangeP = purgevv.get(1).get(1);
//        String vversions = purgevv.get(1).get(2);
//
//        Select c1 = new Select(country);
//        c1.selectByValue(CountryP);
//
//        Select m1 = new Select(modelrange);
//        m1.selectByValue(ModelrangeP);
//
//        Thread.sleep(2000);
//        Select v1 = new Select(validateversion);
//        v1.selectByValue(vversions);
//
//        Thread.sleep(2000);
//    }
    public void PurgeVersions() throws Exception {
        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(country1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(country1.get(1)));

            // If clickable, then click it
            country1.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: country element is visible but NOT clickable!");
        }

        Thread.sleep(5000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(modelrange1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(modelrange1.get(1)));

            // If clickable, then click it
            modelrange1.get(1).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: modelrange element is visible but NOT clickable!");
        }
        Thread.sleep(5000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(validateversion1));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(validateversion1.get(0)));

            // If clickable, then click it
            validateversion1.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: validateversion element is visible but NOT clickable!");
        }

    }

    public void FilingPS() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        this.filing.click();
        Thread.sleep(2000);
    }

    public void SelectMutlic(List<List<String>> multicriteria) throws Exception {

        String mcountry = multicriteria.get(1).get(0);
        String Activity = multicriteria.get(1).get(1);

        Select mc = new Select(multicountry);
        mc.selectByVisibleText("France");

        Select ac = new Select(multicriteriaa);
        ac.selectByValue(Activity);

        Thread.sleep(2000);
    }

    public PS_CreationPage Psnumber1(String pfs) throws Exception {

        try {
            Pfssnumbers.clear();
            Pfssnumbers.click();
            Pfssnumbers.sendKeys(pfs);
        } catch (Exception e) {
            log.error("Failed to click and Failed sendKeys " + e);

        }
        Thread.sleep(2000);
        return this;

    }

    public void Psnumbers() throws Exception {
        String codesXpath = "//tr[@class='texte_Taleau']/td[3]/a";
        boolean found = false;
        int index = 0;
        while (!found) {
            List<WebElement> freshCodes = _hDriver.findElements(By.xpath(codesXpath));
            if (index >= freshCodes.size()) {
                System.out.println("Export is not available for any code.");
                break;
            }
            String currentUrl = _hDriver.getCurrentUrl();
            System.out.println("Current Url is:" + currentUrl);
            WebElement code = freshCodes.get(index);
            code.click();
            Thread.sleep(500); // Wait for UI update

            List<WebElement> exportButtons = _hDriver
                    .findElements(By.xpath("//a[@id='ctl00_mainContentPlaceHolder_EditProtocolEvents_lnkBtnExport']"));
            if (!exportButtons.isEmpty()) {
                WebElement export = exportButtons.get(0);
                if (export.isDisplayed() && export.isEnabled()) {
                    String num = pfstudyName.getText();
                    System.out.println("Pf Number is:" + num);

                    _hDriver.navigate().to(currentUrl);

                    qSearch.click();
                    Pfssnumbers.clear();
                    Pfssnumbers.click();
                    Pfssnumbers.sendKeys(num);
                    found = true;
                }
            }
            if (!found) {
                _hDriver.navigate().to(currentUrl);
                index++;
            }
        }
    }

    public void clickYellowArrowButton() {
        WebDriverWait wait = new WebDriverWait(_hDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(yellowArrowButton)).click();
//        System.out.println("Yellow arrow button clicked successfully.");
    }

    public void SelecttClient() throws Exception {

        Thread.sleep(3000);

        // Wait until elements are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(client2));

        try {
            // Check if the first element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(client2.get(0)));

            // If clickable, then click it
            client2.get(0).click();
            Thread.sleep(3000);

        } catch (TimeoutException e) {
            // Fail the scenario if element is NOT clickable
            throw new Exception("FAIL: client element is visible but NOT clickable!");
        }
    }

    public PS_CreationPage Psnumber() throws Exception {

        try {
            Pfssnumbers.clear();
            Pfssnumbers.click();
            Pfssnumbers.sendKeys(pfsNumber);
        } catch (Exception e) {
            log.error("Failed to click and Failed sendKeys " + e);

        }
        Thread.sleep(2000);
        return this;

    }

    public void Archivebtn() throws Exception {

        this.archive.click();
        Thread.sleep(2000);
        Alert al = _hDriver.switchTo().alert();
        String altexts = al.getText();
//        if(altexts.equals(altexts))
        System.out.println("The Inner text of alert is :" + altexts);
        al.accept();

        Thread.sleep(2000);

    }

    public void Unarchivebtn() throws Exception {

        this.unarchive.click();
        Thread.sleep(2000);
        Alert a2 = _hDriver.switchTo().alert();

        String actualText = a2.getText();

        System.out.println("The Inner text of alert is :" + actualText);

        String expectedText = "Do you want to unarchive these data?";

        // Assert.assertEquals(actualText, expectedText, "Alert text mismatch!");

        if (actualText.equals(expectedText)) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                    "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Alert is matched" + "</span>");
        } else {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
                    "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Alert is not matched" + "</span>");
            Assert.assertEquals(actualText, expectedText, "Alert text mismatch!");
        }
        a2.accept();
        Thread.sleep(2000);

    }

    public void PfRemoval() throws Exception {

        Actions act = new Actions(_hDriver);
        act.moveToElement(catable).build().perform();

        MouseOver(catable);

        Thread.sleep(1000);
        this.pfsremoval.click();
        Thread.sleep(2000);

//        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "Passed")
//        ExtentCucumberAdapter.getCurrentStep().log(Status.pass, "")
    }

    public void Checkpf() throws Exception {

        this.checkboxpf.click();
        Thread.sleep(2000);
    }

    public void CheckManualVersion() throws Exception {

//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        Thread.sleep(1000);
        this.ManualVersion.click();
        Thread.sleep(1000);

    }

    public void RBCVIntegration() throws Exception {
//        Actions act = new Actions(_hDriver);
//        act.moveToElement(catable).build().perform();

        MouseOver(catable);
        Thread.sleep(1000);
        this.IntegrationRBCV.click();
        Thread.sleep(1000);
    }

    public void SimilarVer() {

        this.similerversions.click();
    }

    public void Historybtn() throws Exception {

        this.History.click();

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Clicked on History" + "</span>");
        Thread.sleep(2000);
    }

    public void SeeVersion() throws Exception {
        this.seeversions.click();

        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
                "<span style = 'font-family : Arial; font-size : 12px; color:green;'>" + "Clicked on see versions" + "</span>");
        Thread.sleep(2000);

    }

    public void BackBts() {
        this.backbtn.click();
    }

    public void Copybtns() throws Exception {

        String originalUrl = _hDriver.getCurrentUrl();

        this.copybtn.click();

        Thread.sleep(2000);

        _hDriver.navigate().to(originalUrl);

        // String detailepageurl = "https://contrib.opel.preprod.inetpsa.com/Protocole/osc002_18.aspx";
        // String detailepageurl = "https://contrib.citroen.preprod.inetpsa.com/Protocole/osc002_18.aspx";
//        String detailepageurl = "https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_18.aspx";
//
//        _hDriver.navigate().to(detailepageurl);
//        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
//                "<span style = 'font-family : Arial; font-size : 12px; color:green;'> Navigate url :" + detailepageurl + "</span>");
        Thread.sleep(2000);
    }

    public void CancelModification() {
        this.modificationcancel.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = _hDriver.switchTo().alert();

        String textAlert = alert.getText();
        System.out.println("The Text of alert is:" + textAlert);
        alert.accept();
    }

    public void ModifyHistorybtn() throws Exception {

        this.Modifyhistory.click();
        Thread.sleep(3000);
        this.backbtn.click();
    }

    public void ModifyAddVersion() throws Exception {

        String originalUrl = _hDriver.getCurrentUrl();
        this.Modifyaddv.click();
        Thread.sleep(1000);
        _hDriver.navigate().to(originalUrl);

        // String detailepageurl = "https://contrib.opel.preprod.inetpsa.com/Protocole/osc002_18.aspx";
        // String detailepageurl = "https://contrib.citroen.preprod.inetpsa.com/Protocole/osc002_18.aspx";
        // String detailepageurl = "https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_18.aspx";

//        _hDriver.navigate().to(detailepageurl);
//        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
//                "<span style = 'font-family : Arial; font-size : 12px; color:green;'> Navigate url :" + detailepageurl + "</span>");
        Thread.sleep(2000);
    }

    public void ModifySeeVersions() throws Exception {

        this.modifySeever.click();
        Thread.sleep(1000);
        this.clickvers.click();
        Thread.sleep(2000);
    }

    public void Refreshbtn() {

        this.Refreshbtn.click();

    }

    public void ValidRefresh() throws Exception {

        this.validaterefresh.click();
        Thread.sleep(2000);
    }

    public void EstimaterateRadioBtn() throws Exception {
        this.estimaterateradiobtn.click();
        Thread.sleep(3000);
    }

    public void EstimatedRate() {
        this.estimaterate.click();
    }

    public void CancelEstimaterate() throws Exception {
        this.cancelbtn.click();
        Thread.sleep(1000);
    }

    public void CopyDataa() throws Exception {

        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        this.copydata.click();
        Thread.sleep(3000);
    }

    public void PasteeDataa() throws Exception {
        this.pastedata.click();
        Thread.sleep(3000);
    }

    public void RefreshVers() throws Exception {
        Thread.sleep(2000);
        this.refreshversion.click();
        Thread.sleep(2000);

    }

    public void ValidateRefresh() throws Exception {
        Thread.sleep(2000);
        this.validaterefreshbtn.click();
        Thread.sleep(2000);
    }

    public void RecalculateVersion() throws Exception {

        this.Recalculatever.click();
        Thread.sleep(2000);
    }

    public void AddOptionss() throws Exception {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(Addoptions)).click();

        // this.Addoptions.click();
        Thread.sleep(2000);
    }

    public void SubsidaryData() {

        JavascriptExecutor js = (JavascriptExecutor) _hDriver;
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.elementToBeClickable(Subsidaryprice)).click();
    }

//    public void AddingnewLines() {
//
//        wait.until(ExpectedConditions.elementToBeClickable(addingline)).click();

//    }
    public void Addnewlinesub() throws Exception {
        this.addingline.click();
        Thread.sleep(2000);
    }

//    public void Subdescription(String subdescription) throws Exception {
//        this.subdescription.click();
//        this.subdescription.clear();
//        this.subdescription.sendKeys(subdescription);
//
//    }
//
//    public void Subamounts(String subamount) throws Exception {
//        this.subamount.click();
//        this.subamount.clear();
//        Thread.sleep(2000);
//        this.subamount.sendKeys(subamount);
//    }

    public void enterSubDetailsInLatestRow1(String subdescription, String subamount) {
        // Wait for at least one row to be present in the table body
        WebDriverWait wait = new WebDriverWait(_hDriver, Duration.ofSeconds(10));
        List<WebElement> rows = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='ctl00_mainContentPlaceHolder_dtgBonus']//tbody/tr"), 0));

        // Always get the last row (most recently added)
        WebElement latestRow = rows.get(rows.size() - 1);

        try {
            // Wait for input fields to be present in the latest row
            WebElement subDescInput = wait.until(ExpectedConditions.visibilityOf(
                    latestRow.findElement(By.xpath(".//input[contains(@name, 'ctl00$mainContentPlaceHolder$dtgBonus$ctl04$tbText')]"))));
            WebElement subAmountInput = wait.until(ExpectedConditions.visibilityOf(
                    latestRow.findElement(By.xpath(".//input[contains(@name, 'ctl00$mainContentPlaceHolder$dtgBonus$ctl04$tbAmount')]"))));
            subDescInput.click();
            subDescInput.clear();
            subDescInput.sendKeys(subdescription);

            subAmountInput.click();
            subAmountInput.clear();
            subAmountInput.sendKeys(subamount);

            System.out.println("Entered subdescription: " + subdescription + " and subamount: " + subamount);
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Please create a new line");
        }
    }

    public void enterSubDetailsInLatestRow(String subdescription, String subamount) {
        // Wait for at least one row to be present in the table body
        WebDriverWait wait = new WebDriverWait(_hDriver, Duration.ofSeconds(10));
        List<WebElement> rows = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='ctl00_mainContentPlaceHolder_dtgBonus']//tbody/tr"), 0));

        // Wait for the newly added row to be present, targeting the last row
        WebElement latestRow = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='ctl00_mainContentPlaceHolder_dtgBonus']//tr[last()]")));

        try {
            // Locate and fill the description input field in the last row
            WebElement subDescInput = latestRow.findElement(By.xpath(".//td[2]//input[@type='text']"));
            subDescInput.click();
            subDescInput.clear();
            subDescInput.sendKeys(subdescription);

            // Locate and fill the amount input field in the last row
            WebElement subAmountInput = latestRow.findElement(By.xpath(".//td[3]//input[@type='text']"));
            subAmountInput.click();
            subAmountInput.clear();
            subAmountInput.sendKeys(subamount);

            System.out.println("Entered subdescription: " + subdescription + " and subamount: " + subamount);
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Please create a new line");
        }
    }

    public void ModifyHeaderbtn() throws Exception {

        this.modifyhead.click();
        // Thread.sleep(1000);
        // _hDriver.navigate().back();
        // _hDriver.navigate().to("https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_18.aspx");
//        String detailepageurl1 = "https://contrib.peugeot.preprod.inetpsa.com/Protocole/osc002_18.aspx";
//        _hDriver.navigate().to(detailepageurl1);
//        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
//                "<span style = 'font-family : Arial; font-size : 12px; color:green;'> Navigate url :" + detailepageurl1 + "</span>");
        Thread.sleep(2000);
    }

    public PS_CreationPage ModiStatusCode(String mscode) {

        try {
            Statuss.clear();
            wait.until(ExpectedConditions.elementToBeClickable(Statuss)).click();

            // Statuss.click();
            Statuss.sendKeys(mscode);
            Thread.sleep(2000);
        } catch (Exception e) {

            log.error("The status code is not applicable:" + e);
        }
        return this;
    }

}
