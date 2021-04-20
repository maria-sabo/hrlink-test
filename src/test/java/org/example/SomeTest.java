package org.example;

import com.relevantcodes.extentreports.*;
import org.junit.Assert;
import org.junit.Test;
import utils.ExtentReports.MyExtentTestManager;

import java.util.logging.Logger;


public class SomeTest extends MyBaseTest {

    public static Logger logger = Logger.getLogger("MyLog");
    public static PositionsPage positionsPage = new PositionsPage(driver, logger);;

    @Test
    public void loginTest() {
        ExtentTest loginTest = MyExtentTestManager.startTest("Очень", "Я устала =(");
        myHomePage
                .goToN11()
                .goToLoginPage()
                .login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"));

        loginTest.log(LogStatus.PASS, "Залогинились!");
        MyExtentTestManager.endTest(loginTest);
    }

    @Test
    public void positionsTest() {
        ExtentTest positionsTest = MyExtentTestManager.startTest("Страница должностей", "Проверка страницы должностей.");
        driver.get(ConfProperties.getProperty("positionsPage"));
        Assert.assertTrue(positionsPage.checkBtn());
        positionsTest.log(LogStatus.PASS, "Кнопка \"Добавить должность\" нажата!");
        Assert.assertTrue(positionsPage.checkTextOnBtn());
        positionsTest.log(LogStatus.PASS, "Надпись на кнопке корректная.");
        positionsPage.clickAddPositionBtn();
        MyExtentTestManager.endTest(positionsTest);

    }
}
