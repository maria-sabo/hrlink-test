package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PositionsPage extends BasePage {
    public PositionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "employee-positions-catalog-header__actions")
    public List<WebElement> addPositionBtn;

    @FindBy(how = How.CLASS_NAME, using = "mat-button-wrapper")
    //@FindBy(how = How.XPATH, using = "//div[@class='mat-button-wrapper']/span")
    private WebElement saveBtn;

    public PositionsPage goToPositionsPage(String url) {
        driver.get(url);
        return this;
    }

    public void checkBtn() {
        checkListOfElements(addPositionBtn);
    }

    public void checkTextOnBtn() {
        checkTextOnElementInList(addPositionBtn,"Добавить должность" );
    }

    public void clickAddPositionBtn() {
        clickFirstElementInList(addPositionBtn);
    }

    public PositionsPage checkSaveBtn(){
        checkElementIsDisplayed(saveBtn);
        return this;
    }
    public void checkTextOnSaveBtn() {
        checkTextOnElement(saveBtn,"Сохранить" );
    }
    public void clickSaveBtn() {
        clickElement(saveBtn);
    }
}
