package Tests;

import ObjectData.PracticeFormObject;
import PropertyUtility.PropertyUtility;
import ShareData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class PracticeFormTest extends Hooks {

    private HomePage homePage;
    private CommonPage commonPage;
    private PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormTest");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getData());


        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Forms menu");
        commonPage.goToDesiredSubMenu("Practice Form");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Practice Form menu");

        practiceFormPage.completeFirstRegion(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills the first region");

        practiceFormPage.completeGender(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the gender");
        practiceFormPage.completeDateOfBirth(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the date of birth");
        practiceFormPage.completeSubjectWithList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters the subjects");
        practiceFormPage.completeHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters the hobbies");
        practiceFormPage.uploadPicture();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user uploads the picture");
        practiceFormPage.completeStateAndCity(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the state and city");

        practiceFormPage.submitForm();

        // Tema: Compararea datelor de dupa Submit:

        // Pregatim datele pentru comparari si facem formatarile necesare unde e cazul
        // in functie de cum sunt afisate in pagina de dupa "Submit"
        String expectedStudentName = practiceFormObject.getFirstName() + " " + practiceFormObject.getLastName();  //eg "Cristi Pop";
        String expectedEmail = practiceFormObject.getEmail();
        String expectedMobileNumber = practiceFormObject.getMobileNumber();
        String expectedGender = practiceFormObject.getGender();
//        String expectedDateOfBirth = String.format("%s %s,%s", 30, "March", 1988); // Format: "DD Month,YYYY"
        String expectedDateOfBirth = "30 March,1995"; // Format: "DD Month,YYYY"
        String expectedSubjects = String.join(", ", practiceFormObject.getSubjects()); // Lista de subiecte concatenata cu virgula si spatiu ", "
        String expectedHobbies = String.join(", ", practiceFormObject.getHobbies()); // Lista de hobbies concatenata cu virgula si spatiu ", "

        // Sample: "src/test/resources/1.png";  -> Trebuie sa luam doar ultima parte
        String[] filePathStrings = "src/test/resources/1.png".split("/");
        String expectedPicture = filePathStrings[filePathStrings.length - 1];

        String expectedAddress = practiceFormObject.getAddress().replaceAll("\n", " ");
        String expectedStateAndCity = practiceFormObject.getState() + " " + practiceFormObject.getCity();

        Map<String, String> expectedValuesMap = new LinkedHashMap<>();
        expectedValuesMap.put("Student Name", expectedStudentName);
        expectedValuesMap.put("Student Email", expectedEmail);
        expectedValuesMap.put("Gender", expectedGender);
        expectedValuesMap.put("Mobile", expectedMobileNumber);
        expectedValuesMap.put("Date of Birth", expectedDateOfBirth);
        expectedValuesMap.put("Subjects", expectedSubjects);
        expectedValuesMap.put("Hobbies", expectedHobbies);
        expectedValuesMap.put("Picture", expectedPicture);
        expectedValuesMap.put("Address", expectedAddress);
        expectedValuesMap.put("State and City", expectedStateAndCity);

        int index = 0;
        for (String key : expectedValuesMap.keySet()) {
            String labelElementXPath = "//tbody/tr[" + (index + 1) + "]/td[1]";
            WebElement labelElement = getDriver().findElement(By.xpath(labelElementXPath));
            System.out.println("Label Element: " + labelElement.getText());
            Assert.assertEquals(labelElement.getText(), key);

            String valueElementXPath = "//tbody/tr[" + (index + 1) + "]/td[2]";
            WebElement valueElement = getDriver().findElement(By.xpath(valueElementXPath));
            System.out.println("Value Element: " + valueElement.getText());
            Assert.assertEquals(valueElement.getText(), expectedValuesMap.get(key));

            index++;
        }
//
//        /* Sample table:
//        Student Name	    Daniel Mindru
//        Student Email	    daniel@test.com
//        Gender	            Male
//        Mobile	            0740696969
//        Date of Birth	    30 March,1988
//        Subjects	        Social Studies, Maths, History
//        Hobbies	            Sports, Music
//        Picture	            1.png
//        Address	            Targu Mures, Romania Line 2 Line 3
//        State and City	    NCR Delhi
//
//         */
//
    }
}
