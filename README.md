
## **selenium-api-ui-automation-framework-**

This project is a **test automation framework** that leverages **Selenium**, **Java**, **Maven**, **Rest-Assured** and **Cucumber** to test both UI and API functionalities. It provides a robust foundation for running automated tests. 

It includes cucumber feature tests for the following 
- A web form at (https://www.selenium.dev/selenium/web/web-form.html)
- API tests using a free public Star Wars API available on https://www.freepublicapis.com/star-wars-api  

The framework uses **BDD (Behavior-Driven Development)** for both UI and API tests, enabling easy-to-read test cases written in **Cucumber**.

The test scenarios are described in **Cucumber feature files** that can be found here:
- UI Tests: `src/test/resources/web/features/web-form.feature`
- API Tests: `src/test/resources/api/features/get-people-api.feature`

### **Getting Started**

### Prerequisites
To get started with this framework, you need to have the following installed on your local machine:

- **Java 11** or above
- **Maven**


### Setup Instructions

1. **Clone the Project**
   ```bash
   git clone <repository-url>
Open the Project Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

Install Dependencies Run the following command to install all required dependencies:
mvn clean install

Run Tests Once the setup is complete, you can start the tests using the provided run configuration.
## **Running the tests**

Test suite will use the specified browser and use the following url - https://www.selenium.dev/selenium/web/web-form.html

By default to run all features/scenarios

If you want to run test individual tests then use the below commands

## Command-line commands
You can execute the tests using the following Maven commands with pre-configured tags and profiles:

- **Run API Tests**: Executes tests for API-related functionality defined in the `api-tests` profile
  - mvn clean test -Papi-tests
- **Run UI Tests**: Executes tests for UI-related functionality defined in the `ui-tests` profile
  - mvn clean test -Pui-tests
- **Run Specific Tests**: Uses the `-Dcucumber.filter.tags` to filter and run tests with specific tags for more granular control.
  - mvn clean test -Dcucumber.filter.tags="@apiTest and @get-negative"
  - mvn clean test -Dcucumber.filter.tags="@apiTest and @get-positive"
  - mvn clean test -Dcucumber.filter.tags="@uiTest"

## Test Reports
Once the tests have been executed, you can find the generated reports under the following directory:

\target
The reports include detailed test execution results and can be accessed in the following formats:

- Cucumber Reports: Test results for the Cucumber scenarios.
- Surefire Reports: Standard Maven test reports.

## Documentation

UI used for testing - https://selenium.dev/

Free pubic API used for testing - https://swapi.dev/api/people

JAVA - https://docs.oracle.com/en/java/

Cucumber - https://cucumber.io/docs

MAVEN - https://maven.apache.org/

REST ASSURED - https://rest-assured.io/

