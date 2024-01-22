package demoQAWebsite.Tests;

import demoQAWebsite.HelperMethods.ElementsMethods;
import demoQAWebsite.HelperMethods.JavascriptHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;

    @Test
    public void automationMethod() throws InterruptedException {
        // Deschidem un browser de Chrome :)
        driver = new ChromeDriver();

        // Facem browserul in modul Maximize - pentru a evita repozitionarea
        // elementelor cu marimea default a ferestrei
        driver.manage().window().maximize();

        // Accesam o pagina Web
        driver.get("https://demoqa.com/");

        elementsMethods = new ElementsMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);

        // Facem un scroll ca sa fie elementul vizibil
        // in caz ca nu incape pe pagina:)
        // JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta :)
        javascriptHelpers.scrollDown(400);

        // Declaram un element
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.clickOnElement(elementsField);

        WebElement webTablesField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethods.clickOnElement(webTablesField);

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int actualTableSize = tableElements.size();

        WebElement addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickOnElement(addNewRecordButton);

        // Declararea valorilor cu care se populeaza formul
        String firstNameValue = "Daniel";
        String lastNameValue = "Mindru";
        String emailValue = "daniel@test.com";
        String ageValue = "35";
        String salaryValue = "10000";
        String departmentValue = "Marketing";

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameField, firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameField, lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailField, emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        elementsMethods.fillElement(ageField,  ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        elementsMethods.fillElement(salaryField, salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        elementsMethods.fillElement(departmentField, departmentValue);

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElement(submitButton);

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer expectedTableSize = actualTableSize +1;

        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

        Thread.sleep(3000);
        driver.close();

    }

}
