package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToMainPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage goToLoginPage() {
        return new LoginPage(driver);
    }
}