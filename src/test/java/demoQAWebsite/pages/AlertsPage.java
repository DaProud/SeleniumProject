package demoQAWebsite.pages;

import demoQAWebsite.HelperMethods.AlertMethods;
import demoQAWebsite.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends CommonPage{

    @FindBy(id = "alertButton")
    WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    WebElement delayedAlertButtonElement;
    @FindBy(id = "confirmButton")
    WebElement alertConfirmButtonElement;
    @FindBy(id = "promtButton")
    WebElement alertPromptButtonElement;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithSimpleAlert() {
        // Alert simplu: Doar Text si OK button
        elementsMethods.clickOnElement(alertOkButtonElement);
        alertMethods.interactWithAlertOK();
    }

    public void interactWithDelayedAlert() {
        // Alert cu delay la afisare
        elementsMethods.clickOnElement(delayedAlertButtonElement);
        alertMethods.interactWithDelayAlert();
    }

    public void interactWithConfirmAlert(boolean isConfirmed) {
        // Alert cu Confirm - OK/cancel
        elementsMethods.clickOnElement(alertConfirmButtonElement);

        if (isConfirmed) {
            alertMethods.interactWithAlertOK();
        } else {
            alertMethods.interactWithAlertCancel();
        }
    }

    public void interactWithPromptAlert(String inputText, boolean isConfirmed){
        // Alert cu Prompt Text
        elementsMethods.clickOnElement(alertPromptButtonElement);
        if (isConfirmed) {
            alertMethods.interactWithPromptAlertAndConfirm(inputText);
        } else {
            alertMethods.interactWithPromptAlertAndCancel(inputText);
        }

    }
}
