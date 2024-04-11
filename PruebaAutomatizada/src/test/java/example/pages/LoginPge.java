package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPge extends BasePge {

    By usuarioInput = By.id("user-name");
    By passwordInput = By.id("password");
    By submitButton = By.id("login-button");
    By titulo = By.className("app_logo");

    public LoginPge(WebDriver driver) {
        super(driver);
    }

    public void login(){
        waitForElementVisibility(usuarioInput);
        type(usuarioInput,"standard_user");
        type(passwordInput,"secret_sauce");
        click(submitButton);
        WebElement tituloElement = waitForElementVisibility(titulo);
        Assert.assertEquals(tituloElement.getText(),"Swag Labs");
    }
}
