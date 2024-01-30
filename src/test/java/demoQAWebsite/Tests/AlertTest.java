package demoQAWebsite.Tests;

import demoQAWebsite.ShareData.ShareData;
import demoQAWebsite.pages.AlertsPage;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        alertsPage = new AlertsPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Alerts");

        // Alert simplu: Doar Text si OK button
        alertsPage.interactWithSimpleAlert();

        // Alert cu delay la afisare
        alertsPage.interactWithDelayedAlert();

        // Alert cu Confirm - OK/cancel
        alertsPage.interactWithConfirmAlert(true);
        // TODO: Assert the text that is displayed upon click... :)

        // Alert cu Prompt Text
        alertsPage.interactWithPromptAlert("Some automation text here...", true);
        // TODO: Assert the text that is displayed upon click... :)

    }

}
