package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyHomePage extends MyBasePage {
    /**
     * Constructor
     */
    public MyHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://app-test1.hr-link.ru/";
    @FindBy(how = How.ID, id = "mat-input-0")
    private WebElement loginField;

    @FindBy(how = How.ID, id = "mat-input-1")
    private WebElement passwordField;

    @FindBy(how = How.CLASS_NAME, className = "mat-button-wrapper")
    private WebElement loginBtn;

    @FindBy(how = How.CLASS_NAME, className = "ng-star-inserted")
    private WebElement errorMessage;

    /**
     * Page Methods
     */
    public MyHomePage goToN11() {
        driver.get(baseURL);
        return this;
    }

    public MyLoginPage goToLoginPage() {
        return new MyLoginPage(driver);
    }
}