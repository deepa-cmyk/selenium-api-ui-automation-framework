package com.test.web.hooks;

import com.test.web.constants.TestDataConstatnts;
import com.test.web.utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.test.web.constants.TestDataConstatnts.CHROME;
import static com.test.web.constants.TestDataConstatnts.FIREFOX;

public class CucumberHooks extends BaseTest {

    String browser = System.getProperty("browser", FIREFOX);

    @Before
    public void beforeTest() {
        getDriver(browser);
    }

    @After
    public void afterTest() {
        teardown();
    }
}
