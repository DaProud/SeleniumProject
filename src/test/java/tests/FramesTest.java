package tests;

import ShareData.ShareData;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;
import org.testng.annotations.Test;

public class FramesTest extends ShareData {

    private HomePage homePage;
    private CommonPage commonPage;
    private FramesPage framesPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        framesPage = new FramesPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");

        // Frame 1:
        framesPage.interactWithFrame1();

        // Frame 2:
        framesPage.interactWithFrame2();


    }
}
