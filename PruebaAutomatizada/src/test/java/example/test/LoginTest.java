package example.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import example.pages.LoginPge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.IOException;


@Listeners({ExtentITestListenerClassAdapter.class})
public class LoginTest extends BaseTest{

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(groups = {"login", "a:Joely"})
    public void loginTest() throws IOException {
        driver.get("https://www.saucedemo.com/");
        LoginPge loginPge = new LoginPge(driver);
        loginPge.login();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        takeScreenshot(driver, "login");
        ExtentTestManager.getTest(result).pass("Captura de Pantalla",
                MediaEntityBuilder.createScreenCaptureFromPath("login.png").build());
        if (driver != null) {
            driver.quit();
        }
    }

}
