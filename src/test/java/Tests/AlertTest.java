package Tests;

import ShareData.ShareData;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class AlertTest extends ShareData {

    private HomePage homePage;
    private CommonPage commonPage;
    private AlertsPage alertsPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

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
