package Tests;

import ShareData.ShareData;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PracticeFormTest extends ShareData {

    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");
        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion("Daniel", "Mindru", "daniel@test.com", "Tg Mures", "0740696969");
        practiceFormPage.completeGender("Male");
        practiceFormPage.completeDateOfBirth(1988, 3, 30);

        // Subjects:
        List<String> subjectsList = new ArrayList<>();
        subjectsList.add("Social Studies");
        subjectsList.add("Maths");
        subjectsList.add("History");
        practiceFormPage.completeSubjectWithList(subjectsList);

        // Hobbies:
        List<String> hobbiesValues = new ArrayList<>();
        hobbiesValues.add("Sports");
        hobbiesValues.add("Music");
        practiceFormPage.completeHobbies(hobbiesValues);
        practiceFormPage.uploadPicture();
        practiceFormPage.completeStateAndCity("NCR", "Delhi");

        practiceFormPage.submitForm();

        // Tema: Compararea datelor de dupa Submit:

        // Pregatim datele pentru comparari si facem formatarile necesare unde e cazul
        // in functie de cum sunt afisate in pagina de dupa "Submit"
        String expectedStudentName = "Daniel Mindru";
        String expectedEmail = "daniel@test.com";
        String expectedMobileNumber = "0740696969";
        String expectedGender = "Male";
        String expectedDateOfBirth = String.format("%s %s,%s", 30, "March", 1988); // Format: "DD Month,YYYY"
        String expectedSubjects = String.join(", ", subjectsList); // Lista de subiecte concatenata cu virgula si spatiu ", "
        String expectedHobbies = String.join(", ", hobbiesValues); // Lista de hobbies concatenata cu virgula si spatiu ", "

        // Sample: "src/test/resources/1.png";  -> Trebuie sa luam doar ultima parte
        String[] filePathStrings = "src/test/resources/1.png".split("/");
        String expectedPicture = filePathStrings[filePathStrings.length - 1];

        String expectedAddress = "Tg Mures".replaceAll("\n", " ");
        String expectedStateAndCity = "NCR" + " " + "Delhi";

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
