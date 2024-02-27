package Tests;

import ShareData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    private HomePage homePage;
    private CommonPage commonPage;
    private AlertsPage alertsPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Alerts");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts sub-menu");

        // Alert simplu: Doar Text si OK button
        alertsPage.interactWithSimpleAlert();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with alert with ok");

        // Alert cu delay la afisare
        alertsPage.interactWithDelayedAlert();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with alert with delay");

        // Alert cu Confirm - OK/cancel
        alertsPage.interactWithConfirmAlert(true);
        // TODO: Assert the text that is displayed upon click... :)
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with alert with cancel");

        // Alert cu Prompt Text
        alertsPage.interactWithPromptAlert("Some automation text here...", true);
        // TODO: Assert the text that is displayed upon click... :)
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with alert with prompt");

    }

}
