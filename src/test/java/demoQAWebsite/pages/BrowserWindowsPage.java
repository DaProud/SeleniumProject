package demoQAWebsite.pages;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.WindowsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BrowserWindowsPage extends CommonPage{
    @FindBy(id = "tabButton")
    WebElement newTabButtonElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingFromNewTabElement;
    @FindBy(id = "windowButton")
    WebElement newWindowButtonElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingFromNewWindowElement;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTheNewTab() {
        // New Tab:
        elementsMethods.clickOnElement(newTabButtonElement);
        windowsMethods.switchToOpenedTab();
        Assert.assertEquals(sampleHeadingFromNewTabElement.getText(), "This is a sample page");
        windowsMethods.closeTab();
    }

    public void interactWithTheNewWindow() {
        // New Window:
        elementsMethods.clickOnElement(newWindowButtonElement);
        windowsMethods.switchToOpenedWindow();
        Assert.assertEquals(sampleHeadingFromNewWindowElement.getText(), "This is a sample page");
        windowsMethods.closeWindow();
    }

}
