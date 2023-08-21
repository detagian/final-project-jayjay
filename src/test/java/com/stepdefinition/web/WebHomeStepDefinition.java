package com.stepdefinition.web;

import com.base.BaseModel;
import com.page.DefaultBrowserPageModel;
import com.page.HomePageModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class WebHomeStepDefinition extends BaseModel {

    protected HomePageModel homePageModel = new HomePageModel(driver);
    protected DefaultBrowserPageModel defaultBrowserPageModel = new DefaultBrowserPageModel(driver);
    ArrayList<String> getItemCardInfo;

    @Given("user is on home page")
    public void userIsOnHomePage() {
        defaultBrowserPageModel.goToBaseUrl();
    }

    @When("browser is fully loaded")
    public void browserIsFullyLoaded() {
    }

    @Then("user see maximum {int} items per page")
    public void userSeeMaximumItemsPerPage(int maxItemsShow) {
        homePageModel.validateTotalItemsShow(maxItemsShow);
    }

    @And("user see item name")
    public void userSeeItemName() {
        homePageModel.validateAllItemsNameShow();
    }

    @And("user see item price")
    public void userSeeItemPrice() {
        homePageModel.validateAllItemsPriceShow();
    }

    @And("user see item descriptions")
    public void userSeeItemDescriptions() {
        homePageModel.validateAllItemsDescriptionShow();
    }

    @And("user see item image")
    public void userSeeItemImage() {
        homePageModel.validateAllItemsImageShow();
    }

    @And("user focus on item {int}")
    public void userFocusOnItem(int itemIndex) {
        getItemCardInfo = homePageModel.getItemCardInfo(itemIndex);
    }

    @When("user click item {int}")
    public void userClickItem(int itemIndex) {
        homePageModel.clickItemCard(itemIndex);
    }

    @Then("user on item {int} details page")
    public void userOnItemDetailsPage(int arg0) {
    }

    @And("user see item name from details page")
    public void userSeeItemNameFromDetailsPage() {
        homePageModel.validateDetailsItemNameIsShowAndMatch(getItemCardInfo.get(0));
    }

    @And("user see item price from details page")
    public void userSeeItemPriceFromDetailsPage() {
        homePageModel.validateDetailsItemPriceIsShowAndMatch(getItemCardInfo.get(1));
    }

    @And("user see item descriptions from details page")
    public void userSeeItemDescriptionsFromDetailsPage() {
        homePageModel.validateDetailsItemDescriptionIsShowAndMatch(getItemCardInfo.get(2));
    }

    @And("user see Add to Cart button")
    public void userSeeAddToCartButton() {
        homePageModel.validateAddToCartIsVisible();
    }

    @When("user click button Add To Cart")
    public void userClickButtonAddToCart() {
        homePageModel.clickAddToCart();
    }
}
