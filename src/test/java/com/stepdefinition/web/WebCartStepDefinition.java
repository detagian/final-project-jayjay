package com.stepdefinition.web;

import com.base.BaseModel;
import com.page.CartPageModel;
import com.page.DefaultBrowserPageModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebCartStepDefinition extends BaseModel {
    protected CartPageModel cartPageModel = new CartPageModel(driver);

    @When("user click delete button on item {int}")
    public void userClickDeleteButtonOnItem(int itemIndex) throws InterruptedException {
        cartPageModel.clickDeleteButton(itemIndex);
    }

    @Then("user see item {int} is deleted")
    public void userSeeItemIsDeleted(int arg0) throws InterruptedException {
        cartPageModel.validateItemIsDeleted(valueTotalItemBeforeDeleted,cartPageModel.countRowtableProduct());
        if(!cartPageModel.isCartEmpty()){
            cartPageModel.validateTotalPriceIsMatch(cartPageModel.countRowtableProduct());
        }
    }

    @And("user see at least 1 item in table products")
    public void userSeeItemSInTableProducts() throws InterruptedException {
        cartPageModel.validateCartIsNotEmpty();
        valueTotalItemBeforeDeleted = cartPageModel.countRowtableProduct();
        cartPageModel.validateTotalPriceIsMatch(cartPageModel.countRowtableProduct());

    }

    @When("user click place order button")
    public void userClickPlaceOrderButton() {
        cartPageModel.clickPlaceOrderButton();
    }

    @And("user click purchase button")
    public void userClickPurchase() {
        cartPageModel.clickPurchaseButton();
    }

    @And("user input name {string} in place order form")
    public void userInputNameInPlaceOrderForm(String name) {
        cartPageModel.inputNameFormPlaceOrder(name);
    }

    @And("user input card number {string} in place order form")
    public void userInputCardNumberInPlaceOrderForm(String cc) {
        cartPageModel.inputCreditCardFormPlaceOrder(cc);
    }

    @Then("user see successful pop-up")
    public void userSeeSuccessfulPopUp() {

    }

    @And("user see name {string} is correct in pop-up")
    public void userSeeNameIsCorrecctInPopUp(String name) {
        cartPageModel.validateNamePlaceOrderIsCorrect(name);
    }

    @And("user see card number {string} is correct in pop-up")
    public void userSeeCardNumberIsCorrecctInPopUp(String cc) {
        cartPageModel.validateCreditCardPlaceOrderIsCorrect(cc);
    }

    @And("user click ok button")
    public void userClickOkButton() throws InterruptedException {
        cartPageModel.clickOkButton();
    }
}
