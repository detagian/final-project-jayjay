package com.page;

import com.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavbarPageModel extends BaseModel {

    By loc_btnLoginNavbar = By.xpath("//a[@id='login2']");
    By loc_frmLoginUsername = By.xpath("//*[@id=\"loginusername\"]");
    By loc_frmLoginPassword = By.xpath("//*[@id=\"loginpassword\"]");
//*[@id="logInModal"]/div/div/div[3]/button[2]
    By loc_btnLoginForm = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");

    By loc_txtProfileName = By.xpath("//*[@id=\"nameofuser\"]");
    By loc_btnLogoutNavbar = By.xpath("//*[@id=\"logout2\"]");

    By loc_btnSignUpNavbar = By.xpath("//*[@id=\"signin2\"]");
    By loc_btnSignUpForm =By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    By loc_frmSignUpUsername = By.xpath("//*[@id=\"sign-username\"]");
    By loc_frmSignUpPassword = By.xpath("//*[@id=\"sign-password\"]");
    By loc_btnCartNavbar = By.xpath("//*[@id=\"cartur\"]");

    public NavbarPageModel(WebDriver driver){

        BaseModel.driver =driver;
    }


    //Set or input
    public void setFormLoginUsername(String username){
        driver.findElement(loc_frmLoginUsername).sendKeys(username);

    }

    public void setFormLoginPassword(String password){
        driver.findElement(loc_frmLoginPassword).sendKeys(password);
    }

    public void setFormSignUpUsername(String username){
        driver.findElement(loc_frmSignUpUsername).sendKeys(username);

    }
    public void setFormSignUpPassword(String password){
        driver.findElement(loc_frmSignUpPassword).sendKeys(password);

    }


    // Click
    public void clickLoginModal(){
        driver.findElement(loc_btnLoginNavbar).click();
    }


    public void clickLoginAction(){
        driver.findElement(loc_btnLoginForm).click();
    }

    public void clickLogout(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(loc_btnLogoutNavbar));
        driver.findElement(loc_btnLogoutNavbar).click();
    }

    public void clickSignUpModal(){
        driver.findElement(loc_btnSignUpNavbar).click();
    }

    public void clickSignUpAction(){
        driver.findElement(loc_btnSignUpForm).click();
    }

    public void clickCartButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loc_btnCartNavbar).click();
    }

    // VALIDATE ACTION
    public void validateUsernameAppear(String username){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(loc_txtProfileName));
        assertEquals(driver.findElement(loc_txtProfileName).getText(), username);
    }


    public boolean isButtonNavbarLoginVisible(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(loc_btnLoginNavbar));
        return driver.findElement(loc_btnLoginNavbar).isDisplayed();
    }

    public boolean isProfileNameVisible() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(loc_txtProfileName).isDisplayed();
    }





}
