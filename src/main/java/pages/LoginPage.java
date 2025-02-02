package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Define o elemento localizador
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // Manter o webdriver inicializado durante toda a execução.
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodos que recebem "digita nos campos" os valores de login (usuario e senha)
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErroMessage(){
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }
}
