package org.pkoleva.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait);
    }

    private By basketButton = By.id("nav-cart");
    private By basketItem = By.className("sc-list-item-content");
    private By gift = By.xpath("//div[contains(@class,'sc-gift-option')]//input");


    public void navigateToBasket(){
        driver.findElement(basketButton).click();
    }

    public List<WebElement> getItems() {
        return driver.findElements(basketItem);
    }

    public String getItemDetails(WebElement element) {
        return element.getAttribute("innerHTML");
    }

    public boolean isGiftSelected(WebElement element){
        return element.findElement(gift).isSelected();
    }
}
