package com.sogeti.automation.framework.driver;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.AppConstants;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.utils.Logging;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GlobalDriver {

    private final Logging log = new Logging(GlobalDriver.class.getName());
    private String defaultDownloadPath = null;

    public GlobalDriver() {
        //    private String browserName;
        String _headless = System.getProperty("headlessMode");
        if (_headless.equalsIgnoreCase("true"))
            log.info("Running tests in headless mode.");
    }

    public String setDownloadPath() {
        this.defaultDownloadPath = System.getProperty("user.dir") + AppConstants.DEFAULT_DOWNLOAD_PATH;

        return defaultDownloadPath;
    }

    public SelfHealingDriver mobileinit(String url) throws Exception {
        String urlValue = null;
        SelfHealingDriver _sDriver = null;
        AppiumDriver delegate = null;
        setDownloadPath();
        if (url == null) {
            urlValue = AppConstants.Android.ANDROID_URL;

        } else {
            urlValue = url;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", AppConstants.Android.ANDROID_AUTOMATIONNAME);
        capabilities.setCapability("platformName", AppConstants.Android.ANDROID_PLATFORMNAME);
        capabilities.setCapability("platformVersion", AppConstants.Android.ANDROID_PLATFORMVERSION);
        capabilities.setCapability("deviceName", AppConstants.Android.ANDROID_DEVICENAME);
        capabilities.setCapability("udid", AppConstants.Android.ANDROID_UDID);
        capabilities.setCapability("orientation", AppConstants.Android.ANDROID_ORIENTATION);

        if(AppConstants.MOBILEEXECUTIONTYPE.equalsIgnoreCase("App"))
        {capabilities.setCapability("app", System.getProperty("user.dir") +AppConstants.Android.ANDROID_APP);
        }
        else if (AppConstants.MOBILEEXECUTIONTYPE.equalsIgnoreCase("Native")) {
            capabilities.setCapability("appPackage", AppConstants.Android.ANDROID_APP_PACKAGE);
            capabilities.setCapability("appActivity", AppConstants.Android.ANDROID_APP_ACTIVITY);
        }
        else {
            capabilities.setCapability("browserName", AppConstants.Android.ANDROID_BROWSERNAME);
            switch (AppConstants.Android.ANDROID_BROWSERNAME.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().clearResolutionCache().setup();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().clearResolutionCache().setup();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().clearResolutionCache().setup();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().clearResolutionCache().setup();
                    break;
            }
        }


        delegate = new AndroidDriver(new URL(urlValue), capabilities);
        _sDriver = SelfHealingDriver.create(delegate);
        _sDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.SMALL_WAIT));
        return _sDriver;
    }

    public SelfHealingDriver init(String browser) {
        String browserName = null;
        String executionServer = null;
        SelfHealingDriver _sDriver = null;
        WebDriver delegate = null;
        setDownloadPath();
        if (browser == null) {
            browserName = AppConstants.Web.TEST_BROWSER;
        } else {
            browserName = browser;
        }

        executionServer = AppConstants.EXECUTION_SERVER;

        ThreadContext.pop();
        ThreadContext.push(executionServer.toUpperCase());
        ThreadContext.push(browserName.toUpperCase());

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                if (executionServer.equalsIgnoreCase("remote")) {
                    try {
                            delegate = new RemoteWebDriver(new URL(AppConstants.Web.GRID_HUB_URL), setChromeOptions());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    delegate = new ChromeDriver(setChromeOptions());

                }
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().clearResolutionCache().setup();

                if (executionServer.equalsIgnoreCase("remote")) {
                    Main.main(new String[]{"standalone", "--port", AppConstants.Web.GRIP_HUB_PORT});

                    delegate = WebDriverManager.firefoxdriver()
                            .capabilities(setFirefoxOptions())
                            .remoteAddress(AppConstants.Web.GRID_HUB_URL)
                            .create();
                } else {
                    delegate = new FirefoxDriver(setFirefoxOptions());
                }
                break;

            case "edge":
                WebDriverManager.edgedriver().clearResolutionCache().setup();

                if (executionServer.equalsIgnoreCase("remote")) {
                    Main.main(new String[]{"standalone", "--port", AppConstants.Web.GRIP_HUB_PORT});

                    delegate = WebDriverManager.edgedriver()
                            .capabilities(setEdgeOptions())
                            .remoteAddress(AppConstants.Web.GRID_HUB_URL)
                            .create();
                } else {
                    delegate = new EdgeDriver(setEdgeOptions());
                }
                break;

            case "safari":
                WebDriverManager.safaridriver().clearResolutionCache().setup();

                if (executionServer.equalsIgnoreCase("remote")) {
                    Main.main(new String[]{"standalone", "--port", AppConstants.Web.GRIP_HUB_PORT});

                    delegate = WebDriverManager.safaridriver()
                            .capabilities(setSafariOptions())
                            .remoteAddress(AppConstants.Web.GRID_HUB_URL)
                            .create();
                } else {
                    delegate = new SafariDriver(setSafariOptions());
                }
                break;
        }
        _sDriver = SelfHealingDriver.create(delegate) ;
        _sDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.SMALL_WAIT));
        _sDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.LARGE_WAIT));
        _sDriver.manage().window().maximize();

        WebDriverListener listener = new WebDriverListener() {
            @Override
            public void beforeClick(WebElement element) {
                WebDriverListener.super.beforeClick(element);
            }
        };
        WebDriver driver = new EventFiringDecorator(listener).decorate(_sDriver);


        log.info("New driver instantiated.");

        return _sDriver;
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
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--use-fake-ui-for-media-stream=1");
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
        return options;
    }

    private SafariOptions setSafariOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", defaultDownloadPath);  //adding download folder preference
        prefs.put("download.prompt_for_download", "false");  //preferences for download notification
        prefs.put("profile.default_content_settings.popups", 0);  //preferences for pop-ups
        prefs.put("settings.language.preferred_languages", "en");  //language preferences

        SafariOptions options = new SafariOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setCapability("safari.cleansession", true);
        options.setAutomaticInspection(true);
        options.setAutomaticProfiling(true);

        options.merge(capabilities);

//        options.addArguments("--disable-notifications");
//        options.addArguments("--test-type");
//        options.addArguments("ignore-certificate-errors");
//        options.addArguments("--disable-extensions");
//        options.addArguments("start-maximized");
//        options.addArguments("--use-fake-ui-for-media-stream=1");
//        if (_headless.equalsIgnoreCase("true"))
//            options.setHeadless(true);

        return options;
    }
}
