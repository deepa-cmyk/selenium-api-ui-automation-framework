package com.test.web.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.test.web.constants.TestDataConstatnts.*;

public class BaseTest {

    public static WebDriver driver;

    // Method to get the WebDriver based on browser type
    protected void getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case CHROME:
                setChromeDriver();
                break;
            case FIREFOX:
                setFirefoxDriver();
                break;
            case EDGE:
                setEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    // Set up Chrome WebDriver
    private void setChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    // Set up Firefox WebDriver
    private void setFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
    }

    private void setEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
    }

    // Method to close the WebDriver
    protected void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

