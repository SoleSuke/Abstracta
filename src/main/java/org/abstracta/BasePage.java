package org.abstracta;

import org.openqa.selenium.WebDriver;


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