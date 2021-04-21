package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;
import java.util.logging.Logger;


public class PositionsPage228 {
    public WebDriver driver;


    public PositionsPage228(WebDriver driver, Logger logger) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "employee-positions-catalog-header__actions")
    private List<WebElement> addPositionBtns;


    public boolean checkBtn() {
        if (addPositionBtns.size() > 0) {
            //logger.info("Кнопочка добавить должность есть.");
            return true;
        } else {
            //logger.warning("Кнопочки добавить должность нет.");
            return false;
        }
    }


    public boolean checkTextOnBtn() {
        return addPositionBtns.get(0).getText().equals("Добавить должность");
    }

    public void clickAddPositionBtn() {
        addPositionBtns.get(0).click();
    }

}
