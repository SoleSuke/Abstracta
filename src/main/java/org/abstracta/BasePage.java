package org.abstracta;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class BasePage {
    protected static WebDriver driver = null;

    public BasePage(WebDriver driver)
    {
        synchronized (this) {
            if (BasePage.driver == null)
                BasePage.driver = driver;
        }
    }
}