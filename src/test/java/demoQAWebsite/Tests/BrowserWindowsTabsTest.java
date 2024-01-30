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
    HomePage homePage;
    CommonPage commonPage;
    BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() throws InterruptedException {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        browserWindowsPage = new BrowserWindowsPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");

        // New Tab:
        browserWindowsPage.interactWithTheNewTab();


        // New Window:
        browserWindowsPage.interactWithTheNewWindow();

    }
}
