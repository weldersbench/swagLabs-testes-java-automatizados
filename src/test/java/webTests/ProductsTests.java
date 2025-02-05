package webTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import util.DriverFactory;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class ProductsTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testeAddProdutoCarrinho(){

        productsPage.addBackpackToCart();

        Assert.assertEquals(productsPage.getTextButton(), "Remove");

    }


    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
