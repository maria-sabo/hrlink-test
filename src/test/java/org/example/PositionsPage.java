package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.logging.Logger;


public class PositionsPage {
    public WebDriver driver;
    public Logger logger;


    public PositionsPage(WebDriver driver, Logger logger) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.logger = logger;
    }

    @FindBy(how = How.CLASS_NAME, using = "employee-positions-catalog-header__actions")
    private List<WebElement> addPositionBtns;


    public boolean checkBtn() {
        if (addPositionBtns.size() > 0) {
            System.out.println("кнопка есть");
            logger.info("Кнопочка добавить должность есть.");
            return true;
        } else {
            logger.warning("Кнопочки добавить должность нет.");
            return false;
        }
    }


    public boolean checkTextOnBtn() {
        if (addPositionBtns.get(0).getText().equals("Добавить должность")) {
            logger.info("Надпись Добавить должность есть.");
            return true;
        } else {
            logger.warning("Надпись Добавить должность нет.");
            return false;
        }
    }

    public void clickAddPositionBtn() {
        addPositionBtns.get(0).click();
    }

}
