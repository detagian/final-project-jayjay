package com.stepdefinition.web.hooks;

import com.base.BaseModel;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class WebHooks extends BaseModel {

    @Before(value="@web")
    public static void beforeTest() {

        getDriver();

    }
    @After(value="@web")
    public static void afterTest() {
        driver.close();
    }
}
