package com.test.web.stepDefinitions;

import com.test.web.pages.WebFormPage;
import com.test.web.utils.BaseTest;
import com.test.web.utils.SeleniumHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WebFormStepDefs extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(WebFormStepDefs.class);
    WebFormPage webFormPage;
    private DataTable dataTable;

    //User navigates to the web form
    @Given("user is on the webform")
    public void userIsOnTheWebform() throws InterruptedException {

        webFormPage = new WebFormPage(driver);

        webFormPage.openWebForm();
        SeleniumHelper.getWebDriverWait();
        webFormPage.verifyPageTitle();
    }

    // User enters data into the form fields as defined in the feature file
    // and verifies that other related form elements are correctly updated or displayed.
    @And("user enters the form data")
    public void entersTheFormData(DataTable dataTable) throws InterruptedException {
        this.dataTable = dataTable;

        Map<String, String> dataTableData = new HashMap<>();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        // Iterate through the rows to store data in the dataTableData map
        for (Map<String, String> row : rows) {
            String text = row.get("text");
            String password = row.get("password");
            String dropDownValue = row.get("dropDownValue");
            String dataListValue = row.get("DataListValue");
            String colorPicker = row.get("ColorPicker");
            String datePicker = row.get("DatePicker");
            String rangeValue = row.get("RangeValue");

            // Storing the values in the dataTableData map
            dataTableData.put("text", text);
            dataTableData.put("password", password);
            dataTableData.put("dropDownValue", dropDownValue);
            dataTableData.put("dataListValue", dataListValue);
            dataTableData.put("colorPicker", colorPicker);
            dataTableData.put("datePicker", datePicker);
            dataTableData.put("rangeValue", rangeValue);

            log.info(String.valueOf(dataTableData));
        }

        //Methods to check the web form elements,
        // enter data and verify the entered data is captured correctly

        //Input boxes
        webFormPage.inputText(dataTableData.get("text"));
        webFormPage.inputPassword(dataTableData.get("password"));
        webFormPage.inputTextAreaContent();

        //Radio button and checkbox
        webFormPage.verifyRadioButtonStatus();
        webFormPage.checkDefaultCheckBoxStatus();
        webFormPage.verifyDisabledElement();
        webFormPage.verifyReadOnlyElement();

        //Dropdown elements
        webFormPage.selectDropDownValue(dataTableData.get("dropDownValue"));
        webFormPage.selectDropdownListValue(dataTableData.get("dataListValue"));

        //Uncomment this line if file upload needs to be used
        //        webFormPage.uploadFile();

        //Color, Date and Range Value pickers
        webFormPage.selectColorPicker(dataTableData.get("colorPicker"));
        webFormPage.selectDateFromDatePicker(dataTableData.get("datePicker"));
        webFormPage.selectRange(dataTableData.get("rangeValue"));

    }

    //User clicks on the submit button on the web form
    @When("the user clicks on the Submit button")
    public void theUserClicksOnTheSubmitButton() {
        webFormPage.clickSubmitButton();
    }

}
