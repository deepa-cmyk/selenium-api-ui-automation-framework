package com.test.web.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.test.web.constants.TestDataConstatnts.*;

public class BaseTest {

    public static WebDriver driver;

    // Method to get the WebDriver based on browser type
    protected void getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case FIREFOX:
                setFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    // Set up Firefox WebDriver
    private void setFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
    }

    // Method to close the WebDriver
    protected void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

