package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String filePath = "src/test/data/config/configuration.properties";

        driver.get(ConfigReader.readProperty(filePath, "url"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    public WebDriver getDriver(){
        return driver;
    }


}