package pages;

import ObjectData.PracticeFormObject;
import logger.LoggerUtility;
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

    public void completeFirstRegion(PracticeFormObject practiceFormObject) {
        LoggerUtility.infoLog("The user completes the First region");

        elementsMethods.fillElement(firstNameElement, practiceFormObject.getFirstName());
        LoggerUtility.infoLog("The user completes the First Name");
        elementsMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        LoggerUtility.infoLog("The user completes the Last Name");
        elementsMethods.fillElement(emailElement, practiceFormObject.getEmail());
        LoggerUtility.infoLog("The user completes the Email");
        elementsMethods.fillElement(addressElement, practiceFormObject.getAddress());
        LoggerUtility.infoLog("The user completes the Address");
        elementsMethods.fillElement(mobileNumberElement, practiceFormObject.getMobileNumber());
        LoggerUtility.infoLog("The user completes the Mobile number");

    }

    public void completeGender(PracticeFormObject practiceFormObject) {
        switch (practiceFormObject.getGender()) {
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
        LoggerUtility.infoLog("The user selects the gender");
    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectWithList(PracticeFormObject practiceFormObject) {
        elementsMethods.clickOnElement(subjectsElement);
        LoggerUtility.infoLog("The user clicks on the subjectsElement");
        elementsMethods.fillMultipleValues(subjectsElement, practiceFormObject.getSubjects());
        LoggerUtility.infoLog("The user fills the subjects list");
    }

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);

        elementsMethods.clickMultipleValues(hobbiesElement, practiceFormObject.getHobbies());
        LoggerUtility.infoLog("The user selects the hobbies");
    }

    public void completeDateOfBirth(PracticeFormObject practiceFormObject) {
        int dayOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[0]);
        int monthOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[1]);
        int yearOfBirth = Integer.parseInt(practiceFormObject.getDateOfBirth()[2]);

        elementsMethods.clickOnElement(dateOfBirthElement);
        LoggerUtility.infoLog("The user clicks on dateOfBirthElement");
        elementsMethods.selectByValue(yearOfBirthElement, String.valueOf(yearOfBirth));
        LoggerUtility.infoLog("The user selects the year");
        elementsMethods.selectByValue(monthOfBirthElement, String.valueOf(monthOfBirth - 1));
        LoggerUtility.infoLog("The user selects the month");
        javascriptHelpers.scrollDown(400);
        // TODO: refactor this - sa accepte orice date, nu doar cele >=10, din cauza formatului day-001 in xPath
        String dayOfBirthXPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + dayOfBirth + "']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthXPath));
        elementsMethods.clickOnElement(dayOfBirthElement);
        LoggerUtility.infoLog("The user selects the day");
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(uploadPictureElement);
        LoggerUtility.infoLog("The user uploads a picture");
    }

    public void completeStateAndCity(PracticeFormObject practiceFormObject) {
        javascriptHelpers.forceClick(stateElement);
        LoggerUtility.infoLog("The user clicks on the State element");
        elementsMethods.fillElementFollowedByEnter(stateElement, practiceFormObject.getState());
        LoggerUtility.infoLog("The user fills the State");

        javascriptHelpers.forceClick(cityElement);
        LoggerUtility.infoLog("The user clicks on the City element");
        elementsMethods.fillElementFollowedByEnter(cityElement, practiceFormObject.getCity());
        LoggerUtility.infoLog("The user fills the City");
    }

    public void submitForm() {
        javascriptHelpers.forceClick(submitElement);
        LoggerUtility.infoLog("The user Submits the form");
    }
}
