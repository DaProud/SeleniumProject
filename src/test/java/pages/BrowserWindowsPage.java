package pages;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BrowserWindowsPage extends CommonPage {
    @FindBy(id = "tabButton")
    private WebElement newTabButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowButtonElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingFromNewWindowElement;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTheNewTab() {
        // New Tab:
        elementsMethods.clickOnElement(newTabButtonElement);
        LoggerUtility.infoLog("The user click on the newTabButtonElement");
        windowsMethods.switchToOpenedTab();
        LoggerUtility.infoLog("The user switches to the opened Tab");
        Assert.assertEquals(sampleHeadingFromNewTabElement.getText(), "This is a sample page");
        windowsMethods.closeTab();
        LoggerUtility.infoLog("The user closes the tab");
        windowsMethods.switchToMainWindow();
        LoggerUtility.infoLog("The user switches to the Main window");
    }

    public void interactWithTheNewWindow() {
        // New Window:
        elementsMethods.clickOnElement(newWindowButtonElement);
        LoggerUtility.infoLog("The user click on the newWindowButtonElement");
        windowsMethods.switchToOpenedWindow();
        LoggerUtility.infoLog("The user switches to the opened Windows");
        Assert.assertEquals(sampleHeadingFromNewWindowElement.getText(), "This is a sample page");
        windowsMethods.closeWindow();
        LoggerUtility.infoLog("The user closes the window");
        windowsMethods.switchToMainWindow();
        LoggerUtility.infoLog("The user switches to the Main window");
    }

}
