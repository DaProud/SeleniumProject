package tests;

import ShareData.ShareData;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends ShareData {

    private HomePage homePage;
    private CommonPage commonPage;
    private WebTablesPage webTablesPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        webTablesPage = new WebTablesPage(getDriver());

        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");

        int initialTableSize = webTablesPage.getCurrentTableSize();

        webTablesPage.addNewRecord();

        // Declararea valorilor cu care se populeaza formul
        String firstNameValue = "Daniel";
        String lastNameValue = "Mindru";
        String emailValue = "daniel@test.com";
        String ageValue = "35";
        String salaryValue = "10000";
        String departmentValue = "Marketing";

        webTablesPage.fillRegistrationForm(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);
        webTablesPage.submitForm();

        // Validari:
        int finalTableSize = webTablesPage.getCurrentTableSize();
        int expectedTableSize = initialTableSize + 1;
        Assert.assertEquals(finalTableSize, expectedTableSize);

        String actualTableValue = webTablesPage.getRowContentAsString(finalTableSize - 1);

        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));
    }

}
