package org.abstracta;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PageSearch extends BasePage {
    String myxpath;
    public PageSearch(WebDriver driver)
    {
        super(driver);
    }
    public int firstElSearch()
    {
        // XPath of First Element find
        try {
            System.out.println("My url ahora es :" + driver.getCurrentUrl());
            myxpath = "/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img";
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Elijo el primer resultado y clickeo");
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int addElToCart() {
        myxpath = "//*[@id=\"button-cart\"]";
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Click de agregar al carro");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int goToCheckTheCart()
    {
        myxpath = "/html/body/header/div/div/div[3]/div/button";
        WebElement element = driver.findElement(By.xpath(myxpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement activeElement = driver.findElement(By.xpath(myxpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", activeElement);
        try {
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Ingreso a ViewCart");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

}