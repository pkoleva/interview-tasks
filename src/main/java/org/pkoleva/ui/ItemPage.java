package org.pkoleva.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class ItemPage extends BasePage{

    public ItemPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait);
    }

    private By paperback = By.xpath("//div[@id='tmm-grid-swatch-PAPERBACK']//span[text()='Paperback']");
    private By title = By.id("title");
    private By price = By.xpath("//div[@id='tmm-grid-swatch-PAPERBACK']//span[@class='slot-price']");
    private By addtoBasket = By.id("submit.add-to-cart");
    private By addedToBasketHeader = By.xpath("//h1[contains(text(),'Added to Basket')]");
    private By gift = By.id("gift-wrap");


    public Map<String,String> getItemProperties(){
        HashMap<String, String> itemProperties = new HashMap<>();
        itemProperties.put("title",driver.findElement(title).getText());
        itemProperties.put("price",driver.findElement(price).getText().trim().replace("\n", "").replace("\r", ""));
        itemProperties.put("paperback",driver.findElement(paperback).getText());
        return itemProperties;
    }

    public void addToBasket(){
        driver.findElement(paperback).click();
        driver.findElement(gift).click();
        driver.findElement(addtoBasket).click();
        var addedToBasket = driver.findElement(addedToBasketHeader);
        wait.until(ExpectedConditions.visibilityOf(addedToBasket));
    }
}
