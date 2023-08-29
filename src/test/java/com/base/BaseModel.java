package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseModel {

    protected static WebDriver driver;
    protected ValidatableResponse Response;

    protected static WebDriverWait explicitWait;

    protected String valueFirstName,valueLastName,valueEmail,valueUrl, valueUserId,valueTextPost,valueMsgcomment,valueCommentId;
    protected int valueTotalItemBeforeDeleted;


    protected static void getDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setBrowserVersion("114");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));



    }

}
