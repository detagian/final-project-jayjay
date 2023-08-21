package com.page;

import com.base.BaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultBrowserPageModel extends BaseModel {

    public DefaultBrowserPageModel(WebDriver driver){
        BaseModel.driver =driver;
    }

    public void goToBaseUrl(){
        driver.get("https://www.demoblaze.com/");
    }
    public void validateAlertText(String alertText){
        explicitWait.until(ExpectedConditions.alertIsPresent());
        assertEquals(driver.switchTo().alert().getText(),alertText);
        driver.switchTo().alert().accept();
    }
    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
}
