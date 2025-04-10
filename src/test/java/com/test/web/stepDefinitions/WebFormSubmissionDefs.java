package com.test.web.stepDefinitions;

import com.test.web.pages.WebFormSubmissionPage;
import com.test.web.utils.BaseTest;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.test.web.constants.TestDataConstatnts.RECEIVED;

public class WebFormSubmissionDefs extends BaseTest {

    WebFormSubmissionPage webFormSubmissionPage;

    //Form submission status is checked
    @Then("the web form is submitted")
    public void theWebFormIsSubmitted() throws InterruptedException {

        webFormSubmissionPage = new WebFormSubmissionPage(driver);

        String formSubmissionText = webFormSubmissionPage.submittedFormCheck();
        Assert.assertEquals("Form is not submitted", RECEIVED, formSubmissionText);
    }
}
