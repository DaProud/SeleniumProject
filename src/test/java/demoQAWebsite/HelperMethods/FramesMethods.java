package demoQAWebsite.HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {

    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement element) {
        // Schimbam focusul pe un frame anume
        driver.switchTo().frame(element);
    }

    public void switchToMainContent() {
        // Ne ducem cu focusul inapoi pe pagina principala
        driver.switchTo().defaultContent();
    }

}
