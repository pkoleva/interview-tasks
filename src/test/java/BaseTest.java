import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.pkoleva.ui.BasketPage;
import org.pkoleva.ui.ItemPage;
import org.pkoleva.ui.SearchPage;

import java.time.Duration;

public class BaseTest {
    public String basePageUrl = "https://www.amazon.co.uk/";

    public static WebDriver driver;
    public static WebDriverWait wait;

    public SearchPage searchPage;
    public ItemPage itemPage;
    public BasketPage basketPage;

    @BeforeEach
    public void beforeTests(){
        // Initialize driver and wait.
        driver = startBrowser();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Initialize pages.
        searchPage = new SearchPage(driver, wait);
        itemPage = new ItemPage(driver, wait);
        basketPage = new BasketPage(driver,wait);


        // Navigate to baseUrl.
        driver.get(basePageUrl);
        Assertions.assertEquals(basePageUrl, driver.getCurrentUrl());
        Assertions.assertTrue(searchPage.verifyLogo());
        acceptCookies();
    }

    @AfterEach
    public void afterTest(){
        // Close driver.
        driver.close();
        driver.quit();
    }

    protected static WebDriver startBrowser() {
        // Setup Chrome.
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        return driver;
    }

    protected static void acceptCookies(){
        var acceptCookies = driver.findElement(By.id("sp-cc-accept"));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        acceptCookies.click();

    }
}
