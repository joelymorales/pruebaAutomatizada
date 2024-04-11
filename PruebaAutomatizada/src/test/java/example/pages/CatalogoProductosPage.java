package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CatalogoProductosPage extends BasePge{

    By productos = By.cssSelector(".btn_inventory ");
    By mochila = By.id("add-to-cart-sauce-labs-backpack");
    By carritoContador = By.className("shopping_cart_badge");
    By removerMochilaBoton = By.id("remove-sauce-labs-backpack");
    By redesSocialesIconos = By.className("social");

    public CatalogoProductosPage(WebDriver driver) {
        super(driver);
    }

    public void validaCantidadProductos(int cantidadEsperada){
        List<WebElement> listaProductos = encontrarElementos(productos);
        Assert.assertEquals(listaProductos.size(),cantidadEsperada);
    }

    public void agregarMochilaCarrito(){
        click(mochila);
        WebElement carritoElement = waitForElementVisibility(carritoContador);
        Integer contador = Integer.parseInt(carritoElement.getText());
        Assert.assertEquals(contador,1);
    }

    public void removerMochilaCarrito(){
        click(removerMochilaBoton);
    }

    public void validaIconosRedesSociales(){
        scrollToFooter();
        waitForElementVisibility(redesSocialesIconos);
    }
}
