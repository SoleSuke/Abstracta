package org.abstracta;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Principal page
public class PrincipalPage extends BasePage {
    protected JavascriptExecutor js;
    protected String url;
    String myxpath;
    public PrincipalPage(WebDriver driver)
    {
        super(driver);
    }

    public void goToUrl(String url) {
        driver = (WebDriver) new FirefoxDriver();
        driver.navigate().to(url);
        js = (JavascriptExecutor) driver;
    }

    //XPath of bar search

    public int searchProduct(String product)
    {
        try {
            myxpath = "/html/body/header/div/div/div[2]/div/input";
            System.out.println("My url is :" + driver.getCurrentUrl());
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