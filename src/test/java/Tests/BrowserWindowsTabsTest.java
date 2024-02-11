package Tests;

import ShareData.ShareData;
import pages.BrowserWindowsPage;
import pages.CommonPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class BrowserWindowsTabsTest extends ShareData {
    private HomePage homePage;
    private CommonPage commonPage;
    private BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() {

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
