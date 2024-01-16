package demoQAWebsite.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTabsTest {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        WebElement alertsFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFramesAndWindowsElement.click();

        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        WebElement newTabButtonElement = driver.findElement(By.id("tabButton"));
        newTabButtonElement.click();

        // driver.getWindowHandles()  -> returneaza toate windows-urile deschise
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingFromNewTabElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: " + sampleHeadingFromNewTabElement.getText());

        // driver.close();  -> inchide doar fereastra curenta, nu tot browserul :)
        driver.close();

        driver.switchTo().window(tabList.get(0));
        WebElement newWindowButtonElement = driver.findElement(By.id("windowButton"));
        newWindowButtonElement.click();

        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        WebElement sampleHeadingFromNewWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este: " + sampleHeadingFromNewWindowElement.getText());

        // driver.close();  -> inchide doar fereastra curenta, nu tot browserul :)
        driver.close();

        driver.switchTo().window(windowsList.get(0));

        Thread.sleep(5000);
        driver.quit();
    }
}
