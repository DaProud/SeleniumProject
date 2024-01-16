package demoQAWebsite.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {

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

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesElement.click();

        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingFromFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din frame este: " + sampleHeadingFromFrameElement.getText());

        // switchTo().defaultContent -> Ne ducem cu focusul inapoi pe pagina principala
        driver.switchTo().defaultContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);
        Thread.sleep(2000);
        javascriptExecutor.executeScript("window.scrollBy(50,50)");

        driver.switchTo().defaultContent();

        Thread.sleep(5000);
        driver.quit();

    }
}
