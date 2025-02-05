package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By backpack = By.id("item_4_title_link");
    private By addBackpackCart = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackCart = By.id("remove-sauce-labs-backpack");

    private By backToProducts = By.id("back-to-products");

    private By jacket = By.id("item_5_title_link");
    private By addJacketCart = By.id("add-to-cart-sauce-labs-fleece-jacket");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickProductBackpack(){

        driver.findElement(backpack).click();
    }

    public void clickProductJacket(){

        driver.findElement(jacket).click();
    }

    public void addBackpackToCart(){

        driver.findElement(addBackpackCart).click();
    }

    public String getTextButton(){

        return driver.findElement(removeBackpackCart).getText();
    }

    public void addJacketToCart(){

        driver.findElement(addJacketCart).click();
    }

    public void returnProduct(){

        driver.findElement(backToProducts).click();
    }



}
