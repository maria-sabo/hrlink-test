package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public BasePage goToPage(String url){
        driver.get(url);
        return this;
    }

    public void checkListOfElements(List<WebElement> listOfWebElements) {
        Assert.assertTrue(listOfWebElements.size() > 0);
    }

    public void checkTextOnElementInList(List<WebElement> listOfWebElements, String expectedText) {
        Assert.assertEquals(listOfWebElements.get(0).getText(), expectedText);
    }

    public void clickFirstElementInList(List<WebElement> listOfWebElements) {
        listOfWebElements.get(0).click();
    }

    public void checkElementIsDisplayed(WebElement webElement){
        Assert.assertTrue(webElement.isDisplayed());
    }
    public void clickElement(WebElement webElement) {
        webElement.click();
    }
    public void checkTextOnElement(WebElement webElement, String expectedText) {
        Assert.assertEquals(webElement.getText(), expectedText);
    }



}