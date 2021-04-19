package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(how = How.ID, id = "mat-input-0")
    private WebElement loginField;

    @FindBy(how = How.ID, id = "mat-input-1")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, className = "mat-button-wrapper")
    private WebElement loginBtn;

    //@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted')]")
    @FindBy(how = How.CLASS_NAME, className = "ng-star-inserted")
    private WebElement errorMessage;



    public void inputLogin(String login) { loginField.sendKeys(login);}

    public void inputPassword(String password) {passwordField.sendKeys(password);}

    public void clickLoginBtn(){loginBtn.click();}

    public String readMessage(){return errorMessage.getText();}
}
