package pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;
    AlertMethods alertMethods;
    Actions actions;
    FramesMethods framesMethods;
    WindowsMethods windowsMethods;
    // Identificam WebElement-ele specifice pentru sub-pagini
    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> elements;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.alertMethods = new AlertMethods(driver);
        this.actions = new Actions(driver);
        this.framesMethods = new FramesMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    // Facem metode specifice pentru pagina
    public void goToDesiredSubMenu(String submenu) {
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, submenu);
    }
}
