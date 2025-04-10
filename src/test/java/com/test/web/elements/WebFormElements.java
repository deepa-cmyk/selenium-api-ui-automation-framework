package com.test.web.elements;

import com.test.web.utils.BaseTest;
import com.test.web.utils.Enum;
import com.test.web.utils.RandomGenerator;
import com.test.web.utils.SeleniumHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.test.web.utils.SeleniumHelper.getValue;


public class WebFormElements extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(WebFormElements.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public static String pageTitleLocator = "h1";

    public static String textInputLocator = "#my-text-id";

    public String passwordInputLocator = "input[name='my-password']";

    public String getTextAreaLocator() {
        return textAreaLocator;
    }

    public void setTextAreaLocator(String textAreaLocator) {
        this.textAreaLocator = textAreaLocator;
    }

    public String textAreaLocator = "div:nth-child(1) > label:nth-child(3) > textarea";

    public String getDisabledInputLocator() {
        return disabledInputLocator;
    }

    public void setDisabledInputLocator(String disabledInputLocator) {
        this.disabledInputLocator = disabledInputLocator;
    }

    public String disabledInputLocator = "input[placeholder='Disabled input']";

    public String getReadOnlyLocator() {
        return readOnlyLocator;
    }

    public void setReadOnlyLocator(String readOnlyLocator) {
        this.readOnlyLocator = readOnlyLocator;
    }

    public String readOnlyLocator = "input[value='Readonly input']";

    public String datePickerTextLocator = "input[name='my-date']";

    private static final By webFormTitle = By.cssSelector(pageTitleLocator);
    By textInput = By.cssSelector(textInputLocator);

    public String getDropdownLocator() {
        return dropdownLocator;
    }

    public void setDropdownLocator(String dropdownLocator) {
        this.dropdownLocator = dropdownLocator;
    }

    public String getFileInputSelector() {
        return fileInputSelector;
    }

    public void setFileInputSelector(String fileInputSelector) {
        this.fileInputSelector = fileInputSelector;
    }

    public String getDatePickerTextLocator() {
        return datePickerTextLocator;
    }

    public void setDatePickerTextLocator(String datePickerTextLocator) {
        this.datePickerTextLocator = datePickerTextLocator;
    }

    public String getColorPickerLocator() {
        return colorPickerLocator;
    }

    public void setColorPickerLocator(String colorPickerLocator) {
        this.colorPickerLocator = colorPickerLocator;
    }

    public String dropdownLocator = "label:nth-child(1) > select";

    public String dataListDropdownSelector = "input[list='my-options']";

    public String fileInputSelector = "input[type='file'][name='my-file']";

    public String defaultCheckBoxSelector = "#my-check-2";

    public String radioButtonSelector = "#my-radio-2";

    public String submitButtonSelector = "button[type='submit']";

    public String uploadFileButtonLocator = "div:nth-child(6) > label";

    public String colorPickerLocator = "input[name='my-colors']";

    public String rangeSelectLocator = "input[name='my-range']";

    public String formSubmittedPageTitle = "h1";

    public static String extractBaseFileName(String filePath) {

        Path path = Paths.get(filePath);
        // Extract the file name (with extension) using getFileName()
        String fileBaseName = path.getFileName().toString();

        return fileBaseName;
    }

    // Method to get the web form's title
    public static String getWebFormTitle() {
        String formTitleText = SeleniumHelper.getWebElementText(pageTitleLocator);
        log.info(formTitleText);
        return formTitleText;
    }

    public String getTextInput(String textInput) {

        WebElement inputLocator = SeleniumHelper.findWebElementByCSS(textInputLocator);
        SeleniumHelper.findWebElementByCSS(textInputLocator).sendKeys(textInput);

        String enteredInput = getValue(inputLocator);
        SeleniumHelper.findWebElementByCSS(textAreaLocator).click();

        return enteredInput;
    }

    public String getPasswordInput(String password) {

        WebElement inputLocator = SeleniumHelper.findWebElementByCSS(passwordInputLocator);
        SeleniumHelper.findWebElementByCSS(passwordInputLocator).sendKeys(password);

        String enteredPassword = String.valueOf(js.executeScript("return arguments[0].value;", inputLocator));
        SeleniumHelper.findWebElementByCSS(textAreaLocator).click();

        return enteredPassword;
    }

    public boolean getTextAreaInput() {

        String textAreaContent = RandomGenerator.generateRandomWord();

        WebElement textAreaLocator = SeleniumHelper.findWebElementByCSS(getTextAreaLocator());
        SeleniumHelper.findWebElementByCSS(getTextAreaLocator()).sendKeys(textAreaContent);
        String enteredTextAreaContent = String.valueOf(js.executeScript("return arguments[0].value;", textAreaLocator));

        return enteredTextAreaContent.equalsIgnoreCase(textAreaContent);
    }

    public boolean getDisabledElementStatus() {

        boolean disabledStatus = Boolean.parseBoolean(SeleniumHelper
                .getDOMAttribute(disabledInputLocator,"disabled"));

        if (!disabledStatus) {

            System.out.println("The element is enabled.");
            return false;
        } else {
            System.out.println("The element is disabled.");
            return true;
        }
    }

    public boolean getReadOnlyElementStatus() {

        boolean readOnlyStatus = Boolean.parseBoolean(SeleniumHelper.
                getDOMAttribute(readOnlyLocator,"readonly"));

        if (readOnlyStatus) {
            System.out.println("The element is readonly.");
            return true;
        } else {

            System.out.println("The element is enabled.");
            return false;
        }
    }

        public static Enum.DropdownOptions fromString(String value) {
            try {
                return Enum.DropdownOptions.valueOf(value.toUpperCase()); // case-insensitive
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid dropdown value: " + value);
            }
        }

    public String selectDropdownValue(String dropDwonValue) {

        Select dropdown = new Select(SeleniumHelper.findWebElementByCSS(getDropdownLocator()));
        dropdown.selectByVisibleText(dropDwonValue);

        return dropdown.getFirstSelectedOption().getText();
    }

    public String selectDataListDropDown(String dataListValue) {

        WebElement dataListElement = SeleniumHelper.findWebElementByCSS(dataListDropdownSelector);
        dataListElement.click();
        dataListElement.sendKeys(dataListValue);

        SeleniumHelper.findWebElementByCSS(textAreaLocator).click();

        String selectedValue = String.valueOf(js.executeScript("return arguments[0].value;", dataListElement));
        log.info("Selected value: " + selectedValue);

        return selectedValue;
    }

    public boolean uploadFile() {
        WebElement fileInput = SeleniumHelper.findWebElementByCSS(fileInputSelector);

        // Define the path to the file to be uploaded (adjust the file path accordingly)
        String filePath = "src/test/resources/web/testData/test"; // Replace with your file path
        fileInput.sendKeys(filePath);
        SeleniumHelper.findWebElementByCSS(textAreaLocator).click();
        String uploadedFileName = fileInput.getAttribute("value");

        log.info("Uploaded file name: " + extractBaseFileName(uploadedFileName));
        // Extract just the file name from the full file path (i.e., "sample.txt")
        String fileNameOnly = new File(filePath).getName();

        return uploadedFileName.contains(fileNameOnly);
    }

    public boolean verifyCheckBox() {
        WebElement checkBox = SeleniumHelper.findWebElementByCSS(defaultCheckBoxSelector);
        checkBox.click();
        SeleniumHelper.clickElementWithDelay(textAreaLocator);
        return checkBox.isSelected();
    }

    public boolean radioButtonAction(){

        WebElement radioButtonSelection = SeleniumHelper.findWebElementByCSS(radioButtonSelector);
        radioButtonSelection.click();
        SeleniumHelper.clickElementWithDelay(textAreaLocator);
        return radioButtonSelection.isSelected();
    }

    public Map<String, String> colorPickerSelection(String color){

        WebElement colorPicker =SeleniumHelper.findWebElementByCSS(colorPickerLocator);
        SeleniumHelper.getWebDriverWait();
        Map<String, String> colorInfo = new HashMap<>();

        String initialColor = colorPicker.getAttribute("value");
        colorPicker.sendKeys(color);

        String selectedColor = colorPicker.getAttribute("value");

        colorInfo.put("initialColor", initialColor);
        colorInfo.put("selectedColor", selectedColor);

        return colorInfo;

    }

    public String selectDateFromDatePicker(String date){

        WebElement dateInput = SeleniumHelper.findWebElementByCSS(datePickerTextLocator);
        dateInput.clear();

        dateInput.sendKeys(date);
        String enteredDate = getValue(dateInput);

        System.out.println("Entered date: " + enteredDate);
        SeleniumHelper.clickElementWithDelay(textAreaLocator);

        return enteredDate;

    }

    public String selectRange(String rangeValue) {

        WebElement rangeInput = SeleniumHelper.findWebElementByCSS(rangeSelectLocator);
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('input'));" +
                        "arguments[0].dispatchEvent(new Event('change'));",
                rangeInput, rangeValue
        );
        SeleniumHelper.clickElementWithDelay(textAreaLocator);

        return getValue(rangeInput);

    }


    public void clickSubmitButton() {

        SeleniumHelper.clickElementWithDelay(submitButtonSelector);

    }

}

