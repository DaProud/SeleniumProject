package demoQAWebsite.HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void interactWithAlertOK() {
        // ne mutam cu focusul pe alerta deschisa
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void interactWithAlertCancel() {
        // ne mutam cu focusul pe alerta deschisa
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }


    public void explicitAlertWait() {
        // Definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interactWithDelayAlert() {
        explicitAlertWait();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void interactWithPromptAlertOK(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

}
