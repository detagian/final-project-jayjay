package com.page;

import com.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageModel extends BaseModel {
    By loc_cardItems = By.xpath("//*[@class=\"card h-100\"]");

    By loc_txtItemNameFromDetails=By.xpath("//*[@id=\"tbodyid\"]/h2");
    By loc_txtItemPriceFromDetails=By.xpath("//*[@id=\"tbodyid\"]/h3");
    By loc_txtItemDescriptionFromDetails=By.xpath("//*[@id=\"more-information\"]/p");

    By loc_btnAddToCartFromDetails = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    public HomePageModel(WebDriver driver){
        BaseModel.driver = driver;
    }

    // Navigate


    // Function
    public ArrayList<String> getItemCardInfo(int itemIndex){
        ArrayList<String> save = new ArrayList<>();
        save.add(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+itemIndex+"]/div/div/h4/a")).getText());
        save.add(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+itemIndex+"]/div/div/h5")).getText());
        save.add(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+itemIndex+"]/div/div/p")).getText());
        return save;
    }

    //Click

    public void clickItemCard(int itemIndex){
            driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div["+itemIndex+"]/div/div/h4/a")).click();
    }

    public void clickAddToCart(){
        driver.findElement(loc_btnAddToCartFromDetails).click();
    }

    //VALIDATE
    public void validateTotalItemsShow(int itemShows){

        assertEquals(driver.findElements(loc_cardItems).size(),itemShows);
    }

    public void validateAllItemsNameShow(){
        for (int i = 1; i <= driver.findElements(loc_cardItems).size(); i++) {
            By loc_txtItemsName = By.xpath("//*[@id=\"tbodyid\"]/div["+i+"]/div/div/h4/a");
            assertTrue(driver.findElement(loc_txtItemsName).isDisplayed());
        }
    }

    public void validateAllItemsPriceShow(){
        for (int i = 1; i <= driver.findElements(loc_cardItems).size(); i++) {
            By loc_txtItemsPrice = By.xpath("//*[@id=\"tbodyid\"]/div["+i+"]/div/div/h5");
            assertTrue(driver.findElement(loc_txtItemsPrice).isDisplayed());
        }
    }

    public void validateAllItemsDescriptionShow(){
        for (int i = 1; i <= driver.findElements(loc_cardItems).size(); i++) {
            By loc_txtItemsDescription = By.xpath("//*[@id=\"tbodyid\"]/div["+i+"]/div/div/p");
            assertTrue(driver.findElement(loc_txtItemsDescription).isDisplayed());
        }
    }

    public void validateAllItemsImageShow(){
        for (int i = 1; i <= driver.findElements(loc_cardItems).size(); i++) {
            By loc_imgItem = By.xpath("//*[@id=\"tbodyid\"]/div["+i+"]/div/a");
            assertTrue(driver.findElement(loc_imgItem).isDisplayed());
        }
    }

    public void validateDetailsItemNameIsShowAndMatch(String itemNameFromHome){
        String name = driver.findElement(loc_txtItemNameFromDetails).getText().replace(" *includes tax","");
        assertEquals(itemNameFromHome,name);
    }

    public void validateDetailsItemPriceIsShowAndMatch(String itemPriceFromHome){
        String price = driver.findElement(loc_txtItemPriceFromDetails).getText().replace(" *includes tax","");
        assertEquals(itemPriceFromHome,price);
    }

    public void validateDetailsItemDescriptionIsShowAndMatch(String itemDescriptionFromHome){
        String description = driver.findElement(loc_txtItemDescriptionFromDetails).getText().replace(" *includes tax","");
        assertEquals(itemDescriptionFromHome,description);
    }
    public void validateAddToCartIsVisible(){
        driver.findElement(loc_btnAddToCartFromDetails).isDisplayed();
    }

}
