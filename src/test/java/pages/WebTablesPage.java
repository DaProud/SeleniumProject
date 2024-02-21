package pages;

import ObjectData.WebTableObject;
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
        elementsMethods.fillElement(firstNameElement, webTableObject.getFirstName());
        elementsMethods.fillElement(lastNameElement, webTableObject.getLastName());
        elementsMethods.fillElement(emailElement, webTableObject.getEmail());
        elementsMethods.fillElement(ageElement, String.valueOf(webTableObject.getAge()));
        elementsMethods.fillElement(salaryElement, String.valueOf(webTableObject.getSalary()));
        elementsMethods.fillElement(departmentElement, webTableObject.getDepartment());
    }

    public void submitForm() {
        elementsMethods.clickOnElement(submitButton);
    }

    public int getCurrentTableSize() {
        return tableElements.size();
    }

    public String getRowContentAsString(int rowIndex) {
        return tableElements.get(rowIndex).getText();
    }
}
