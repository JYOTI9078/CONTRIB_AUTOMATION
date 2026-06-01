package com.sogeti.automation.test.pageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class Login {

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Save cookies after manual login
    public void saveAuthState(String filePath) throws IOException {
        filePath = "C://Users//SG02410//LITMUS01 (2)//LITMUS01//src//test//resources//cookies.data";
        Set<Cookie> cookies = driver.manage().getCookies();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(cookies);
        }
        System.out.println("Saved authenticated state to " + filePath);
    }

    // Load cookies before test to reuse session
    public boolean loadAuthState(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Auth state file not found. Please login and save state first.");
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Set<Cookie> cookies = (Set<Cookie>) ois.readObject();
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
            System.out.println("Loaded authenticated state from " + filePath);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load cookies: " + e.getMessage());
            return false;
        }
    }

    // Check if user is logged in (customize for your app)
    public boolean isLoggedIn() {
        try {
            // Example: check for a specific element or page title
            return !driver.getTitle().toLowerCase().contains("login");
        } catch (Exception e) {
            return false;
        }
    }
}