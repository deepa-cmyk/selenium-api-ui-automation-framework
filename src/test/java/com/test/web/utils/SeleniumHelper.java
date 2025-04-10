package com.test.web.utils;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumHelper extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(SeleniumHelper.class);

    public static WebElement findWebElementByCSS(String cssLocator) {

        return BaseTest.driver.findElement(By.cssSelector(cssLocator));

    }

    public static String getWebElementText(String webElementLocator) {

        log.info("getWebElementText---{}", BaseTest.driver.findElement(By.cssSelector(webElementLocator)).getText());
        return driver.findElement(By.cssSelector(webElementLocator)).getText();

    }

    public static String getDOMAttribute(String cssLocator,String domAttribute) {

        return BaseTest.driver.findElement(By.cssSelector(cssLocator)).getDomAttribute(domAttribute);

    }

    public static void sleep(int milliseconds) {

        try {
            Thread.sleep(milliseconds); // Sleeps for specified time
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted: " + e.getMessage());
        }

    }

    public static void clickElementWithDelay(String webElementLocator) {

        WebElement element = driver.findElement(By.cssSelector(webElementLocator));
        if(element.isDisplayed())
            element.click();
        else
            log.info("Element is not displayed");
        sleep(1000);  // Adding 1-second delay after the click action

    }

    public static void getWebDriverWait() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    }

    public static WebElement waitUntilElementVisible(String elementLocator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(visibilityOfElementLocated(By.cssSelector(elementLocator)));

    }

    private static JavascriptExecutor javascriptExecutorHelper(String value, WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", webElement, value);
        return js;

    }

    public static String getValue(WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return String.valueOf(js.executeScript("return arguments[0].value;", webElement));

    }
}
