import org.abstracta.PageSearch;
import org.abstracta.PrincipalPage;
import org.abstracta.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestAbstracta {
    protected JavascriptExecutor js;
    protected String url;
    protected WebDriver driver;
    public int result=0;

    @Test
    public void MyTest() {
        driver = (WebDriver) new FirefoxDriver();
        PrincipalPage pPage = new PrincipalPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageSearch pSearch = new PageSearch(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ShoppingCart sCart = new ShoppingCart(driver);
        String url = "http://opencart.abstracta.us";
        pPage.goToUrl(url);
        System.out.println("Go to the Url");
        result = pPage.searchProduct("Iphone");
        Assertions.assertEquals(1,result, "Iphone word put in the search bar");
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.firstElSearch();
        Assertions.assertEquals(1,result, "Find Iphone");
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.addElToCart();
        Assertions.assertEquals(1,result, "Iphone added to the shopping cart");
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.goToCheckTheCart();
        Assertions.assertEquals(1,result, "Go to the shopping cart");
        result = 0; // Return value to 0 for next Step of Testing
        result = sCart.ReviewCart();
        Assertions.assertEquals(1,result, "Iphone is in the shopping Cart");
        result = 0; // Return value to 0 for next Step of Testing
        try
        {
            result = sCart.RemoveItemFromCart();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(1,result, "Iphone removed from the shopping cart");
        System.out.println("Testing Successfully");
        driver.quit();
    }

}