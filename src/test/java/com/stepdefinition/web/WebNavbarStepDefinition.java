package com.stepdefinition.web;

import com.base.BaseModel;
import com.page.DefaultBrowserPageModel;
import com.page.NavbarPageModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebNavbarStepDefinition extends BaseModel {

    NavbarPageModel navbarPageModel = new NavbarPageModel(driver);
    protected DefaultBrowserPageModel defaultBrowserPageModel = new DefaultBrowserPageModel(driver);


    @And("user click login button from navbar")
    public void userClickLoginButtonFromNavbar() {
        navbarPageModel.clickLoginModal();
    }

    @And("user input login username {string}")
    public void userInputUsername(String username) {
        navbarPageModel.setFormLoginUsername(username);
    }

    @And("user input login password {string}")
    public void userInputPassword(String password) {
        navbarPageModel.setFormLoginPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        navbarPageModel.clickLoginAction();

    }

    @Then("user see profile name {string}")
    public void userSeeProfileName(String profileName) {
        navbarPageModel.validateUsernameAppear(profileName);
    }

    @Then("user see alert text {string}")
    public void userSeeAlertText(String alertText) {
        defaultBrowserPageModel.validateAlertText(alertText);
    }

    @When("user click logout button")
    public void userClickLogoutButton() {
        navbarPageModel.clickLogout();
    }

    @And("user see login button from navbar is visible")
    public void userSeeLoginButtonFromNavbarIsVisible() {
        assertTrue(navbarPageModel.isButtonNavbarLoginVisible());
    }

    @Then("user don't see profile name")
    public void userDonTSeeProfileName() {
        assertFalse(navbarPageModel.isProfileNameVisible());
    }

    @And("user click singup button from navbar")
    public void userClickSingupButtonFromNavbar() {
        navbarPageModel.clickSignUpModal();
    }

    @When("user click signup button")
    public void userClickSignupButton() {
        navbarPageModel.clickSignUpAction();
    }

    @And("user input signup username {string}")
    public void userInputSignupUsername(String username) {
        navbarPageModel.setFormSignUpUsername(username);
    }

    @And("user input signup password {string}")
    public void userInputSignupPassword(String password) {
        navbarPageModel.setFormSignUpPassword(password);
    }

    @And("user input signup unique username {string}")
    public void userInputSignupUniqueUsername(String username) {
        UUID randomStr = UUID.randomUUID();
        String save = randomStr.toString().substring(0,5);
        navbarPageModel.setFormSignUpUsername(username.concat(save));
    }

    @And("user click cart button from navbar")
    public void userClickCartButtonFromNavbar() throws InterruptedException {
        navbarPageModel.clickCartButton();
    }
}
