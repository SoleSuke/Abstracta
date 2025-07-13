package org.abstracta;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Principal page
public class PrincipalPage extends BasePage {
    protected JavascriptExecutor js;
    protected String url;
    String myxpath;
    public PrincipalPage(WebDriver driver)
    {
        super(driver);
        driver = (WebDriver) new FirefoxDriver();
        url = "http://opencart.abstracta.us";
        driver.navigate().to(url);
        js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> d.findElement(By.className("header_container")));

    }
    // XPath of bar search

    public int searchProduct(String product)
    {
        try {
            myxpath = "/html/body/header/div/div/div[2]/div/input";
            driver.findElement(By.xpath(myxpath)).sendKeys(product);
            System.out.println("Search for product");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // XPatch search engine button

        try {
            myxpath = "/html/body/header/div/div/div[2]/div/span/button";
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Click on search");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}