package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import demoQAWebsite.HelperMethods.WindowsMethods;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowsTabsTest {

    WebDriver driver;
    JavascriptHelpers javascriptHelpers;
    ElementsMethods elementsMethods;
    WindowsMethods windowsMethods;
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
        windowsMethods = new WindowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
//        javascriptHelpers.scrollDown(400);

//        WebElement alertsFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(alertsFramesAndWindowsElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        elementsMethods.clickOnElement(browserWindowsElement);
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabButtonElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabButtonElement);

        windowsMethods.switchToOpenedTab();

        WebElement sampleHeadingFromNewTabElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: " + sampleHeadingFromNewTabElement.getText());

        // driver.close();  -> inchide doar fereastra curenta, nu tot browserul :)
        windowsMethods.closeTab();

        windowsMethods.switchToMainTab();

        WebElement newWindowButtonElement = driver.findElement(By.id("windowButton"));
        elementsMethods.clickOnElement(newWindowButtonElement);

        windowsMethods.switchToOpenedWindow();
        WebElement sampleHeadingFromNewWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este: " + sampleHeadingFromNewWindowElement.getText());

        // driver.close();  -> inchide doar fereastra curenta, nu tot browserul :)
        windowsMethods.closeWindow();

        windowsMethods.switchToMainWindow();

        Thread.sleep(5000);
        driver.quit();
    }
}
