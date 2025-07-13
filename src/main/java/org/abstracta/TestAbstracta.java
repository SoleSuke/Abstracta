package org.abstracta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestAbstracta implements AutoCloseable {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected String url;

    @Test
    public void testIphone() throws InterruptedException {
        String myxpath = "/html/body/header/div/div/div[2]/div/input";
        try {
            driver.findElement(By.xpath(myxpath)).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            driver.findElement(By.xpath(myxpath)).sendKeys("Iphone");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        myxpath = "/html/body/header/div/div/div[2]/div/span/button";
        try {
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Buscando Iphone");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //myxpath = "/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[1]/h4";
        myxpath = "/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img";
        try {
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Elijo el primer resultado y clickeo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        myxpath = "//*[@id=\"button-cart\"]";
        try {
            driver.findElement(By.xpath(myxpath)).click();
            System.out.println("Click de agregar al carro");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //myxpath = "/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong"; // Lanza excepcion
        myxpath = "/html/body/header/div/div/div[3]/div/button";
        WebElement element = driver.findElement(By.xpath(myxpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement activeElement = driver.findElement(By.xpath(myxpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", activeElement);
        String mycssSel = "p.text-right > a:nth-child(1) > strong:nth-child(1)"; // Lanza excepcion
        try {
            driver.findElement(By.xpath(myxpath)).click();
            //driver.findElement(By.cssSelector(mycssSel)).click();
            System.out.println("Ingreso a ViewCart");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //myxpath = "/html/body/div[2]/div[2]/div/form/div/table/tbody/tr/td[6]";
        myxpath = "/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong/i";
        try {
            driver.findElement(By.xpath(myxpath)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Click in View Cart");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String shopCart = driver.findElement(By.xpath(myxpath)).getAttribute("value");
            System.out.println("En mi carrito de compras tengo" + shopCart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //myxpath = "/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody/tr/td[5]/button/i";
        System.out.println("Voy a remover el Iphone from the cart");
        myxpath = "/html/body/div[2]/div[2]/div/form/div/table/tbody/tr/td[4]/div/span/button[2]/i";
        driver.findElement(By.xpath(myxpath)).click();
        //myxpath = "//*[@id=\"cart-total\"]";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        var shopCart = driver.findElement(By.xpath(myxpath)).getAttribute("value");
        System.out.println("In my cart now there are " + shopCart );

    }

    @Override
    public void close() throws Exception
    {
        //driver.close();
        driver.quit();
    }

    @BeforeEach
    public void init()
    {
        driver = (WebDriver) new FirefoxDriver();
        url = "http://opencart.abstracta.us";
        driver.navigate().to(url);
        js = (JavascriptExecutor) driver;
    }


}
