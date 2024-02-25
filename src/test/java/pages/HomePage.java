package pages;

import logger.LoggerUtility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {
    // Identificam WebElement-ele specifice pentru pagina
    @FindBy(xpath = "//h5")
    private List<WebElement> elements;
    @FindBy(xpath = "//p[text()='Consent']")
    private WebElement consentElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
        try {
            elementsMethods.clickOnElement(consentElement);
            LoggerUtility.infoLog("The user clicks on consentElement");
        } catch (NoSuchElementException ignored) {
        }
        // Facem scroll ca sa fie vizibil elementul in pagina
        javascriptHelpers.scrollDown(400);
        LoggerUtility.infoLog("The user scrolls down the page");
        elementsMethods.selectElementFromListByText(elements, menu);
        LoggerUtility.infoLog("The user selects from menu the option with the value: "+ menu);
    }

}
