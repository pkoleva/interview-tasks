package org.pkoleva.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage extends BasePage{

    public SearchPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait);
    }


    //locators
    private  By searchbox = By.id("twotabsearchtextbox");
    private  By resultsHeader =By.xpath("//h2[text()='Results']");
    private  By results = By.xpath("//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]");
    private By paperback = By.xpath("//a[text()='Paperback']");
    private By price = By.xpath("//span[@class='a-price']/span");
    private By logo = By.id("nav-logo-sprites");


    //methods
    public boolean verifyLogo(){
        var logoImage = driver.findElement(logo);
        wait.until(ExpectedConditions.elementToBeClickable(logoImage));
        return logoImage.isDisplayed();
    }

    public void searchByCriteria(String criteria){
        var textBox = driver.findElement(searchbox);
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        textBox.sendKeys(criteria);
        textBox.sendKeys(Keys.ENTER);
        var resultstiutle = driver.findElement(resultsHeader);
        wait.until(ExpectedConditions.elementToBeClickable(resultstiutle));
    }

    public List<WebElement> getSearchResultSet(){
        var resultstiutle = driver.findElement(resultsHeader);
        wait.until(ExpectedConditions.elementToBeClickable(resultstiutle));
        return driver.findElements(results);
    }

    public void selecPaperbacktItem(WebElement item){
        item.findElement(paperback).click();
    }

    public String getPrice(WebElement element){
        return element.findElement(price).getAttribute("innerHTML").trim().replace("\n", "").replace("\r", "");
    }

}
