package tests;

import org.example.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.PositionsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public HomePage myHomePage = new HomePage(driver);
    public PositionsPage myPositionsPage = new PositionsPage(driver);


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        new WebDriverWait(driver, 50).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }
}
