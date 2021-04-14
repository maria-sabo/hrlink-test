package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class PositionsPage {
    public WebDriver driver;
    public Logger logger;


    public PositionsPage(WebDriver driver, Logger logger) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.logger = logger;
    }

    public boolean checkBtn() {
        if (driver.findElements(By.xpath("//html/body/root/div/div/employee-position-catalog-page/div/employee-positions-catalog-header/div/div/button")).size() > 0) {
            System.out.println("кнопка есть");
            logger.info("Кнопочка добавить должность есть.");
            return true;
        } else {
            logger.warning("Кнопочки добавить должность нет.");
            return false;
        }
    }

    @FindBy(xpath = "//html/body/root/div/div/employee-position-catalog-page/div/employee-positions-catalog-header/div/div/button")
    private WebElement addPositionBtn;

    public void clickAddPositionBtn() {
        addPositionBtn.click();
    }

}
