package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import demoQAWebsite.pages.CommonPage;
import demoQAWebsite.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PracticeFormTest {

    WebDriver driver;
    ElementsMethods elementMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void automationMethod() throws InterruptedException {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        elementMethods = new ElementsMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

//        // Facem un scroll ca sa fie elementul vizibil
//        // in caz ca nu incape pe pagina:)
//        javascriptHelpers.scrollDown(400);
//
////        WebElement formsElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
////        elementMethods.clickOnElement(formsElement);
//
//        List<WebElement> elements = driver.findElements(By.xpath("//h5"));
//        elementMethods.selectElementFromListByText(elements, "Forms");
        homePage.goToDesiredMenu("Forms");

//        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        elementMethods.clickOnElement(practiceFormElement);

//        List<WebElement> subElementsList = driver.findElements(By.xpath("//span[@class='text']"));
//        elementMethods.selectElementFromListByText(subElementsList, "Practice Form");

        commonPage.goToDesiredSubMenu("Practice Form");


//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("document.body.style.zoom = '70%'");
        javascriptHelpers.scrollDown(400);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementMethods.fillElement(firstNameElement, "Daniel");

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementMethods.fillElement(lastNameElement, "Mindru");

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        elementMethods.fillElement(userEmailElement, "daniel@test.com");

        WebElement genderMaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderElements = new ArrayList<>();
        genderElements.add(genderMaleElement);
        genderElements.add(genderFemaleElement);
        genderElements.add(genderOtherElement);

        elementMethods.selectElementFromListByText(genderElements, "Male");

        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementMethods.fillElement(mobileNumberElement, "0740696969");

        // Date of Birth:
        String yearOfBirthValue = "1988";
        String monthOfBirthValue = "March";
        String dayOfBirthValue = "30";

        WebElement dateOfBirthInputElement = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInputElement.click();
        javascriptHelpers.scrollDown(400);

        WebElement yearElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        elementMethods.selectByValue(yearElement, yearOfBirthValue);

        WebElement monthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        elementMethods.selectByVisibleText(monthElement, monthOfBirthValue);

        String dayOfBirthxPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + dayOfBirthValue + "']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthxPath));
        elementMethods.clickOnElement(dayOfBirthElement);


        // Subjects:
        List<String> subjectValues = new ArrayList<>();
        subjectValues.add("Social Studies");
        subjectValues.add("Maths");
        subjectValues.add("History");

        WebElement subjectsInputElement = driver.findElement(By.id("subjectsInput"));
        elementMethods.fillMultipleValues(subjectsInputElement, subjectValues);

        // Hobbies:
        List<String> hobbiesValues = new ArrayList<>();
        hobbiesValues.add("Sports");
        hobbiesValues.add("Music");

        WebElement hobbiesSportsElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement hobbiesReadingElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement hobbiesMusicElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        List<WebElement>  hobbyElements = new ArrayList<>();
        hobbyElements.add(hobbiesSportsElement);
        hobbyElements.add(hobbiesReadingElement);
        hobbyElements.add(hobbiesMusicElement);

        elementMethods.checkMultipleElementsByListOfValues(hobbyElements, hobbiesValues);

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        elementMethods.uploadPicture(uploadPictureElement);

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue =
            "Targu Mures, Romania" + "\n" +
                "Line 2" + "\n" +
                "Line 3";
        elementMethods.fillElement(currentAddressElement, currentAddressValue);

        // State:
        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        // Cand nu poti face click pe element (eg o reclama se suprapune) se poate folosi "ciocanul"
        // JavascriptExecutor iti permite sa faci actiuni extra
        javascriptHelpers.forceClick(stateElement);
        elementMethods.fillElementWithEnter(stateElement, "NCR");

        // City:
        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        javascriptHelpers.forceClick(cityElement);
        elementMethods.fillElementWithEnter(cityElement, "Delhi");

        // Submit Form:
        WebElement submitElement = driver.findElement(By.id("submit"));
        javascriptHelpers.forceClick(submitElement);

        // Tema: Compararea datelor de dupa Submit:

        // Pregatim datele pentru comparari si facem formatarile necesare unde e cazul
        // in functie de cum sunt afisate in pagina de dupa "Submit"
        String expectedStudentName = "Daniel Mindru";
        String expectedEmail = "daniel@test.com";
        String expectedMobileNumber = "0740696969";
        String expectedGender = "Male";
        String expectedDateOfBirth = String.format("%s %s,%s", dayOfBirthValue, monthOfBirthValue, yearOfBirthValue); // Format: "DD Month,YYYY"
        String expectedSubjects = String.join(", ", subjectValues); // Lista de subiecte concatenata cu virgula si spatiu ", "
        String expectedHobbies = String.join(", ", hobbiesValues); // Lista de hobbies concatenata cu virgula si spatiu ", "

        // Sample: "src/test/resources/1.png";  -> Trebuie sa luam doar ultima parte
        String[] filePathStrings = "src/test/resources/1.png".split("/");
        String expectedPicture = filePathStrings[filePathStrings.length - 1];

        String expectedAddress = currentAddressValue.replaceAll("\n", " ");
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
            WebElement labelElement = driver.findElement(By.xpath(labelElementXPath));
            System.out.println("Label Element: " + labelElement.getText());
            Assert.assertEquals(labelElement.getText(), key);

            String valueElementXPath = "//tbody/tr[" + (index + 1) + "]/td[2]";
            WebElement valueElement = driver.findElement(By.xpath(valueElementXPath));
            System.out.println("Value Element: " + valueElement.getText());
            Assert.assertEquals(valueElement.getText(), expectedValuesMap.get(key));

            index++;
        }

        /* Sample table:
        Student Name	    Daniel Mindru
        Student Email	    daniel@test.com
        Gender	            Male
        Mobile	            0740696969
        Date of Birth	    30 March,1988
        Subjects	        Social Studies, Maths, History
        Hobbies	            Sports, Music
        Picture	            1.png
        Address	            Targu Mures, Romania Line 2 Line 3
        State and City	    NCR Delhi

         */

        Thread.sleep(10000);
        driver.close();

    }
}
