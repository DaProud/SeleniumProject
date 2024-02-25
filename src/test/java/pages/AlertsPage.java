package pages;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends CommonPage {

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement delayedAlertButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertConfirmButtonElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptButtonElement;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithSimpleAlert() {
        // Alert simplu: Doar Text si OK button
        elementsMethods.clickOnElement(alertOkButtonElement);
        LoggerUtility.infoLog("The user clicks on alertOkButtonElement");
        alertMethods.interactWithAlertOK();
        LoggerUtility.infoLog("The user interacts with the Simple alert");
    }

    public void interactWithDelayedAlert() {
        // Alert cu delay la afisare
        elementsMethods.clickOnElement(delayedAlertButtonElement);
        LoggerUtility.infoLog("The user clicks on delayedAlertButtonElement");
        alertMethods.interactWithDelayAlert();
        LoggerUtility.infoLog("The user interacts with the Delayed alert");
    }

    public void interactWithConfirmAlert(boolean isConfirmed) {
        // Alert cu Confirm - OK/cancel
        elementsMethods.clickOnElement(alertConfirmButtonElement);
        LoggerUtility.infoLog("The user clicks on alertConfirmButtonElement");

        if (isConfirmed) {
            alertMethods.interactWithAlertOK();
            LoggerUtility.infoLog("The user Accepts the alert");
        } else {
            alertMethods.interactWithAlertCancel();
            LoggerUtility.infoLog("The user Cancels the alert");
        }
    }

    public void interactWithPromptAlert(String inputText, boolean isConfirmed) {
        // Alert cu Prompt Text
        elementsMethods.clickOnElement(alertPromptButtonElement);
        LoggerUtility.infoLog("The user clicks on alertPromptButtonElement");
        if (isConfirmed) {
            alertMethods.interactWithPromptAlertAndConfirm(inputText);
            LoggerUtility.infoLog("The user Accepts the Prompt alert with the text: " + inputText);
        } else {
            alertMethods.interactWithPromptAlertAndCancel(inputText);
            LoggerUtility.infoLog("The user Cancels the Prompt alert with the text: " + inputText);
        }

    }
}
