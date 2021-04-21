package tests;

import com.relevantcodes.extentreports.*;
import org.junit.Test;
import utils.ExtentReports.ExtentTestManager;

import java.util.logging.Logger;


public class SomeTest extends BaseTest {

    public static Logger logger = Logger.getLogger("MyLog");

    @Test
    public void loginTest() {
        ExtentTest loginTest = ExtentTestManager.startTest("Логин", "Тестирование корректного логина.");
        try {
            myHomePage
                    .goToMainPage(ConfProperties.getProperty("loginPage"))
                    .goToLoginPage()
                    .login(ConfProperties.getProperty("login"), ConfProperties.getProperty("password"))
                    .verifyLogin();
            loginTest.log(LogStatus.PASS, "Залогинились!");
        } catch (AssertionError ae) {
            loginTest.log(LogStatus.FAIL, "Что-то пошло не так.");
        }
        ExtentTestManager.endTest(loginTest);
    }

    @Test
    public void positionsTest() {
        ExtentTest positionsTest = ExtentTestManager.startTest("Страница должностей", "Проверка страницы должностей.");
        try {
            myPositionsPage
                    .goToPositionsPage(ConfProperties.getProperty("positionsPage"))
                    .checkBtn();
            positionsTest.log(LogStatus.PASS, "Кнопка \"Добавить должность\" присутствует.");
        } catch (AssertionError ae) {
            positionsTest.log(LogStatus.FAIL, "Что-то пошло не так. Кнопка \"Добавить должность\" отсутствует.");
        }
        try {
            myPositionsPage
                    .checkTextOnBtn();
            positionsTest.log(LogStatus.PASS, "Надпись на кнопке корректная.");
        } catch (AssertionError ae) {
            positionsTest.log(LogStatus.FAIL, "Что-то пошло не так. Надпись на кнопке некорректная.");
        }
        try {
            myPositionsPage
                    .clickAddPositionBtn();
            positionsTest.log(LogStatus.PASS, "На кнопку нажали хорошо.");
        } catch (AssertionError ae) {
            positionsTest.log(LogStatus.FAIL, "Что-то пошло не так. На кнопку не смогли нажать.");
        }
        try {
            myPositionsPage
                    .checkSaveBtn();
            positionsTest.log(LogStatus.PASS, "Кнопка \"Сохранить\" присутствует.");
        } catch (AssertionError ae) {
            positionsTest.log(LogStatus.FAIL, "Что-то пошло не так. Кнопка \"Сохранить\" отсутствует.");
        }

        ExtentTestManager.endTest(positionsTest);

    }
}
