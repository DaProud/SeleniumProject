package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablesPage extends CommonPage {

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    List<WebElement> tableElements;
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButtonElement;
    @FindBy(id = "firstName")
    WebElement firstNameElement;
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

    public void fillRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(emailElement, email);
        elementsMethods.fillElement(ageElement, age);
        elementsMethods.fillElement(salaryElement, salary);
        elementsMethods.fillElement(departmentElement, department);
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
