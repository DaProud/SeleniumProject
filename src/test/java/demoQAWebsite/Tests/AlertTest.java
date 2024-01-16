package demoQAWebsite.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

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

        // definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        WebElement alertsFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFramesAndWindowsElement.click();

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsElement.click();

        // Alert simplu: Doar Text si OK button
        WebElement alertOkButton = driver.findElement(By.id("alertButton"));
        alertOkButton.click();

        // ne mutam cu focusul pe alerta deschisa
        Alert alertOk = driver.switchTo().alert();
        System.out.println("Text on alert:" + alertOk.getText());
        //Thread.sleep(3000);
        alertOk.accept();


        // Alert cu delay la afisare
        WebElement alertDelayButton = driver.findElement(By.id("timerAlertButton"));
        alertDelayButton.click();

        // Definim un wait explicit ca sa astepte dupa alerta
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelay = driver.switchTo().alert();
        System.out.println("Text on alert:" + alertDelay.getText());
        Thread.sleep(2000);
        alertDelay.accept();

        WebElement alertConfirmButton = driver.findElement(By.id("confirmButton"));
        alertConfirmButton.click();
        Alert alertConfirm = driver.switchTo().alert();
        System.out.println("Text on alert:" + alertConfirm.getText());
        Thread.sleep(2000);
        alertConfirm.dismiss();

        WebElement alertPromptButton = driver.findElement(By.id("promtButton"));
        alertPromptButton.click();

        Alert alertPrompt = driver.switchTo().alert();
        System.out.println("Text on alert:" + alertPrompt.getText());
        Thread.sleep(2000);
        alertPrompt.sendKeys("Some automation text here...");
        Thread.sleep(2000);
        alertPrompt.accept();

        Thread.sleep(5000);
        driver.quit();
    }

}
