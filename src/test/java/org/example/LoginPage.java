package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.MyBasePage;

public class LoginPage extends MyBasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, id = "mat-input-0")
    private WebElement loginField;

    @FindBy(how = How.ID, id = "mat-input-1")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, className = "mat-button-wrapper")
    private WebElement loginBtn;

    @FindBy(how = How.CLASS_NAME, className = "ng-star-inserted")
    private WebElement errorMessage;


    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public String readMessage() {
        return errorMessage.getText();
    }
}
