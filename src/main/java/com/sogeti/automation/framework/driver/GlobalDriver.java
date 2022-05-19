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
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GlobalDriver {
    private String browserName;
    private String localBrowser;
    private String defaultDownloadPath = null;
    private String _headless = null;
    private WebDriverListener _driver = null;
    private WebDriver _ldriver = null;
    private Logging log = new Logging(GlobalDriver.class.getName());

    public GlobalDriver() {
        _headless = System.getProperty("headlessMode");
        if (_headless == "true")
            log.info("Running tests in headless mode.");
    }

    public String setDownloadPath() {
        this.defaultDownloadPath = System.getProperty("user.dir")
                + PropertyReader.getFieldValue("DefaultDownloadPath");

        return defaultDownloadPath;
    }

    public WebDriver init(String browser) {
        setDownloadPath();
        if (browser == null) {
            localBrowser = PropertyReader.getFieldValue("defaultBrowser");
        } else {
            localBrowser = browser;
        }

        ThreadContext.pop();
        ThreadContext.push(localBrowser.toUpperCase());

        if (localBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            _ldriver = new ChromeDriver(setChromeOptions());
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

        log.info(String.valueOf(prefs));

        return options;
    }
}
