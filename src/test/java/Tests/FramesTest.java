package Tests;

import ShareData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class FramesTest extends Hooks {

    private HomePage homePage;
    private CommonPage commonPage;
    private FramesPage framesPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        framesPage = new FramesPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Frames");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Frames sub-menu");

        framesPage.interactWithFrame1();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with the first iFrame");
        framesPage.interactWithFrame2();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with the second iFrame");
    }
}
