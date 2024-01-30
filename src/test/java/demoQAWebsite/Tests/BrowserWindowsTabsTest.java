package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.WindowsMethods;
import demoQAWebsite.ShareData.ShareData;
import demoQAWebsite.pages.BrowserWindowsPage;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowsTabsTest extends ShareData {

    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;
    BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() throws InterruptedException {

        windowsMethods = new WindowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");

        // New Tab:
        browserWindowsPage.interactWithTheNewTab();
        windowsMethods.switchToMainWindow();

        // New Window:
        browserWindowsPage.interactWithTheNewWindow();
        windowsMethods.switchToMainWindow();
    }
}
