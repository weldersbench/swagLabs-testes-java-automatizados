package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/109/chromedriver.exe");
        driver = new ChromeDriver();

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
}
