package org.example;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;

import com.relevantcodes.extentreports.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.reporter.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class SomeTest {
    public static LoginPage loginPage;
    public static PositionsPage positionsPage;
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger("MyLog");
    public static ExtentReports extent = new ExtentReports("/home/maria/IdeaProjects/hrlink-test/log.html", true);


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        new WebDriverWait(driver, 50).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        //ExtentReports extent = new ExtentReports("/home/maria/IdeaProjects/hrlink-test/log.html", true);


//        ExtentReports reports = new ExtentReports("Path of directory to store the resultant HTML file", true/false);
//
//        ExtentTest test = reports.startTest("TestName");

        loginPage = new LoginPage(driver);
        positionsPage = new PositionsPage(driver, logger);
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("/home/maria/IdeaProjects/hrlink-test/log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            // the following statement is used to log any messages
            logger.info("My first log");
        } catch (
                SecurityException | IOException e) {
            e.printStackTrace();
        }


        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginPage"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test
    public void loginTest() {

        ExtentTest loginTest = extent.startTest("Логин", "Логинимся.");

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage.clickLoginBtn();

        logger.info("Нажали кнопку \"Войти\".");
        loginTest.log(LogStatus.PASS, "Залогинились!");
        extent.endTest(loginTest);
        extent.flush();

    }


    @Test
    public void positionsTest() {
        ExtentTest positionsTest = extent.startTest("Страница должностей", "Проверка страницы должностей.");
        driver.get(ConfProperties.getProperty("positionsPage"));
        Assert.assertTrue(positionsPage.checkBtn());
        positionsTest.log(LogStatus.PASS, "Кнопка \"Добавить должность\" нажата!");
        Assert.assertTrue(positionsPage.checkTextOnBtn());
        positionsTest.log(LogStatus.PASS, "Надпись на кнопке корректная.");
        positionsPage.clickAddPositionBtn();
        extent.endTest(positionsTest);
        extent.flush();

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
