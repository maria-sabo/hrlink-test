package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MyBasePage {
    public WebDriver driver;

    public MyBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}