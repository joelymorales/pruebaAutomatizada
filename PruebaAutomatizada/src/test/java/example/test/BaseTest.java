package example.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class BaseTest {

    public void takeScreenshot(WebDriver driver,String fileName) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream("Reports/" + fileName + ".png")) {
            outputStream.write(Base64.getDecoder().decode(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)));
        }
    }
}
