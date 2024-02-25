package pages;

import ObjectData.WebTableObject;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablesPage extends CommonPage {

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableElements;
    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButtonElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    WebElement lastNameElement;
    @FindBy(id = "userEmail")
    WebElement emailElement;
    @FindBy(id = "age")
    WebElement ageElement;
    @FindBy(id = "salary")
    WebElement salaryElement;
    @FindBy(id = "department")
    WebElement departmentElement;
    @FindBy(id = "submit")
    WebElement submitButton;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void addNewRecord() {
        elementsMethods.clickOnElement(addNewRecordButtonElement);
    }

    public void fillRegistrationForm(WebTableObject webTableObject) {
        LoggerUtility.infoLog("The user fills the Registration form");

        elementsMethods.fillElement(firstNameElement, webTableObject.getFirstName());
        LoggerUtility.infoLog("The user fills the First Name");
        elementsMethods.fillElement(lastNameElement, webTableObject.getLastName());
        LoggerUtility.infoLog("The user fills the Last Name");
        elementsMethods.fillElement(emailElement, webTableObject.getEmail());
        LoggerUtility.infoLog("The user fills the Email");
        elementsMethods.fillElement(ageElement, String.valueOf(webTableObject.getAge()));
        LoggerUtility.infoLog("The user fills the Age");
        elementsMethods.fillElement(salaryElement, String.valueOf(webTableObject.getSalary()));
        LoggerUtility.infoLog("The user fills the Salary");
        elementsMethods.fillElement(departmentElement, webTableObject.getDepartment());
        LoggerUtility.infoLog("The user fills the Department");

    }

    public void submitForm() {
        elementsMethods.clickOnElement(submitButton);
        LoggerUtility.infoLog("The user Submits the form");
    }

    public int getCurrentTableSize() {
        return tableElements.size();
    }

    public String getRowContentAsString(int rowIndex) {
        return tableElements.get(rowIndex).getText();
    }
}
