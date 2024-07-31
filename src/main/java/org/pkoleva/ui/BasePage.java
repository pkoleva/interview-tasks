package org.pkoleva.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver, WebDriverWait driverWait) {
        driver = webDriver;
        wait = driverWait;
    }


}
