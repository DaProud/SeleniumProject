package demoQAWebsite.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void automationMethod() throws InterruptedException {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        WebElement formsElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsElement.click();

        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormElement.click();

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("document.body.style.zoom = '70%'");

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Daniel";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Mindru";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "daniel@test.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement genderMaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Male";

        if (genderMaleElement.getText().equals(genderValue)) {
            genderMaleElement.click();
        } else if (genderFemaleElement.getText().equals(genderValue)) {
            genderFemaleElement.click();
        } else if (genderOtherElement.getText().equals(genderValue)) {
            genderOtherElement.click();
        }

        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0740696969";
        mobileNumberElement.sendKeys(mobileNumberValue);

        String yearOfBirthValue = "1988";
        String monthOfBirthValue = "March";
        String dayOfBirthValue = "30";

        WebElement dateOfBirthInputElement = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInputElement.click();

        WebElement yearElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue(yearOfBirthValue);

        WebElement monthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText(monthOfBirthValue);

        String dayOfBirthxPath = "//div[@class='react-datepicker__day react-datepicker__day--0" + dayOfBirthValue + "']";
        WebElement dayOfBirthElement = driver.findElement(By.xpath(dayOfBirthxPath));
        dayOfBirthElement.click();


        List<String> subjectValues = new ArrayList<>();
        subjectValues.add("Social Studies");
        subjectValues.add("Maths");
        subjectValues.add("History");

        WebElement subjectsInputElement = driver.findElement(By.id("subjectsInput"));
        for (String subject : subjectValues) {
            subjectsInputElement.sendKeys(subject);
            subjectsInputElement.sendKeys(Keys.ENTER);
        }


        List<String> hobbiesValues = new ArrayList<>();
        hobbiesValues.add("Sports");
        hobbiesValues.add("Music");

        WebElement hobbiesSportsElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement hobbiesReadingElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement hobbiesMusicElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));

        for (String hobby : hobbiesValues) {
            switch (hobby) {
                case "Sports":
                    hobbiesSportsElement.click();
                    break;
                case "Reading":
                    hobbiesReadingElement.click();
                    break;
                case "Music":
                    hobbiesMusicElement.click();
                    break;
                default:
                    System.out.println("Not a valid hobby... Please choose a valid value. :)");
            }
        }

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        String pictureFilePath = "src/test/resources/1.png";
        File file = new File(pictureFilePath);
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue =
            "Targu Mures, Romania" + "\n" +
            "Line 2" + "\n" +
            "Line 3";
        currentAddressElement.sendKeys(currentAddressValue);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
//        stateElement.click();   // -> nu merge direct din Selenium :)

        // Cand nu poti face click pe element (eg o reclama se suprapune) se poate folosi "ciocanul"
        // JavascriptExecutor iti permite sa faci actiuni extra
        javascriptExecutor.executeScript("arguments[0].click();", stateElement);
        String stateValue = "NCR";
        stateElement.sendKeys(stateValue);
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        javascriptExecutor.executeScript("arguments[0].click();", cityElement);
        String cityValue = "Delhi";
        cityElement.sendKeys(cityValue);
        cityElement.sendKeys(Keys.ENTER);


        WebElement submitElement = driver.findElement(By.id("submit"));
        javascriptExecutor.executeScript("arguments[0].click();", submitElement);

        // Tema: Compararea datelor de dupa Submit:

        // Pregatim datele pentru comparari si facem formatarile necesare unde e cazul
        // in functie de cum sunt afisate in pagina de dupa "Submit"
        String expectedStudentName = firstNameValue + " " + lastNameValue;  // eg. "Daniel Mindru"
        String expectedDateOfBirth = String.format("%s %s,%s", dayOfBirthValue, monthOfBirthValue, yearOfBirthValue); // Format: "DD Month,YYYY"
        String expectedSubjects = String.join(", ", subjectValues); // Lista de subiecte concatenata cu virgula si spatiu ", "
        String expectedHobbies = String.join(", ", hobbiesValues); // Lista de hobbies concatenata cu virgula si spatiu ", "

        // Sample: "src/test/resources/1.png";  -> Trebuie sa luam doar ultima parte
        String[] filePathStrings = pictureFilePath.split("/");
        String expectedPicture = filePathStrings[filePathStrings.length - 1];

        String expectedAddress = currentAddressValue.replaceAll("\n", " ");
        String expectedStateAndCity = stateValue + " " + cityValue;

        Map<String, String> expectedValuesMap = new LinkedHashMap<>();
        expectedValuesMap.put("Student Name", expectedStudentName);
        expectedValuesMap.put("Student Email", userEmailValue);
        expectedValuesMap.put("Gender", genderValue);
        expectedValuesMap.put("Mobile", mobileNumberValue);
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
