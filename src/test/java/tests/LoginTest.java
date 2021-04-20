package tests;


import java.lang.reflect.Method;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ExtentReports.ExtentManager;
import utils.ExtentReports.ExtentTestManager;
import utils.Listeners.Retry;

public class LoginTest extends BaseTest {


    @Test
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        ExtentTestManager.startTest(method.getName(), "Я устала");

        homePage
                .goToN11()
                .goToLoginPage();
                //.login("123", "1");
        //.verifyLoginUserName("Lütfen e-posta adresinizi girin.")
        // .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
        ExtentTestManager.endTest();
    }

    @Test
    public void besit(Method method) {
        ExtentTestManager.startTest(method.getName(), "Я устала =(");

        homePage
                .goToN11()
                .goToLoginPage()
                .login("1234", "1");
        //.verifyLoginUserName("Lütfen e-posta adresinizi girin.")
        // .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
        ExtentTestManager.endTest();
    }
//    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
//    public void invalidLoginTest_EmptyUserEmptyPassword1(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
//
//        homePage
//                .goToN11()
//                .goToLoginPage()
//                .login("123", "1");
//        //.verifyLoginUserName("Lütfen e-posta adresinizi girin.")
//        // .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
//        ExtentTestManager.endTest();
//    }
}