package com.sogeti.automation.framework.driver;

import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.utils.Logging;
import com.sogeti.automation.framework.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GlobalDriver {

    private String browserName;
    private String localBrowser;
    private String _headless = null;
    private WebDriverListener _driver = null;
    private WebDriver _ldriver = null;
    private Logging log = new Logging(GlobalDriver.class.getName());
    private String defaultDownloadPath = null;

    public GlobalDriver() {
        try {
            _headless = System.getProperty("headlessMode");
            if (_headless == "true")
                log.info("Running tests in headless mode.");
        } catch (Exception ignore) {}
    }

    public String setDownloadPath() {
        this.defaultDownloadPath = System.getProperty("user.dir")
                + PropertyReader.getFieldValue("DefaultDownloadPath");

        return defaultDownloadPath;
    }

    public WebDriver init(String browser) {
        setDownloadPath();
        if (browser == null) {
            localBrowser = PropertyReader.getFieldValue("TestBrowser");
        } else {
            localBrowser = browser;
        }

        ThreadContext.pop();
        ThreadContext.push(localBrowser.toUpperCase());

        if (localBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            _ldriver = new ChromeDriver(setChromeOptions());
        }
        else if (localBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().clearResolutionCache().setup();
            _ldriver = new FirefoxDriver(setFirefoxOptions());
        }
        else if (localBrowser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().clearResolutionCache().setup();
            _ldriver = new EdgeDriver(setEdgeOptions());
        }

        WebDriverListener listener = new WebDriverListener() {
            @Override
            public void beforeClick(WebElement element) {
                WebDriverListener.super.beforeClick(element);
            }
        };
        WebDriver driver = new EventFiringDecorator(listener).decorate(_ldriver);


        log.info("New driver instantiated.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.SmallWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.LargeWait));
        driver.manage().window().maximize();

        return _ldriver;
    }

    private ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", defaultDownloadPath);  //adding download folder preference
        prefs.put("download.prompt_for_download", "false");  //preferences for download notification
        prefs.put("profile.default_content_settings.popups", 0);  //preferences for pop-ups
        prefs.put("settings.language.preferred_languages", "en");  //language preferences

        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--disable-notifications");
        options.addArguments("--test-type");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--use-fake-ui-for-media-stream=1");

//        log.info(String.valueOf(prefs));

        return options;
    }

    private FirefoxOptions setFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", defaultDownloadPath);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.popups.showPopupBlocker", false);
        profile.setPreference("privacy.popups.showBrowserMessage", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.zoom.full", true);
        profile.setPreference("javascript.enabled", true);
//    profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//    profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//      "image/jpeg;application/vnd.ms-excel;image/png;application/pdf;application/msword;application/zip;text/csv");

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.setAcceptInsecureCerts(true);

//        log.info(String.valueOf(options));
        return options;
    }

    private EdgeOptions setEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", defaultDownloadPath);  //adding download folder preference
        prefs.put("download.prompt_for_download", "false");  //preferences for download notification
        prefs.put("profile.default_content_settings.popups", 0);  //preferences for pop-ups
        prefs.put("settings.language.preferred_languages", "en");  //language preferences

        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--disable-notifications");
        options.addArguments("--test-type");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--use-fake-ui-for-media-stream=1");

//        log.info(String.valueOf(prefs));

        return options;
    }
}
