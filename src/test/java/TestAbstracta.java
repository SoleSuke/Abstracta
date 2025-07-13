import org.abstracta.PageSearch;
import org.abstracta.PrincipalPage;
import org.abstracta.ShoppingCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        System.out.println("Cargue la pag Ppal");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Esperé 5 segundos");
        PageSearch pSearch = new PageSearch(driver);
        System.out.println("Cargué la pag Search");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ShoppingCart sCart = new ShoppingCart(driver);
        System.out.println("Cargué la pagina del carrito");
        String url = "http://opencart.abstracta.us";
        pPage.goToUrl(url);
        System.out.println("Go to the Url");
        result = pPage.searchProduct("Iphone");
        if (result == 1) {
            System.out.println("Search for Iphone put in the search bar");
        } else {
            System.out.println("Search for Iphone fails in the search bar");
        }
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.firstElSearch();
        if (result == 1) {
            System.out.println("Find Iphone");
        } else {
            System.out.println("Search for Iphone fails in the find");
        }
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.addElToCart();
        if (result == 1) {
            System.out.println("Iphone added to the shopping cart");
        } else {
            System.out.println("Can't Add Iphone to the Shopping Cart");
        }
        result = 0; // Return value to 0 for next Step of Testing
        result = pSearch.goToCheckTheCart();
        if (result == 1) {
            System.out.println("Go to the shopping cart");
        } else {
            System.out.println("Can't Go to the Shopping Cart");
        }
        result = 0; // Return value to 0 for next Step of Testing
        result = sCart.ReviewCart();
        if (result == 1) {
            System.out.println("Iphone is in the Shopping Cart");
        } else {
            System.out.println("Iphone is not in the Shopping Cart");
        }
        result = 0; // Return value to 0 for next Step of Testing
        result = sCart.RemoveItemFromCart();
        if (result == 1) {
            System.out.println("Iphone removed from the Shopping Cart");
        } else {
            System.out.println("Iphone was not removed from the Shopping Cart");
        }
        System.out.println("Testing Successfully");
        driver.close();
    }

}