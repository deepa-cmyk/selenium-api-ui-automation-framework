@uiTest
Feature: WebForm Element Validation and form submission

  Scenario: User fills out and submits the form with valid data
    Given user is on the webform
    And user enters the form data
      |text     | password    | dropDownValue | DataListValue | ColorPicker | DatePicker | RangeValue |
      | JohnDoe | password123 | One           | New York      | #ff5733     | 04/20/2025 | 8          |
    When the user clicks on the Submit button
    Then the web form is submitted
