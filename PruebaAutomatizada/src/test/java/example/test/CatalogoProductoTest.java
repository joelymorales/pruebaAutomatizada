package example.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import example.pages.CatalogoProductosPage;
import example.pages.LoginPge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ExtentITestListenerClassAdapter.class})
public class CatalogoProductoTest extends BaseTest{

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(groups = {"catalogo", "a:Joely"})
    public void catalogoTest() throws IOException {
        driver.get("https://www.saucedemo.com/");
        LoginPge loginPge = new LoginPge(driver);
        loginPge.login();
        CatalogoProductosPage catalogoProductosPage =new CatalogoProductosPage(driver);
        catalogoProductosPage.validaCantidadProductos(6);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        takeScreenshot(driver, "catalogo");
        ExtentTestManager.getTest(result).pass("Captura de Pantalla",
                MediaEntityBuilder.createScreenCaptureFromPath("catalogo.png").build());
        if (driver != null) {
            driver.quit();
        }
    }
}
