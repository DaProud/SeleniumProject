package demoQAWebsite.pages;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage{
    // Identificam WebElement-ele specifice pentru pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;
    @FindBy(xpath = "//p[text()='Consent']")
    WebElement consentElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
        elementsMethods.clickOnElement(consentElement);
        // Facem scroll ca sa fie vizibil elementul in pagina
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }

}
