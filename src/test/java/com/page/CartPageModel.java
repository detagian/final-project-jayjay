package com.page;

import com.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class CartPageModel extends BaseModel {


    By loc_tblRowProducts = By.xpath("//table/tbody/tr");
    By loc_txtTotalPrice = By.xpath("//*[@id=\"totalp\"]");
    By loc_btnPlaceOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    By loc_btnPurchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");

    By loc_frmNamePlaceOrder = By.xpath("//*[@id=\"name\"]");
    By loc_frmCreditCardPlaceOrder = By.xpath("//*[@id=\"card\"]");

    By loc_txaSuccessInformationPopUp = By.xpath("/html/body/div[10]/p");

    By loc_btnOkPopUp = By.xpath("/html/body/div[10]/div[7]/div/button");

    public  CartPageModel(WebDriver driver){
        BaseModel.driver =driver;
    }

    //CLICK
    public void clickDeleteButton(int itemIndex) throws InterruptedException {
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr["+itemIndex+"]/td[4]/a")));
        driver.findElement(By.xpath("//table/tbody/tr["+itemIndex+"]/td[4]/a")).click();
        Thread.sleep(2000);
    }

    public void clickPlaceOrderButton(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc_btnPlaceOrder));
        driver.findElement(loc_btnPlaceOrder).click();
    }

    public void clickPurchaseButton(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc_btnPurchase));
        driver.findElement(loc_btnPurchase).click();
    }

    public void clickOkButton() throws InterruptedException {
        driver.findElement(loc_btnOkPopUp).click();
        Thread.sleep(2000);
    }

    // SET Text /Input

    public void inputNameFormPlaceOrder(String name){
        driver.findElement(loc_frmNamePlaceOrder).sendKeys(name);
    }

    public void inputCreditCardFormPlaceOrder(String cc){
        driver.findElement(loc_frmCreditCardPlaceOrder).sendKeys(cc);
    }

    //function
    public boolean isCartEmpty() {
        return countRowtableProduct() <= 0;
    }

    public int countRowtableProduct() {
        List<WebElement> rows = driver.findElements(loc_tblRowProducts);
        return rows.size();
    }

    public String getWordAfter(String word, String txtInput){
        Pattern pattern = Pattern.compile("[\\n\\r].*"+word+"\\s*([^\\n\\r]*)");
        Matcher matcher = pattern.matcher(txtInput);
        if (matcher.find()) {
            return matcher.group(1);
        }else{
            return "";
        }
    }
    //VALIDATE
    public void validateCartIsNotEmpty() {
        assertTrue(countRowtableProduct()>0);
    }
    public void validateTotalPriceIsMatch(int currentItemTotal) throws InterruptedException {
        int totalPriceInTableProduct=0;
        Thread.sleep(5000);
        for (int i = 1; i <= currentItemTotal; i++) {
            totalPriceInTableProduct = totalPriceInTableProduct +Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr["+i+"]/td[3]")).getText());
        }
        assertEquals(totalPriceInTableProduct,Integer.parseInt(driver.findElement(loc_txtTotalPrice).getText()));
    }

    public void validateItemIsDeleted(int itemCountBefore, int itemCountAfter){
        assertNotEquals(itemCountBefore,itemCountAfter);
    }

    public void validateNamePlaceOrderIsCorrect(String name){
        String text = driver.findElement(loc_txaSuccessInformationPopUp).getText();
        String getName = getWordAfter("Name: ",text);
        assertEquals(getName,name);
    }

    public void validateCreditCardPlaceOrderIsCorrect(String cc){
        String text = driver.findElement(loc_txaSuccessInformationPopUp).getText();
        String getCC = getWordAfter("Card Number: ",text);
        assertEquals(getCC,cc);
    }




}
