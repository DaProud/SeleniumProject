package Tests;

import ShareData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.BrowserWindowsPage;
import pages.CommonPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class BrowserWindowsTabsTest extends Hooks {
    private HomePage homePage;
    private CommonPage commonPage;
    private BrowserWindowsPage browserWindowsPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        browserWindowsPage = new BrowserWindowsPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Browser Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Browser Windows sub-menu");

        // New Tab:
        browserWindowsPage.interactWithTheNewTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with new tab process");

        // New Window:
        browserWindowsPage.interactWithTheNewWindow();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with new window process");

    }
}
