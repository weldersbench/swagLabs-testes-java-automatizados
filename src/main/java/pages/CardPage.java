package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardPage {

    private WebDriver driver;

    private By card = By.id("shopping_cart_container");
    private By table = By.className("cart_item");

    public CardPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickCard(){

        driver.findElement(card).click();
    }

    public List<WebElement> getCardItens(){
        return driver.findElements(table);
    }

    // Mapeia os produtos na lista do carrinho, como argumento passado outro mapeamento do preço, para armazenar os preços junto com a contagem.
    public Map<String, Integer> getProductsCountAndPrices(Map<String, Double> productPrices){
        List<WebElement> itens = getCardItens();
        Map<String, Integer> productCounts = new HashMap<>();

        for (WebElement item : itens) {
            String productName = item.findElement(By.className("inventory_item_name")).getText();
            String priceText = item.findElement(By.className("inventory_item_price")).getText();
            Double price = Double.parseDouble(priceText.replace("$", "").trim());

            // Armazena o preço no Map externo
            productPrices.put(productName, price);

            // Conta os produtos no carrinho
            productCounts.put(productName, productCounts.getOrDefault(productName, 0) + 1);
        }

        // Retornamos apenas o Map<String, Integer> da contagem, e o Map<String, Double> dos preços é preenchido externamente.
        return productCounts;
    }
}
