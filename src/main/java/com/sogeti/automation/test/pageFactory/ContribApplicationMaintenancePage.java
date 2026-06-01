/*
 * Creation : 9 Mar 2026
 */
package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class ContribApplicationMaintenancePage extends PageClass {

    public ContribApplicationMaintenancePage(SelfHealingDriver _hDriver) {
        super(_hDriver);
        wait = new WebDriverWait(_hDriver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(_hDriver, this);
    }

    @FindBy(xpath = "//a[text()='Contrib Administration']")
    private WebElement contribAdmin;

//    @FindBy(xpath = "//a[text()='Application Maintainance_Test23']")
//    private WebElement applicationMaintainance;
    @FindBy(xpath = "//a[contains(text(),'Application') and contains(text(),'maintainance')]")
    private WebElement applicationMaintainance;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_MessageTitle']")
    private WebElement messageTitle;

    @FindBy(xpath = "//textarea[@id='ctl00_mainContentPlaceHolder_MessageBody']")
    private WebElement messageBody;

    private String generatedMessageBody;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_StartDateTime']")
    private WebElement startDate;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_EndDateTime']")
    private WebElement endDate;

    @FindBy(xpath = "//*[normalize-space()='Today']")
    private WebElement today;

    @FindBy(xpath = "//input[@id='ctl00_mainContentPlaceHolder_BtnSchedule']")
    private WebElement schedule;

    @FindBy(xpath = "(//div[@class='mt-3'])[1]")
    private WebElement homePageText;

    @FindBy(xpath = "//table[@id='ctl00_mainContentPlaceHolder_GridMessages']/tbody/tr/th")
    private List<WebElement> verifyHeadersections;

    @FindBy(xpath = "(//table[@id='ctl00_mainContentPlaceHolder_GridMessages']/tbody/tr/th)[5]")
    private WebElement verifyScheduleStatus;

    @FindBy(xpath = "(//table[@id='ctl00_mainContentPlaceHolder_GridMessages']/tbody/tr[2]/td)[5]")
    private WebElement verifyStatus;

    @FindBy(xpath = "//span[text()='Welcome to CONTRIB']")
    private WebElement welcomeContrib;

    @FindBy(xpath = "//a[text()='Get Support']")
    private WebElement verifyGetsupport;

    @FindBy(xpath = "//a[text()='CONTRIB Guide']")
    private WebElement verifyContribGuide;

    @FindBy(xpath = "")
    private WebElement envLogo;

    // Header "Home" link wrapping the logo (optional, but useful to ensure region is loaded)
    @FindBy(id = "ctl00_Header1_lnkBtnDefault")
    private WebElement headerHomeLink;

    // Actual <img> for the brand logo
    @FindBy(id = "ctl00_Header1_imgLogo")
    private WebElement headerBrandLogoImg;

    // Example: individual brand elements you already use
    @FindBy(id = "peugeotLogo")
    private WebElement verifyPeugeot;

    @FindBy(id = "citroenLogo")
    private WebElement verifyCitroen;

    @FindBy(id = "opelLogo")
    private WebElement verifyOpel;

    @FindBy(id = "fiatLogo")
    private WebElement verifyFiat;

    @FindBy(id = "jeepLogo")
    private WebElement verifyJeep;

    @FindBy(id = "fiatProLogo")
    private WebElement verifyFiatprofe;

    @FindBy(id = "abarthLogo")
    private WebElement verifyAbarth;

    @FindBy(id = "alfaLogo")
    private WebElement verifyAlfa;

    @FindBy(id = "lanciaLogo")
    private WebElement verifyLancia;

    // If your DOM has a common selector, prefer this instead (comment out if not applicable):
    // @FindBy(css = ".brand-logo")
    // private List<WebElement> allBrandLogos;

    public void applicationMaintainance() throws Exception {

        try {
            MouseOver(contribAdmin);
            System.out.println("The MouseOver element name is:" + contribAdmin.getText());
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(applicationMaintainance));
            applicationMaintainance.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            log.error("Failed: " + e);
            throw e;
        }

    }

    private String generatedMessageTitle; // store here to verify later

    public void enterMessageTitle() {

        // 1. Click the element
        messageTitle.click();

        // 2. Generate text: "Testing" + 3 random numbers
        int randomNum = (int) (Math.random() * 900) + 100; // always 3 digits
        generatedMessageTitle = "Testing" + randomNum;

        // 3. Type the text
        messageTitle.clear();
        messageTitle.sendKeys(generatedMessageTitle);

        // 4. Print for debugging
        System.out.println("Generated Message Title: " + generatedMessageTitle);
    }

    /**
     * Getter so test method can verify value later
     */
    public String getGeneratedMessageTitle() {
        return generatedMessageTitle;
    }

    public void enterMessageBody() {

        messageBody.click();

        int randomNum = (int) (Math.random() * 900) + 100;
        generatedMessageBody = "Test" + randomNum;
        messageBody.clear();
        messageBody.sendKeys(generatedMessageBody);

        System.out.println("Generated Message Body: " + generatedMessageBody);
    }

    public String getGeneratedMessageBody() {
        return generatedMessageBody;
    }

//    public void startDate() throws Exception {
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//
//        // Format to datetime-local format
//        String todayDateTime = now.format(formatter);
//
//        // Send keys
//        startDate.clear();
//        startDate.sendKeys(todayDateTime);
//
//        System.out.println("Entered Start DateTime: " + todayDateTime);
//        Thread.sleep(5000);
//
//    }
    
    
//    public void endDate() throws Exception {
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
//
//        // Format to datetime-local format
//        String todayDateTime = now.format(formatter);
//
//        // Send keys
//        endDate.clear();
//        endDate.sendKeys(todayDateTime);
//
//        System.out.println("Entered End DateTime: " + todayDateTime);
//        Thread.sleep(5000);
//    }
    
    public void startDate() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = now.plusMinutes(1);  // Add 1 minutes
        
        // Format date and time separately
        String dateString = startDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String timeString = startDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        
        startDate.click();
        startDate.clear();
        startDate.sendKeys(dateString);
        
        // Tab to time field
        startDate.sendKeys(Keys.TAB);
        Thread.sleep(500);
        
        // Send time
        startDate.sendKeys(timeString);
        
        System.out.println("Entered Start DateTime: " + dateString + " " + timeString);
        Thread.sleep(5000);
    }

    public void endDate() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endDateTime = now.plusMinutes(4);  // Add 4 minutes
        
        // Format date and time separately
        String dateString = endDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String timeString = endDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        
        endDate.click();
        endDate.clear();
        endDate.sendKeys(dateString);
        
        // Tab to time field
        endDate.sendKeys(Keys.TAB);
        Thread.sleep(500);
        
        // Send time
        endDate.sendKeys(timeString);
        
        System.out.println("Entered End DateTime: " + dateString + " " + timeString);
        Thread.sleep(5000);
    }
    

    public void schedule() throws Exception {

        Thread.sleep(3000);
        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(schedule));
            schedule.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            log.error("Failed : " + e.getMessage());
            throw e;
        }
    }

//    public void homePageverification() throws Exception {
//        String currentUrl = _hDriver.getCurrentUrl();
//
//        String homePageurl = "https://contrib.pprod.inetpsa.com/homepage.aspx";
//        _hDriver.navigate().to(homePageurl);
//        Thread.sleep(2000);
//
//        String homePageTexts = homePageText.getText();
//
//        System.out.println("Home Page Text is :" + homePageTexts);
//
//        if (homePageTexts.equals(generatedMessageBody)) {
//            System.out.println("Both are same");
//        } else {
//            System.out.println("Not same");
//        }
//    }
    public void homePageverification() throws Exception {
        String homePageurl = "https://contrib.pprod.inetpsa.com/homepage.aspx";
        WebDriverWait wait = new WebDriverWait(_hDriver, Duration.ofSeconds(15));

        _hDriver.navigate().to(homePageurl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[normalize-space(.)='Welcome to CONTRIB']")));

        boolean found = false;

        // Retry for up to ~2 minutes (24 * 5s)
        for (int i = 0; i < 24; i++) {
            _hDriver.navigate().refresh();
            Thread.sleep(5000);

            List<WebElement> msg = _hDriver.findElements(
                    By.xpath("//*[contains(normalize-space(.),'" + generatedMessageBody + "')]"));

            if (!msg.isEmpty()) {
                System.out.println("Message found on homepage: " + msg.get(0).getText());
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "Scheduled message not displayed on homepage yet: " + generatedMessageBody);
    }

    public void verifyScheduledSections() {

        // Expected header list (exactly as in HTML)
        List<String> expectedHeaders = Arrays.asList("Title", "Body", "Start Date & Time", "End Date & Time", "Status", "Action", "Delete");

        // Read actual headers from UI
        List<String> actualHeaders = verifyHeadersections.stream().map(e -> e.getText().trim().replaceAll("\\s+", " ")) // normalize spaces
                .collect(Collectors.toList());

        System.out.println("Actual Headers: " + actualHeaders);

        // 1. Assert header count
        Assert.assertEquals(actualHeaders.size(), expectedHeaders.size(), "Header count mismatch!");

        // 2. Assert each header text
        for (int i = 0; i < expectedHeaders.size(); i++) {
            Assert.assertEquals(actualHeaders.get(i), expectedHeaders.get(i), "Header mismatch at index " + i);
        }

        System.out.println("All Scheduled Section Headers verified successfully!");
    }

    public void printStatusColumn() {

        // Get text from UI
        String statusText = verifyStatus.getText().trim();

        // Normalize spacing
        statusText = statusText.replaceAll("\\s+", " ").trim();

        // Print it
        System.out.println("Status Column Text is: " + statusText);

        // Optional: check what it is
        if (statusText.equalsIgnoreCase("Scheduled")) {
            System.out.println("Message status is SCHEDULED");
        } else if (statusText.equalsIgnoreCase("Published")) {
            System.out.println("Message status is PUBLISHED");
        } else if (statusText.equalsIgnoreCase("Expired")) {
            System.out.println("Message status is EXPIRED");
        } else {
            System.out.println("Unknown status: " + statusText);
        }
    }

    public void printWelcomeContrib() throws Exception {
        // More robust locator: matches any element whose combined text equals the phrase
        // By welcome = By.xpath("//*[normalize-space(.)='Welcome to CONTRIB']");

        // WebElement el = _hDrive(welcomeContrib);
        Thread.sleep(3000);
        String text = welcomeContrib.getText().replaceAll("\\s+", " ").trim();

        System.out.println("Homepage text is: " + text);

        if ("Welcome to CONTRIB".equals(text)) {
            System.out.println("Yes, it is present.");
        } else {
            System.out.println("No, different text.");
        }
    }

    public void verifyGetSupport() {

        String get = verifyGetsupport.getText();

        System.out.println("Get support " + get);

        if (get.equals("Get Support")) {
            System.out.println("Get Support Hyperlink is Present In Homepage");
        } else {
            System.out.println("Get Support Hyperlink is NOT Present In Homepage");

        }
    }

    public void verifyContribGuide() {

        String get = verifyContribGuide.getText();

        System.out.println("ContribGuide is" + get);

        if (get.equals("CONTRIB Guide")) {
            System.out.println("CONTRIB Guide Hyperlink is Present In Homepage");
        } else {
            System.out.println("CONTRIB Guide Hyperlink is NOT Present In Homepage");

        }
    }

    public void verifyWelcomeContrib() {

        WebElement el = _hDriver.findElement(By.xpath("//h1[normalize-space(.)='Welcome to CONTRIB']"));

        String text = el.getText().replaceAll("\\s+", " ").trim();

        System.out.println("Homepage text is: " + text);

        if (text.equals("Welcome to CONTRIB")) {
            System.out.println("Yes, it is present in correct format.");
        } else {
            System.out.println("No, text is different.");
        }
    }

    public void verifyBrandLogoAfterClick() {
        final Duration TIMEOUT = Duration.ofSeconds(15);
        WebDriverWait wait = new WebDriverWait(_hDriver, TIMEOUT);

        try {
            // Wait for the logo <img> to be present & visible
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_Header1_imgLogo")));
            WebElement logoImg = wait.until(ExpectedConditions.visibilityOf(headerBrandLogoImg));

            // Read the src
            String src = logoImg.getAttribute("src");
            System.out.println("Brand logo src = " + src);

            // Defensive null/empty check
            Assert.assertNotNull(src, "Brand logo 'src' is null!");
            Assert.assertFalse(src.isBlank(), "Brand logo 'src' is empty!");

            // Get expected token(s) for selected brand
            String brand = Web.Brand; // you already set this earlier
            List<String> expectedTokens = expectedLogoTokensForBrand(brand);

            // Normalize src for case-insensitive contains check
            String srcLower = src.toLowerCase();

            // Check if any expected token is present
            boolean matches = expectedTokens.stream().anyMatch(t -> srcLower.contains(t));

            // Helpful failure message includes what we expected vs got
            Assert.assertTrue(matches,
                    "Logo src does not match brand. Brand=" + brand + ", expected any of " + expectedTokens + ", actual src=" + src);

            System.out.println("Brand logo verified for brand = " + brand);

        } catch (TimeoutException te) {
            System.out.println("DEBUG URL: " + _hDriver.getCurrentUrl());
            System.out.println("DEBUG TITLE: " + _hDriver.getTitle());
            throw te;
        }
    }

    private List<String> expectedLogoTokensForBrand(String brand) {
        if (brand == null) {
            return new ArrayList<>();
        }
        
        String brandLower = brand.toLowerCase();
        
        switch (brandLower) {
            case "peugeot":
                return Arrays.asList("peugeot");
            case "citroen":
                return Arrays.asList("citroen");
            case "opel":
                return Arrays.asList("opel");
            case "fiat":
                return Arrays.asList("fiat");
            case "jeep":
                return Arrays.asList("jeep");
            case "alfa":
                return Arrays.asList("alfa");
            case "lancia":
                return Arrays.asList("lancia");
            case "abarth":
                return Arrays.asList("abarth");
            case "contrib":
                return Arrays.asList("citroen");
            default:
                return new ArrayList<>();
        }
    }

    public void verifyOnlyOneBrandSelected() {

        List<WebElement> brandList = Arrays.asList(verifyPeugeot, verifyCitroen, verifyOpel, verifyFiat, verifyJeep, verifyFiatprofe, verifyAbarth,
                verifyAlfa, verifyLancia);

        int selectedCount = 0;

        for (WebElement brand : brandList) {

            if (brand == null)
                continue;

            String cls = brand.getAttribute("class");

            if (cls != null && (cls.contains("active") || cls.contains("selected"))) {
                selectedCount++;
            }
        }

        System.out.println("Selected brand count = " + selectedCount);

        if (selectedCount == 1) {
            System.out.println("Only one brand is selected.");
        } else {
            System.out.println("More than one brand is selected! Fix needed.");
        }
    }

    public void countBrandsThenClickAndPrint() {
        String brand = Web.Brand; // e.g., "FIAT" from qa.properties
        WebDriverWait wait = new WebDriverWait(_hDriver, Duration.ofSeconds(10));

        // 1) Count how many brand buttons are present BEFORE click
        List<WebElement> allBrands = _hDriver.findElements(By.cssSelector(".brands-grid .brand-btn"));
        System.out.println("Brands present BEFORE click = " + allBrands.size());

        // 2) Click the requested brand by data-brand
        By brandBtn = By.cssSelector(".brands-grid .brand-btn[data-brand='" + brand + "']");
        WebElement toClick = wait.until(ExpectedConditions.elementToBeClickable(brandBtn));
        toClick.click();

        // Small pause (optional) if UI updates asynchronously
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }

        // 3) Print which brand was clicked
        System.out.println("Clicked brand = " + brand);

    }

    public void verifyHomePageBrandBehavior() {

        // 1) Collect all brand logo buttons
        List<WebElement> brands = _hDriver.findElements(By.cssSelector(".brands-grid .brand-btn"));

        System.out.println("Total number of brands present = " + brands.size());

        // 2) Loop each brand and print its behavior like click operations
        for (WebElement brand : brands) {

            String brandName = brand.getAttribute("data-brand");

            boolean displayed = brand.isDisplayed();
            boolean enabled = brand.isEnabled();

            // Image under the button
            WebElement img = null;
            try {
                img = brand.findElement(By.tagName("img"));
            } catch (Exception ignored) {
            }

            String imgSrc = (img != null) ? img.getAttribute("src") : "NO IMAGE";
            String imgAlt = (img != null) ? img.getAttribute("alt") : "NO ALT";

            System.out.println("\nBrand Name : " + brandName);
            System.out.println(" - Displayed : " + displayed);
            System.out.println(" - Enabled   : " + enabled);
            System.out.println(" - Image ALT : " + imgAlt);
            System.out.println(" - Image SRC : " + imgSrc);
            System.out.println(" - Behavior  : Logo is present and ready for click operation");
        }
    }

    public void verifyBrandLogosOnHomePage() {

        // Get all brand buttons
        List<WebElement> brands = _hDriver.findElements(By.cssSelector(".brands-grid .brand-btn"));

        System.out.println("Total brands found = " + brands.size());

        // Loop through each brand tile
        for (WebElement brand : brands) {

            // Read brand name from data-brand
            String brandName = brand.getAttribute("data-brand").trim();

            // Find the image inside this button
            WebElement img = brand.findElement(By.tagName("img"));

            String imgSrc = img.getAttribute("src");
            String imgAlt = img.getAttribute("alt");

            // Expected token in src must be: BRAND_logo
            String expectedToken = brandName + "_logo";

            System.out.println("\nChecking brand: " + brandName);
            System.out.println(" - img alt = " + imgAlt);
            System.out.println(" - img src = " + imgSrc);

            if (imgSrc.toLowerCase().contains(expectedToken.toLowerCase())) {
                System.out.println("PASS: Correct logo found for brand: " + brandName);
            } else {
                System.out.println("FAIL: Incorrect logo for brand: " + brandName);
                System.out.println("    Expected token in src: " + expectedToken);
            }
        }
    }

    public void verifyWelcomeToContribHyperlink() {

        // Locate the hyperlink
        WebElement link = _hDriver.findElement(By.xpath("//a[@id='ctl00_Header1_lnkBtnGroupPortal']//span[normalize-space()='Welcome to CONTRIB']"));

        // Check visibility
        if (link.isDisplayed()) {
            System.out.println("PASS: 'Welcome to CONTRIB' hyperlink is displayed in the header.");
        } else {
            System.out.println("FAIL: 'Welcome to CONTRIB' hyperlink is NOT displayed in the header.");
        }

        // Optional: verify it's inside an <a> link
        WebElement parentLink = _hDriver.findElement(By.id("ctl00_Header1_lnkBtnGroupPortal"));
        String href = parentLink.getAttribute("href");
        System.out.println("Hyperlink reference = " + href);
    }

    public void verifyRealTimeStatusIndicator() throws Exception {

        Thread.sleep(3000);
        // Status icon (any color allowed)
        WebElement icon = _hDriver.findElement(By.xpath("//span[contains(@class,'fs-5')]"));

        // Status text
        WebElement textElement = _hDriver.findElement(By.xpath("//div[contains(@class,'fw-bold')]"));

        String text = textElement.getText().trim();

        System.out.println("Status Text  : " + text);
        System.out.println("Icon Present : " + icon.isDisplayed());

        if (icon.isDisplayed() && text.equals("Application Available")) {
            System.out.println("PASS: Real-time status indicator is correct.");
        } else {
            System.out.println("FAIL: Real-time status indicator is incorrect.");
        }
    }

}
