package org.abstracta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart extends BasePage {
    String myxpath;
    public ShoppingCart(WebDriver driver)
    {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> d.findElement(By.className("header_container")));
    }


    public int ReviewCart() {
        try {
            myxpath = "/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]/strong/i";
            driver.findElement(By.xpath(myxpath)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Click in View Cart");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            var shopCart = driver.findElement(By.xpath(myxpath)).getSize();
            System.out.println("En mi carrito de compras tengo" + shopCart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int RemoveItemFromCart()
    {
        System.out.println("Voy a remover el Iphone from the cart");
        try {
            myxpath = "/html/body/div[2]/div[2]/div/form/div/table/tbody/tr/td[4]/div/span/button[2]/i";
            driver.findElement(By.xpath(myxpath)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //myxpath = "//*[@id=\"cart-total\"]";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        var shopCart = driver.findElement(By.xpath(myxpath)).getSize();
        System.out.println("In my cart now there are " + shopCart );
        return 1;
    }

}
