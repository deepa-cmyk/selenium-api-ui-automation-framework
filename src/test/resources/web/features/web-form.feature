@uiTest
Feature: WebForm Element Validation and form submission

  Scenario: User fills out and submits the form with valid data
    Given user is on the webform
    And user enters the form data
    |text     | password    | dropDownValue | DataListValue | ColorPicker | DatePicker | RangeValue |
    | JohnDoe | password123 | One           | New York      | #ff5733     | 2023-04-01 | 5          |
    When the user clicks on the Submit button
    Then the web form is submitted
