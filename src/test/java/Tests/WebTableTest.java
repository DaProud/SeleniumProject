package Tests;

import ObjectData.WebTableObject;
import PropertyUtility.PropertyUtility;
import ShareData.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablesPage;

public class WebTableTest extends Hooks {

    private HomePage homePage;
    private CommonPage commonPage;
    private WebTablesPage webTablesPage;

    @Test
    public void automationMethod() {
        PropertyUtility propertyUtility = new PropertyUtility("WebTableTest");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getData());

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        webTablesPage = new WebTablesPage(getDriver());

        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");

        int initialTableSize = webTablesPage.getCurrentTableSize();

        webTablesPage.addNewRecord();

        webTablesPage.fillRegistrationForm(webTableObject);
        webTablesPage.submitForm();

        // Validari:
        int finalTableSize = webTablesPage.getCurrentTableSize();
        int expectedTableSize = initialTableSize + 1;
        Assert.assertEquals(finalTableSize, expectedTableSize);

        String actualTableValue = webTablesPage.getRowContentAsString(finalTableSize - 1);

        Assert.assertTrue(actualTableValue.contains(webTableObject.getFirstName()));
        Assert.assertTrue(actualTableValue.contains(webTableObject.getLastName()));
        Assert.assertTrue(actualTableValue.contains(webTableObject.getEmail()));
        Assert.assertTrue(actualTableValue.contains(String.valueOf(webTableObject.getAge())));
        Assert.assertTrue(actualTableValue.contains(String.valueOf(webTableObject.getSalary())));
        Assert.assertTrue(actualTableValue.contains(webTableObject.getDepartment()));
    }

}
