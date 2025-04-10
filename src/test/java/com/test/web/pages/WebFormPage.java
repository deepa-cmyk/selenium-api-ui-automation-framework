package com.test.web.pages;

import com.test.web.constants.TestDataConstatnts;
import com.test.web.elements.WebFormElements;
import com.test.web.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static com.test.web.constants.TestDataConstatnts.WEB_FORM_TITLE;
import static org.junit.Assert.*;

public class WebFormPage {

    WebFormElements webFormElements = new WebFormElements();

    WebDriver driver;

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebForm() {
        driver.get(TestDataConstatnts.WEBSITE_URL);
    }

    public void verifyPageTitle(){

        String pageTitle = WebFormElements.getWebFormTitle();
        assertEquals("Form title is incorrect", WEB_FORM_TITLE, pageTitle);
    }

    private void webDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void inputText(String text) throws InterruptedException {

        String textEntered = webFormElements.getTextInput(text);
        SeleniumHelper.getWebDriverWait();
        assertTrue("Input value entered does not match the input"
                ,text.equalsIgnoreCase(textEntered));

    }

    public void inputPassword(String password) throws InterruptedException {

        String enteredPassword = webFormElements.getPasswordInput(password);
        SeleniumHelper.getWebDriverWait();
        assertTrue("Password value entered does not match the input",password.equalsIgnoreCase(enteredPassword));

    }

    public void inputTextAreaContent() throws InterruptedException {

        boolean enteredText = webFormElements.getTextAreaInput();
        SeleniumHelper.getWebDriverWait();
        assertTrue(enteredText);

    }

    public void verifyDisabledElement() {

        boolean checkDisabledStatus = webFormElements.getDisabledElementStatus();
        assertTrue(checkDisabledStatus);

    }

    public void verifyReadOnlyElement() {

        boolean checkReadOnlyStatus = webFormElements.getReadOnlyElementStatus();
        assertTrue(checkReadOnlyStatus);

    }

    public void selectDropDownValue(String dropDownValue){

        String selectedDropdownValue = webFormElements.selectDropdownValue(dropDownValue);
        assertTrue(dropDownValue.equalsIgnoreCase(selectedDropdownValue));

    }

    public void selectDropdownListValue(String dataListValue) {

        String selectedDataListValue = webFormElements.selectDataListDropDown(dataListValue);
        assertTrue("DataListValue is selected correctly",
                dataListValue.equalsIgnoreCase(selectedDataListValue));

    }

    public void uploadFile() {

        boolean uploadFileStatus = webFormElements.uploadFile();
        assertTrue(uploadFileStatus);

    }

    public void checkDefaultCheckBoxStatus(){

        assertTrue(webFormElements.verifyCheckBox());

    }

    public void verifyRadioButtonStatus(){

        assertTrue(webFormElements.radioButtonAction());

    }

    public void selectDateFromDatePicker(String date) {

        String selectedDate = webFormElements.selectDateFromDatePicker(date);
        assertTrue("Selected date is not correct",date.equalsIgnoreCase(selectedDate));

    }

    public void clickSubmitButton() {
        webFormElements.clickSubmitButton();
    }

    public void selectColorPicker(String color) {
        Map<String, String> colorInfo = webFormElements.colorPickerSelection(color);
        assertEquals("Selected colour is not correct",
                colorInfo.get("initialColor"), colorInfo.get("selectedColor"));
    }

    public void selectRange(String rangeValue) {
        String rangeSelected = webFormElements.selectRange(rangeValue);
        assertTrue("Selected range is not correct",rangeSelected.equalsIgnoreCase(rangeValue));
    }

}
