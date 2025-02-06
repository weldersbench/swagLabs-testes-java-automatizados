package webTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import util.DriverFactory;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage products;

    @BeforeMethod
    public void setUp(){

        driver = DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testeLoginComSucesso(){
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testeLoginInvalido(){
        loginPage.login("giovana", "654321");

        String errorMessage = loginPage.getErroMessage();

        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user"));
    }

    @AfterMethod
    public void tearDown(){

        DriverFactory.quitDriver();
    }
}
