package demoQAWebsite.HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

    WebDriver driver;
    Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element) {
        String pictureFilePath = "src/test/resources/1.png";
        File file = new File(pictureFilePath);
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value) {
        for (WebElement element : elementsList) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void fillElementFollowedByEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void selectByValue(WebElement element, String value) {
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(value);
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void fillMultipleValues(WebElement element, List<String> values) {
        for (String value : values) {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void clickMultipleValues(List<WebElement> webElements, List<String> values) {
        for (String value : values) {
            for (WebElement webElement: webElements){
                if (webElement.getText().equals(value)) {
                    webElement.click();
                }
            }
        }
    }

    public void checkMultipleElementsByListOfValues(List<WebElement> elements, List<String> values) {
        for (String value : values) {
            for (WebElement element : elements) {
                if (element.getText().equals(value)) {
                    element.click();
                }
            }
        }
    }

    public void fillWithActions(WebElement element, String value) {
        actions.sendKeys(value).perform();
        waitVisibilityOfElement(element);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void waitVisibilityOfElement(WebElement element) {
        // definim un wait explicit ca sa astepte dupa vizibilitatea elementului
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
