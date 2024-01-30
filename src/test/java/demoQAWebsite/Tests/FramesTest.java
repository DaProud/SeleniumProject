package demoQAWebsite.Tests;

import demoQAWebsite.ShareData.ShareData;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.FramesPage;
import demoQAWebsite.pages.HomePage;
import org.testng.annotations.Test;

public class FramesTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    FramesPage framesPage;

    @Test
    public void automationMethod() throws InterruptedException {

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
