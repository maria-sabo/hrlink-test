package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MyHomePage;

import java.util.concurrent.TimeUnit;

public class MyBaseTest {
    public static WebDriver driver;
    public MyHomePage myHomePage = new MyHomePage(driver);

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
