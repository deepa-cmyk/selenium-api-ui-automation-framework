package com.test.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.test.web.utils.SeleniumHelper.waitUntilElementVisible;

public class WebFormSubmissionPage {

    WebDriver driver;

    public WebFormSubmissionPage(WebDriver driver) {
        this.driver = this.driver;
    }

    public String messageLocator = "#message";

    public String submittedFormCheck() throws InterruptedException {
        WebElement formSubmittedElement = waitUntilElementVisible(messageLocator);
        return formSubmittedElement.getText();

    }


}
