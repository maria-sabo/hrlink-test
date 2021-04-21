package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
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

    @FindBy(how = How.ID, using = "mat-dialog-0")
    private WebElement dialogWindow;

    public String readMessage() {
        return errorMessage.getText();
    }

    public LoginPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginBtn.click();
        return this;
    }


    public void verifyLogin() {
        boolean errorDialogIsDisplayed = false;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            errorDialogIsDisplayed = dialogWindow.isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
        Assert.assertFalse(errorDialogIsDisplayed);
    }

}
