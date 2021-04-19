package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage {

    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
//    By userNameId = By.id("email");
//    By passwordId = By.id("password");
//    By loginButtonId = By.id("loginButton");
//    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
//    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

//    @FindBy(how = How.ID, id = "mat-input-0")
//    private WebElement loginField;
//
//    @FindBy(how = How.ID, id = "mat-input-1")
//    private WebElement passwordField;
//
//    @FindBy(how = How.CLASS_NAME, className = "mat-button-wrapper")
//    private WebElement loginBtn;
//
//    @FindBy(how = How.CLASS_NAME, className = "ng-star-inserted")
//    private WebElement errorMessage;

    By userNameClassName = By.className("mat-input-0");
    By passwordClassName = By.className("mat-input-1");
    By loginBtnClassName = By.className("mat-button-wrapper");
    By errorMessageClassName = By.className("ng-star-inserted");


    /**
     * Page Methods
     */
    public LoginPage login(String username, String password) {
        writeText(userNameClassName, username);
        writeText(passwordClassName, password);
        click(loginBtnClassName);
        return this;
    }

    public LoginPage verifyLoginUserName(String expectedText) {
        waitVisibility(errorMessageClassName);
        Assert.assertEquals(readText(errorMessageClassName), expectedText);
        return this;
    }

    public LoginPage verifyLoginPassword(String expectedText) {
        waitVisibility(errorMessageClassName);
        Assert.assertEquals(readText(errorMessageClassName), expectedText);
        return this;
    }
}