package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.FramesMethods;
import demoQAWebsite.ShareData.ShareData;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.FramesPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest extends ShareData {

    FramesMethods framesMethods;
    HomePage homePage;
    CommonPage commonPage;
    FramesPage framesPage;

    @Test
    public void automationMethod() throws InterruptedException {

        framesMethods = new FramesMethods(driver);

        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        framesPage = new FramesPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");

        // Frame 1:
        framesPage.interactWithFrame1();

        // Ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToMainContent();

        // Frame 2:
        framesPage.interactWithFrame2();

        framesMethods.switchToMainContent();
    }
}
