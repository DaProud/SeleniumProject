package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

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
        } catch (NoSuchElementException ignored) {
        }
        // Facem scroll ca sa fie vizibil elementul in pagina
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }

}
