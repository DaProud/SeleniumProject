package pages;

import ObjectData.PracticeFormObject;
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
        elementsMethods.fillElement(firstNameElement, practiceFormObject.getFirstName());
        elementsMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        elementsMethods.fillElement(emailElement, practiceFormObject.getEmail());
        elementsMethods.fillElement(addressElement, practiceFormObject.getAddress());
        elementsMethods.fillElement(mobileNumberElement, practiceFormObject.getMobileNumber());
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
    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectWithList(PracticeFormObject practiceFormObject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillMultipleValues(subjectsElement, practiceFormObject.getSubjects());
    }

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        List<WebElement> hobbiesElement = new ArrayList<>();
        hobbiesElement.add(sportHobbyElement);
        hobbiesElement.add(musicHobbyElement);
        hobbiesElement.add(readingHobbyElement);

        elementsMethods.clickMultipleValues(hobbiesElement, practiceFormObject.getHobbies());
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

    public void completeStateAndCity(PracticeFormObject practiceFormObject) {
        javascriptHelpers.forceClick(stateElement);
        elementsMethods.fillElementFollowedByEnter(stateElement, practiceFormObject.getState());

        javascriptHelpers.forceClick(cityElement);
        elementsMethods.fillElementFollowedByEnter(cityElement, practiceFormObject.getCity());
    }

    public void submitForm() {
        javascriptHelpers.forceClick(submitElement);
    }
}
