package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.AlertMethods;
import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethods elementMethods;
    AlertMethods alertMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void automationMethod() {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        // definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        elementMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

//        javascriptHelpers.scrollDown(400);
//
//        WebElement alertsFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementMethods.clickOnElement(alertsFramesAndWindowsElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        elementMethods.clickOnElement(alertsElement);
        commonPage.goToDesiredSubMenu("Alerts");


        // Alert simplu: Doar Text si OK button
        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        elementMethods.clickOnElement(alertOkButton);
        alertMethods.interactWithAlertOK();

        // Alert cu delay la afisare
        WebElement alertDelayButton = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickOnElement(alertDelayButton);
        alertMethods.interactWithDelayAlert();

        // Alert cu Confirm - OK/cancel
        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        elementMethods.clickOnElement(alertConfirmButton);
        alertMethods.interactWithAlertCancel();

        // Alert cu Prompt Text
        WebElement alertPromptButton = driver.findElement(By.id("promtButton"));
        elementMethods.clickOnElement(alertPromptButton);

        alertMethods.interactWithPromptAlertOK("Some automation text here...");

        driver.quit();
    }

}
