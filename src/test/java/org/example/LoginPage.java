package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"mat-input-1\"]")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/root/div/div/login-email/logged-out-layout/div/div[1]/div[2]/credential-form/form/button/span")
    private WebElement loginBtn;

    @FindBy(xpath = "//span[contains(@class, 'ng-star-inserted')]")
    private WebElement errorMessage;



    public void inputLogin(String login) { loginField.sendKeys(login);}

    public void inputPassword(String password) {passwordField.sendKeys(password);}

    public void clickLoginBtn(){loginBtn.click();}

    public String readMessage(){return errorMessage.getText();}
}
