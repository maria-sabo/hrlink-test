package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class PositionsPage extends BasePage {
    public PositionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "employee-positions-catalog-header__actions")
    private List<WebElement> addPositionBtn;

    public PositionsPage goToPositionsPage(String url) {
        driver.get(url);
        return this;
    }

    public void checkBtn() {
        Assert.assertTrue(addPositionBtn.size() > 0);
    }

    public void checkTextOnBtn() {
        Assert.assertEquals(addPositionBtn.get(0).getText(), "Добавить должность");
    }

    public void clickAddPositionBtn() {
        addPositionBtn.get(0).click();
    }
}
