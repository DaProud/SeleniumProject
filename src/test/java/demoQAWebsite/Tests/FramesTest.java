package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.FramesMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {

    WebDriver driver;
    JavascriptHelpers javascriptHelpers;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void automationMethod() throws InterruptedException {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        javascriptHelpers = new JavascriptHelpers(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);


        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
//        javascriptHelpers.scrollDown(400);
//
//        WebElement alertsFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(alertsFramesAndWindowsElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementsMethods.clickOnElement(framesElement);
        commonPage.goToDesiredSubMenu("Frames");

        javascriptHelpers.scrollDown(400);

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        framesMethods.switchToFrame(frame1Element);

        WebElement sampleHeadingFromFrame1Element = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayContentOfElement(sampleHeadingFromFrame1Element);

        // Ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToMainContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        framesMethods.switchToFrame(frame2Element);
        WebElement sampleHeadingFromFrame2Element = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayContentOfElement(sampleHeadingFromFrame2Element);

        Thread.sleep(2000);
        javascriptHelpers.scroll(50, 50);

        framesMethods.switchToMainContent();

        Thread.sleep(5000);
        driver.quit();
    }
}
