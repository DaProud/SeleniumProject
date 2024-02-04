package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends CommonPage {
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberElement;
    @FindBy(id = "currentAddress")
    private WebElement addressElement;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherGenderElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1'] ")
    private WebElement sportHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2'] ")
    private WebElement readingHobbyElement;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3'] ")
    private WebElement musicHobbyElement;
    //    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    private WebElement subjectsElement;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearOfBirthElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthOfBirthElement;
    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNumber) {
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(emailElement, email);
        elementsMethods.fillElement(addressElement, address);
        elementsMethods.fillElement(mobileNumberElement, mobileNumber);
    }

    public void completeGender(String gender) {
        switch (gender) {
            case "Male":
                elementsMethods.clickOnElement(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElement(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElement(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectWithList(List<String> subjectsList) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, subjectsList);
    }

    public void completeHobbies(List<String> hobbies) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);

        elementsMethods.clickMultipleValues(hobbiesElement, hobbies);
    }

    public void completeDateOfBirth(int year, int month, int day) {
        elementsMethods.clickOnElement(dateOfBirthElement);
        elementsMethods.selectByValue(yearOfBirthElement, String.valueOf(year));
        elementsMethods.selectByValue(monthOfBirthElement, String.valueOf(month - 1));
        javascriptHelpers.scrollDown(400);
        // TODO: refactor this - sa accepte orice date, nu doar cele >=10, din cauza formatului day-001 in xPath
        String dayOfBirthXPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + day + "']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthXPath));
        elementsMethods.clickOnElement(dayOfBirthElement);
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(uploadPictureElement);
    }

    public void completeStateAndCity(String state, String city) {
        javascriptHelpers.forceClick(stateElement);
        elementsMethods.fillElementFollowedByEnter(stateElement, state);

        javascriptHelpers.forceClick(cityElement);
        elementsMethods.fillElementFollowedByEnter(cityElement, city);
    }

    public void submitForm() {
        javascriptHelpers.forceClick(submitElement);
    }
}
