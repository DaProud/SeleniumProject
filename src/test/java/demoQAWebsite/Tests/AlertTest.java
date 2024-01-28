package demoQAWebsite.Tests;

import demoQAWebsite.pages.AlertsPage;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;

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

        driver.quit();
    }

}
