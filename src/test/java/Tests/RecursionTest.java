package Tests;

import ShareData.ShareData;
import pages.CommonPage;
import pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class RecursionTest extends ShareData {

    private HomePage homePage;
    private CommonPage commonPage;

    @Test
    public void parcurgereLista() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

        // Decalam elementele prin Drag and Drop
        Actions actions = new Actions(getDriver());
        String listElementsXPath = "//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']";
        List<WebElement> elementsList = getDriver().findElements(By.xpath(listElementsXPath));
        for (int i = 0; i < elementsList.size() - 1; i++) {
            WebElement currentElement = elementsList.get(i);
            WebElement nextElement = elementsList.get(i + 1);
            System.out.println("Element: " + currentElement.getText());
            actions.clickAndHold(currentElement)
                .moveToElement(nextElement)
                .release()
                .build()
                .perform();
        }
    }

}
