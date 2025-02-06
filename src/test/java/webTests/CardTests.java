package webTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.LoginPage;
import pages.ProductsPage;
import util.DriverFactory;

import java.util.HashMap;
import java.util.Map;

public class CardTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CardPage cardPage;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cardPage = new CardPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();
        productsPage.addJacketToCart();

    }

    @Test
    public void validateItemCard(){
        cardPage.clickCard();

        Map<String, Double> productPrices = new HashMap<>();
        Map<String, Integer> productCounts = cardPage.getProductsCountAndPrices(productPrices);

        Assert.assertEquals(productCounts.get("Sauce Labs Backpack"), Integer.valueOf(1));
        Assert.assertEquals(productCounts.get("Sauce Labs Fleece Jacket"), Integer.valueOf(1));

        Assert.assertEquals(productPrices.get("Sauce Labs Backpack"), Double.valueOf(29.99), "O preço da mochila está incorreto!");
        Assert.assertEquals(productPrices.get("Sauce Labs Fleece Jacket"), Double.valueOf(49.99), "O preço da jaqueta está incorreto!");

        Assert.assertEquals(productCounts.size(), 2);
    }

    @AfterMethod
    public void tearDown(){

        DriverFactory.quitDriver();
    }

}
